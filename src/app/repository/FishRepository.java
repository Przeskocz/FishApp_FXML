package app.repository;

import database.MySqlDB;
import model.Fish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class FishRepository {

    public static List<Fish> getAllFish() {
        List<Fish> returnedListOfFish = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        String query = " SELECT * FROM fish ";
        Connection conn = MySqlDB.getConnection();

        try {
            pstm = conn.prepareStatement(query);
            resultSet = pstm.executeQuery();

            while(resultSet.next()) {
                long fishId = resultSet.getLong("fish_id");
                String fishSpecies = resultSet.getString("fish_species");
                String fishType = resultSet.getString("fish_type");
                int fishWeightFrom = resultSet.getInt("fish_weight_from");
                int fishWeightTo = resultSet.getInt("fish_weight_to");

                Fish odczytanaRyba = new Fish(fishId, fishSpecies, Fish.TypeOfFish.fromString(fishType), fishWeightFrom,
                        fishWeightTo);

                returnedListOfFish.add(odczytanaRyba);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySqlDB.close(resultSet);
            MySqlDB.close(pstm);
        }

        return returnedListOfFish;
    }

    public static List<Fish> getAllFishByPiscaryId(long piscaryId) {
        List<Fish> returnedListOfFish = new ArrayList<>();

        PreparedStatement pstmFish = null;
        ResultSet resultSetFish = null;

        String sqlForFish = " SELECT * FROM fish " +
                " JOIN connect_fish_piscary ON fish.fish_id = connect_fish_piscary.cfp_fish_id " +
                " JOIN piscary ON piscary.piscary_id = connect_fish_piscary.cfp_piscary_id " +
                " WHERE " +
                "   piscary.piscary_id = ? ";

        Connection conn = MySqlDB.getConnection();

        try {
        pstmFish = conn.prepareStatement(sqlForFish);
        pstmFish.setLong(1, piscaryId);
        resultSetFish = pstmFish.executeQuery(); //SELECT

        while(resultSetFish.next()) {
            long fishId = resultSetFish.getLong("fish_id");
            String fishSpecies = resultSetFish.getString("fish_species");
            String fishType = resultSetFish.getString("fish_type");
            int fishWeightFrom = resultSetFish.getInt("fish_weight_from");
            int fishWeightTo = resultSetFish.getInt("fish_weight_to");

            Fish odczytanaRyba = new Fish(fishId, fishSpecies, Fish.TypeOfFish.fromString(fishType), fishWeightFrom,
                    fishWeightTo);

            returnedListOfFish.add(odczytanaRyba);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySqlDB.close(resultSetFish);
            MySqlDB.close(pstmFish);
        }

        return returnedListOfFish;
    }
}

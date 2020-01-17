package database.example;

import database.MySqlDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("Duplicates")
public class SelectWithJoinExample {

    public static void main(String[] args) {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        int piscaryId = 4; //wybrane przez użytkownika
        Connection conn = MySqlDB.getConnection();
        String query = " SELECT * FROM fish A " +
                            " JOIN connect_fish_piscary B ON A.fish_id = B.cfp_fish_id " +
                            " JOIN piscary C ON B.cfp_piscary_id = C.piscary_id " +
                        " WHERE piscary_id = ? ";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, piscaryId);

            resultSet = pstm.executeQuery();

            while(resultSet.next()) {
                long fishId = resultSet.getLong("fish_id");
                String fishSpecies = resultSet.getString("fish_species");
                String fishType = resultSet.getString("fish_type");
                int fishWeightFrom = resultSet.getInt("fish_weight_from");
                int fishWeightTo = resultSet.getInt("fish_weight_to");

                System.out.println(fishId + ", " + fishSpecies + ", " + fishType + ", "
                        + fishWeightFrom + ", " + fishWeightTo + "\n");
            }
        } catch (Exception e) {
            System.out.println("SelectWithJoinExample.main() exception! " + e);
        } finally {
            MySqlDB.close(resultSet);
            MySqlDB.close(pstm);
            MySqlDB.close();
        }
    }
}

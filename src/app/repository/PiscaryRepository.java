package app.repository;

import database.MySqlDB;
import model.Piscary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PiscaryRepository {

    public static List<Piscary> getAllPiscary() {
        List<Piscary> returnedListOfPiscary = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        Connection conn = MySqlDB.getConnection();

        String query = " SELECT * FROM piscary ";
        try {
            pstm = conn.prepareStatement(query);
            resultSet = pstm.executeQuery();

            while(resultSet.next()) {
                long piscary_id = resultSet.getLong("piscary_id");
                double piscary_area = resultSet.getDouble("piscary_area");
                String piscary_name = resultSet.getString("piscary_name");
                String piscary_address = resultSet.getString("piscary_address");
                String piscary_contact = resultSet.getString("piscary_contact");
                int piscary_hour_from = resultSet.getInt("piscary_hour_from");
                int piscary_hour_to = resultSet.getInt("piscary_hour_to");
                int piscary_price_day = resultSet.getInt("piscary_price_day");
                int piscary_price_night = resultSet.getInt("piscary_price_night");
                int piscary_count_rod = resultSet.getInt("piscary_count_rod");
                boolean piscary_booking_slot = resultSet.getBoolean("piscary_booking_slot");
                String piscary_effective_bait = resultSet.getString("piscary_effective_bait");

                Piscary odczytaneLowisko = new Piscary(piscary_id, piscary_area, piscary_name, piscary_address, piscary_contact,
                        new HashSet<>(),piscary_hour_from, piscary_hour_to, piscary_price_day, piscary_price_night, piscary_count_rod,
                        piscary_booking_slot, piscary_effective_bait.split(","));

                // Dodaje do łowiska wszystkie powiązane z nim ryby
                odczytaneLowisko.addNewFishes(FishRepository.getAllFishByPiscaryId(piscary_id));

                returnedListOfPiscary.add(odczytaneLowisko);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySqlDB.close(resultSet);
            MySqlDB.close(pstm);
        }

        return returnedListOfPiscary;
    }
}

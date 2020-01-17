package database.example;

import database.MySqlDB;
import app.model.Fish;
import app.model.Piscary;

import java.sql.*;
import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class InsertExample {

    public static void main(String[] args) {
        PreparedStatement pstm = null;
        Piscary nowyStaw = new Piscary(1,6.4, "Hurko", "Przemyśl 43" , "+48 839 843 754", new HashSet<Fish>(), 7,
        19, 25, 25, 2, true, new String[]{"kukurydza","kulki truskawkowe","pellet Halibut"});
        Connection conn = MySqlDB.getConnection();
        String query = " INSERT INTO piscary (piscary_id, piscary_area, piscary_name, piscary_address, piscary_contact," +
                            " piscary_hour_from, piscary_hour_to, piscary_price_day, piscary_price_night, piscary_count_rod, " +
                            "piscary_booking_slot, piscary_effective_bait) " +
                         " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setNull(1, Types.INTEGER);
            pstm.setDouble(2, nowyStaw.getArea());
            pstm.setString(3, nowyStaw.getName());
            pstm.setString(4, nowyStaw.getAddress());
            pstm.setString(5, nowyStaw.getContact());
            pstm.setInt(6, nowyStaw.getHourFrom());
            pstm.setInt(7, nowyStaw.getHourTo());
            pstm.setInt(8, nowyStaw.getPriceDay());
            pstm.setInt(9, nowyStaw.getPriceNight());
            pstm.setInt(10, nowyStaw.getCountRod());
            pstm.setBoolean(11, nowyStaw.isBookingSlot());
            pstm.setString(12, Arrays.toString(nowyStaw.getEffectiveBait()));

            pstm.execute();

        } catch (Exception e) {
            System.out.println("InsertExample.main() exception! " + e);
        } finally {
            MySqlDB.close(pstm);
            MySqlDB.close();
        }
    }
}

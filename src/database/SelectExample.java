package database;

import model.Fish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectExample {

    public static void main(String[] args) {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;

        Connection conn = MySqlDB.getConnection();
        String query = " SELECT fish_id, fish_species, fish_type, " +
                " fish_weight_from, fish_weight_to FROM fish ";
        try {
            pstm = conn.prepareStatement(query);
            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                long fishId = resultSet.getLong("fish_id");
                String fishSpecies = resultSet.getString("fish_species");
                String fishType = resultSet.getString("fish_type");
                int fishWeightFrom = resultSet.getInt("fish_weight_from");
                int fishWeightTo = resultSet.getInt("fish_weight_to");

                System.out.println(fishId + ", " + fishSpecies + ", " + fishType + ", "
                        + fishWeightFrom + ", " + fishWeightTo + "\n");
            }
        } catch (Exception e) {
            System.out.println("SelectExample.main() exception! " + e);
        } finally {
            MySqlDB.close(resultSet);
            MySqlDB.close(pstm);
            MySqlDB.close();
        }
    }
}

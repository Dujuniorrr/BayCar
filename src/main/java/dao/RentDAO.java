package dao;

import model.Rent;

public class RentDAO {
    public Rent recoverRent(String id) {
        String sql = "SELECT * FROM rent WHERE id = ?";

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

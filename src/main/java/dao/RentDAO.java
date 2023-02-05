package dao;

import model.Client;
import model.Rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RentDAO {

    public void addRentOfOlderCar(Rent rent, String idOlderCar){
        String sql = "INSERT INTO rent(date_rent, id_older_car, id_client) VALUES (?, ?, ?)";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, rent.getDate());
            pst.setString(2, idOlderCar);
            pst.setString(3,rent.getClient().getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editRentOfOlderCar(Rent rent, String idOlderCar){
        String sql = "UPDATE rent SET date_rent = ?, date_devolution = ?, mileage =?, id_client =? WHERE id_older_car = ?";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, rent.getDate());
            pst.setDate(2, rent.getDateDevolution());
            pst.setFloat(1, rent.getMileage());
            pst.setString(3,rent.getClient().getId());
            pst.setString(4, idOlderCar);
            pst.executeUpdate();
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void recoverRentByOlderCar(Rent rent, String idOlderCar){
        String sql = "SELECT * FROM rent WHERE id_older_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idOlderCar);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                rent.setDate(rs.getDate("date_rent"));
                rent.setDateDevolution(rs.getDate("date_devolution"));
                rent.setMileage(rs.getFloat("mileage"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                rent.setClient(client);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Rent> listRentByOlderCar(String idOlderCar){
        ArrayList<Rent> rents = new ArrayList<Rent>();
        String sql = "SELECT * FROM rent WHERE id_older_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idOlderCar);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                Rent rent = new Rent();
                rent.setId(rs.getString("id"));
                rent.setDate(rs.getDate("date_rent"));
                rent.setDateDevolution(rs.getDate("date_devolution"));
                rent.setMileage(rs.getFloat("mileage"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                rent.setClient(client);
                rents.add(rent);
            }

            con.close();
            return rents;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

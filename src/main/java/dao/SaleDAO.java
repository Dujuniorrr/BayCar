package dao;

import model.Client;
import model.Rent;
import model.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SaleDAO {

    public void addSaleOfOlderCar(Sale sale, String idOlderCar){
        String sql = "INSERT INTO sale(date_sale, id_older_car, value_sale, parcel, id_client) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, sale.getDate());
            pst.setString(2, idOlderCar);
            pst.setFloat(3, sale.getValue());
            pst.setInt(4, sale.getParcel());
            pst.setString(5, sale.getClient().getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editSaleOfOlderCar(Sale sale, String idOlderCar){
        String sql = "UPDATE sale SET date_sale = ?, id_client =?, value_sale = ?, parcel = ? WHERE id_older_car = ?";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, sale.getDate());
            pst.setString(2,sale.getClient().getId());
            pst.setFloat(3, sale.getValue());
            pst.setInt(4, sale.getParcel());
            pst.setString(5, idOlderCar);
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void recoverSaleByOlderCar(Sale sale, String idOlderCar){
        String sql = "SELECT * FROM sale WHERE id_older_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idOlderCar);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                sale.setId(rs.getString("id"));
                sale.setDate(rs.getDate("date_sale"));
                sale.setParcel(rs.getInt("parcel"));
                sale.setValue(rs.getFloat("value_sale"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                sale.setClient(client);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Sale> listRentByOlderCar(String idOlderCar){
        ArrayList<Sale> sales = new ArrayList<Sale>();
        String sql = "SELECT * FROM sale WHERE id_older_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idOlderCar);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                Sale sale = new Sale();
                sale.setId(rs.getString("id"));
                sale.setDate(rs.getDate("date_sale"));
                sale.setParcel(rs.getInt("parcel"));
                sale.setValue(rs.getFloat("value_sale"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                sale.setClient(client);
                sales.add(sale);
            }

            con.close();
            return sales;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addSaleOfCar(Sale sale, String idCar){
        String sql = "INSERT INTO sale(date_sale, id_car, value_sale, parcel, id_client) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, sale.getDate());
            pst.setString(2, idCar);
            pst.setFloat(3, sale.getValue());
            pst.setInt(4, sale.getParcel());
            pst.setString(5, sale.getClient().getId());
            pst.executeUpdate();
            sql = "UPDATE car SET state = 'Vendido' WHERE id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, idCar);
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editSaleOfCar(Sale sale, String idCar){
        String sql = "UPDATE sale SET date_sale = ?, id_client =?, value_sale = ?, parcel = ? WHERE id_car = ?";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, sale.getDate());
            pst.setString(2,sale.getClient().getId());
            pst.setFloat(3, sale.getValue());
            pst.setInt(4, sale.getParcel());
            pst.setString(5, idCar);
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void recoverSaleByCar(Sale sale, String idCar){
        String sql = "SELECT * FROM sale WHERE id_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idCar);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                sale.setId(rs.getString("id"));
                sale.setDate(rs.getDate("date_sale"));
                sale.setParcel(rs.getInt("parcel"));
                sale.setValue(rs.getFloat("value_sale"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                sale.setClient(client);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Sale> listRentByCar(String idCar){
        ArrayList<Sale> sales = new ArrayList<Sale>();
        String sql = "SELECT * FROM sale WHERE id_car = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idCar);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                Sale sale = new Sale();
                sale.setId(rs.getString("id"));
                sale.setDate(rs.getDate("date_sale"));
                sale.setParcel(rs.getInt("parcel"));
                sale.setValue(rs.getFloat("value_sale"));
                Client client = new Client();
                client.recoverClient(rs.getString("id_client"));
                sale.setClient(client);
                sales.add(sale);
            }

            con.close();
            return sales;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

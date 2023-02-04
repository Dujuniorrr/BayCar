package dao;

import model.Car;
import model.OlderCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OlderCarDAO {

    public void addCar(OlderCar olderCar){
        String sql = "INSERT INTO older_car(name, value_car, year_car, path_img, description, mark, model, state, mileage)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, olderCar.getName());
            pst.setFloat(2, olderCar.getValue());
            pst.setInt(3, olderCar.getYear());
            pst.setString(4, olderCar.getPathImage());
            pst.setString(5, olderCar.getDesc());
            pst.setString(6, olderCar.getMark());
            pst.setString(7, olderCar.getModel());
            pst.setString(8, olderCar.getState());
            pst.setString(8, olderCar.getState());
            pst.setFloat(9, olderCar.getMileage());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editCar(OlderCar olderCar){
        String sql = "UPDATE older_car SET name = ?, value_car = ?, year_car = ?, " +
                "path_img = ? , description = ?, mark = ? , model = ? , state = ?, mileage = ? WHERE id = ?";;
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, olderCar.getName());
            pst.setFloat(2, olderCar.getValue());
            pst.setInt(3, olderCar.getYear());
            pst.setString(4, olderCar.getPathImage());
            pst.setString(5, olderCar.getDesc());
            pst.setString(6, olderCar.getMark());
            pst.setString(7, olderCar.getModel());
            pst.setString(8, olderCar.getState());
            pst.setFloat(9, olderCar.getMileage());
            pst.setString(10, olderCar.getId());
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCar(String id){
        String sql = "DELETE FROM older_car WHERE id = ?";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rst = ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void recoverOlderCar(OlderCar olderCar){
        String sql = "SELECT * FROM older_car WHERE id = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, olderCar.getId());

            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                olderCar.setName(rs.getString("name"));
                olderCar.setYear(rs.getInt("year_car"));
                olderCar.setId(rs.getString("id"));
                olderCar.setValue(rs.getFloat("value_car"));
                olderCar.setPathImage(rs.getString("path_img"));
                olderCar.setDesc(rs.getString("description"));
                olderCar.setMark(rs.getString("mark"));
                olderCar.setModel(rs.getString("model"));
                olderCar.setMileage(rs.getFloat("mileage"));
                olderCar.setState(rs.getString("state"));
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<OlderCar> listOlderCar(){
        ArrayList<OlderCar> olderCars = new ArrayList<OlderCar>();
        String sql = "SELECT * FROM older_car";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                OlderCar car = new OlderCar();
                car.setName(rs.getString("name"));
                car.setYear(rs.getInt("year_car"));
                car.setId(rs.getString("id"));
                car.setValue(rs.getFloat("value_car"));
                car.setPathImage(rs.getString("path_img"));
                car.setDesc(rs.getString("description"));
                car.setMark(rs.getString("mark"));
                car.setModel(rs.getString("model"));
                car.setMileage(rs.getFloat("mileage"));
                car.setState(rs.getString("state"));
                olderCars.add(car);
            }
            con.close();
            return olderCars;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

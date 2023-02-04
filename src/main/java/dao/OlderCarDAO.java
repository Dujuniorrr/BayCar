package dao;

import model.OlderCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OlderCarDAO {
    public OlderCar recoverOlderCar(String id){
        OlderCar car = new OlderCar();
        String sql = "SELECT * FROM older_car WHERE id = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                car.setName(rs.getString("name"));
                car.setYear(rs.getInt("year_car"));
                car.setId(rs.getString("id"));
                car.setValue(rs.getFloat("value_car"));
                car.setPathImage(rs.getString("path_img"));
                car.setDesc(rs.getString("description"));
                car.setMark(rs.getString("mark"));
                car.setModel(rs.getString("model"));
                car.setMileage(rs.getInt("mileage"));
                car.setState(rs.getString("state"));
                car.setClient(new ClientDAO().recoverClient(rs.getString("id_client")));

                con.close();
                return car;
            } else {
                con.close();
                return null;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
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
                car.setMileage(rs.getInt("mileage"));
                car.setState(rs.getString("state"));
                car.setClient(new ClientDAO().recoverClient(rs.getString("id_client")));

                olderCars.add(car);
            }
            con.close();
            return olderCars;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

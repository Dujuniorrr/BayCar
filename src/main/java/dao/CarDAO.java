package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.*;

public class CarDAO {
    public Car recoverCar(String id){
        Car car = new Car();
        String sql = "SELECT * FROM car WHERE id = ?";

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

    public ArrayList<Car> listCar(){
        ArrayList<Car> cars = new ArrayList<Car>();
        String sql = "SELECT * FROM car";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Car car = new Car();
                car.setName(rs.getString("name"));
                car.setYear(rs.getInt("year_car"));
                car.setId(rs.getString("id"));
                car.setValue(rs.getFloat("value_car"));
                car.setPathImage(rs.getString("path_img"));
                car.setDesc(rs.getString("description"));
                car.setMark(rs.getString("mark"));
                car.setModel(rs.getString("model"));
                car.setState(rs.getString("state"));
                car.setClient(new ClientDAO().recoverClient(rs.getString("id_client")));

                cars.add(car);
            }
            con.close();
            return cars;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package dao;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO {
    public Client recoverClient(String id){
        Client cli = new Client();
        String sql = "SELECT * FROM client WHERE id = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                cli.setName(rs.getString("name"));
                cli.setEmail(rs.getString("email"));
                cli.setId(rs.getString("id"));
                cli.setAdress(rs.getString("adress"));
                cli.setPhone(rs.getString("phone"));
                cli.setCpf(rs.getString("cpf"));

                con.close();
                return cli;
            } else {
                con.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Client> listClient(){
        ArrayList<Client> clis = new ArrayList<Client>();
        String sql = "SELECT * FROM client";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                Client cli = new Client();
                cli.setName(rs.getString("name"));
                cli.setEmail(rs.getString("email"));
                cli.setId(rs.getString("id"));
                cli.setAdress(rs.getString("adress"));
                cli.setPhone(rs.getString("phone"));
                cli.setCpf(rs.getString("cpf"));

                clis.add(cli);
            }
            con.close();
            return clis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

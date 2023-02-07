package dao;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO {

    public void addClient(Client client){
        String sql = "INSERT INTO client(name, email, phone, adress, cpf) VALUES (?,?,?,?,?)";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, client.getName());
            pst.setString(2, client.getEmail());
            pst.setString(3, client.getPhone());
            pst.setString(4, client.getAdress());
            pst.setString(5, client.getCpf());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editClient(Client client){
        String sql = "UPDATE client SET name = ?, email = ?, phone = ?, adress = ?, cpf = ? WHERE id = ?";;
        try {
            Connection con = new DAO().conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, client.getName());
            pst.setString(2, client.getEmail());
            pst.setString(3, client.getPhone());
            pst.setString(4, client.getAdress());
            pst.setString(5, client.getCpf());
            pst.setString(6, client.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteClient(String id){
        //me lembra de te falar uma coisa sobre esse metódo antes dele ser utilizado, é importante
        String sql = "DELETE FROM client WHERE id = ?";
        try {
            Connection con = new DAO().conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void recoverCarClient(Client client) {

    }

    public void recoverClient(Client client){
        String sql = "SELECT * FROM client WHERE id = ?";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, client.getId());
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setId(rs.getString("id"));
                client.setAdress(rs.getString("adress"));
                client.setPhone(rs.getString("phone"));
                client.setCpf(rs.getString("cpf"));
                con.close();
            } else {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> listClient(){
        ArrayList<Client> clis = new ArrayList<Client>();
        String sql = "SELECT * FROM client";

        try {
            Connection con = new DAO().conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
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
            return null;
        }
    }
}

package model;

import dao.SaleDAO;

import java.sql.Date;

public class Sale {
    private String id;
    private Date date;

    private int parcel;

    private float value;
    private Client client;

    public void addSaleCar(Date date, int parcel, String idCar, Client client, float valueCar){
        this.setDate(date);
        this.setClient(client);
        this.setParcel(parcel);
//        float value = (float) calculateValue(valueCar, parcel);
        this.setValue(value);
        new SaleDAO().addSaleOfCar(this, idCar);
    }

//    public double calculateValue(float valueCar, int parcel){
//
//    }
    public void recoverSaleByCar(String idCar){
        new SaleDAO().recoverSaleByCar(this, idCar);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getParcel() {
        return parcel;
    }

    public void setParcel(int parcel) {
        this.parcel = parcel;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

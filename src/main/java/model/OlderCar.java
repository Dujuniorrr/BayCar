package model;

import dao.CarDAO;
import dao.OlderCarDAO;

import java.util.ArrayList;

public class OlderCar extends Car {
    private float mileage;

    public ArrayList<OlderCar> listOlderCarDisponible(){
        return new OlderCarDAO().listOlderCarDisponible();
    }

    public ArrayList<OlderCar> listOlderCarRented(){
        return new OlderCarDAO().listOlderCarRented();
    }

    public ArrayList<OlderCar> listOlderCarSold(){
        return new OlderCarDAO().listOlderCarSold();
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }
}

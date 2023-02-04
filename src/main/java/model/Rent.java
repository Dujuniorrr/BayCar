package model;

import java.sql.Date;

public class Rent extends Sale {
    private Date dateDevolution;
    private float millage;

    public Date getDateDevolution() {
        return dateDevolution;
    }

    public void setDateDevolution(Date dateDevolution) {
        this.dateDevolution = dateDevolution;
    }

    public float getMillage() {
        return millage;
    }

    public void setMillage(float millage) {
        this.millage = millage;
    }
}

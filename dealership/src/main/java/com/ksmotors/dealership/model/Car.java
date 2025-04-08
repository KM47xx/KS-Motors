package com.ksmotors.dealership.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
@Component
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idno;

    private long phno;
    private int kms, price;
    private String year, manufacturer, model, fuel, transmission, owners, rgno,type,imgname,imgtype;
    @Lob
    private byte[] imgdata;

    //image setters
    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public void setImgdata(byte[] imgdata) {
        this.imgdata = imgdata;
    }

    public Car() {
    }

    public Car(long idno, long phno, String year, String owners, int kms, int price, String manufacturer, String model,
            String fuel,
            String transmission, String rgno,String type) {
        this.idno = idno;
        this.phno = phno;
        this.year = year;//
        this.owners = owners;//
        this.kms = kms;//
        this.price = price;
        this.manufacturer = manufacturer;//
        this.model = model;//
        this.fuel = fuel;//
        this.transmission = transmission;//
        this.rgno = rgno;
        this.type=type;
    }

    public long getIdno() {
        return idno;
    }

    public long getPhno() {
        return phno;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getFuel() {
        return fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getYear() {
        return year;
    }

    public String getOwners() {
        return owners;
    }

    public String getRgno() {
        return rgno;
    }

    public int getKms() {
        return kms;
    }

    public int getPrice() {
        return price;
    }

    public String getImgtype() {
        return imgtype;
    }

    public String getImgname() {
        return imgname;
    }
    public byte[] getImgdata() {
        return imgdata;
    }
}
//lombok se ye ez hojata lekin tab padha nahi,basicaly automate hota get/set
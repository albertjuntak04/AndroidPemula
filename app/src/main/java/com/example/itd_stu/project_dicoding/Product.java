package com.example.itd_stu.project_dicoding;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ITD-STU on 6/8/19.
 */

public class Product implements Parcelable{

    private String name;
    private String remarks;
    private String photo;
    private String price;
    private String deskripsi;
    private String display;
    private String size;
    private String toko;

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    private String pemilik;



    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    private String features;
    private String camera;

    public Product() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.price);
        dest.writeString(this.deskripsi);
        dest.writeString(this.display);
        dest.writeString(this.camera);
        dest.writeString(this.features);
        dest.writeString(this.size);
        dest.writeString(this.toko);
        dest.writeString(this.pemilik);
    }


    protected Product(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.price=in.readString();
        this.deskripsi=in.readString();
        this.camera=in.readString();
        this.display=in.readString();
        this.features=in.readString();
        this.size=in.readString();
        this.toko=in.readString();
        this.pemilik=in.readString();
    }
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }
        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };


}

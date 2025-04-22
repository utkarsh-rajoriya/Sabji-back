package com.utkarsh.demoSpringBoot.Models;

import jakarta.persistence.*;

@Entity
public class Sabji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rate;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Sabji(int id, String name, int rate, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    public Sabji(){}

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

package com.f1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "team")
    private String team;

    @Column(name = "driver_number")
    private int driverNumber;

    @Column(name = "driver_number_url")
    private String driverNumberUrl;

    @Column(name = "country")
    private String country;

    @Column(name = "country_flag")
    private String countryFlag;

    @Column(name = "helmet")
    private String helmet;

    @Column(name = "biography")
    private String biography;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "podiums")
    private int podiums;

    @Column(name = "highest_result")
    private String highestResult;

    @Column(name = "world_championships")
    private String worldChampionships;

    public String getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(String imageDetail) {
        this.imageDetail = imageDetail;
    }

    @Column(name = "image_detail")
    private String imageDetail;

    public String getDriverNumberUrl() {
        return driverNumberUrl;
    }

    public void setDriverNumberUrl(String driverNumberUrl) {
        this.driverNumberUrl = driverNumberUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public String getHighestResult() {
        return highestResult;
    }

    public void setHighestResult(String highestResult) {
        this.highestResult = highestResult;
    }

    public String getWorldChampionships() {
        return worldChampionships;
    }

    public void setWorldChampionships(String worldChampionships) {
        this.worldChampionships = worldChampionships;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Piloto() {
    }

    public Piloto(Long id, String name, String image, String team, int driverNumber, String driverNumberUrl, String country, String countryFlag, String helmet, String biography, String birthDate, int podiums, String highestResult, String worldChampionships) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.team = team;
        this.driverNumber = driverNumber;
        this.driverNumberUrl = driverNumberUrl;
        this.country = country;
        this.countryFlag = countryFlag;
        this.helmet = helmet;
        this.biography = biography;
        this.birthDate = birthDate;
        this.podiums = podiums;
        this.highestResult = highestResult;
        this.worldChampionships = worldChampionships;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", team='" + team + '\'' +
                ", driverNumber=" + driverNumber +
                ", driverNumberUrl='" + driverNumberUrl + '\'' +
                ", country='" + country + '\'' +
                ", countryFlag='" + countryFlag + '\'' +
                ", helmet='" + helmet + '\'' +
                ", biography='" + biography + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", podiums=" + podiums +
                ", highestResult='" + highestResult + '\'' +
                ", worldChampionships='" + worldChampionships + '\'' +
                '}';
    }
}

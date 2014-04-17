/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.dto;

import com.boha.golfkids.data.Club;
import java.util.List;

/**
 * Club
 * @author Aubrey Malabie
 */
public class ClubDTO {

    private int clubID, par;
    private String address;
    private String clubName, provinceName;
    private String email;
    private double latitude;
    private double longitude;
    private String telephone;
    private int provinceID;
    private List<ClubCourseDTO> clubCourses;

    public ClubDTO(Club a) {
        address = a.getAddress();
        par = a.getPar();
        clubName = a.getClubName();
        email = a.getEmail();
        telephone = a.getTelephone();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        clubID = a.getClubID();
        if (a.getProvince() != null) {
            provinceID = a.getProvince().getProvinceID();
            provinceName = a.getProvince().getProvinceName();
        }
      
    }

    public List<ClubCourseDTO> getClubCourses() {
        return clubCourses;
    }

    public void setClubCourses(List<ClubCourseDTO> clubCourses) {
        this.clubCourses = clubCourses;
    }


    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public String getAddress() {
        return address;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

 
}

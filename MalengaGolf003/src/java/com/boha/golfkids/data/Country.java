/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.golfkids.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", 
            query = "SELECT c FROM Country c order by c.countryName"),
    @NamedQuery(name = "Country.findByName", 
            query = "SELECT c FROM Country c where c.countryName = :countryName")

})
public class Country implements Serializable {
    @OneToMany(mappedBy = "country")
    private List<PersonalPlayer> personalPlayerList;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countryID")
    private int countryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "countryName")
    private String countryName;
    @Column(name = "countryCode")
    private String countryCode;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<GolfGroup> golfGroupList;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<Province> provinceList;

    public Country() {
    }

    public Country(int countryID) {
        this.countryID = countryID;
    }

    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public List<GolfGroup> getGolfGroupList() {
        return golfGroupList;
    }

    public void setGolfGroupList(List<GolfGroup> golfGroupList) {
        this.golfGroupList = golfGroupList;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

   

    @Override
    public String toString() {
        return "com.boha.golfkids.data.Country[ countryID=" + countryID + " ]";
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

    public List<PersonalPlayer> getPersonalPlayerList() {
        return personalPlayerList;
    }

    public void setPersonalPlayerList(List<PersonalPlayer> personalPlayerList) {
        this.personalPlayerList = personalPlayerList;
    }
    
}

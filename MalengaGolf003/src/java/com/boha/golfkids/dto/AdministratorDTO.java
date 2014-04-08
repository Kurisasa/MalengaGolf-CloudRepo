/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.dto;

import com.boha.golfkids.data.Administrator;
import java.util.Date;

/**
 *
 * @author Aubrey Malabie esq.
 */
public class AdministratorDTO {

    private int administratorID, superUserFlag;
    private String cellphone;
    private Date dateRegistered;
    private String email;
    private String firstName;
    private String lastName;
    private String pin;
    private GolfGroupDTO golfGroup;

    public AdministratorDTO(Administrator a) {
        administratorID = a.getAdministratorID();
        cellphone = a.getCellphone();
        email = a.getEmail();
        firstName = a.getFirstName();
        lastName = a.getLastName();
        superUserFlag = a.getSuperUserFlag();
        pin = a.getPin();
        if (a.getGolfGroup() != null) {
            golfGroup = new GolfGroupDTO(a.getGolfGroup());
        }
    }

    public GolfGroupDTO getGolfGroup() {
        return golfGroup;
    }

    public int getSuperUserFlag() {
        return superUserFlag;
    }

    public void setSuperUserFlag(int superUserFlag) {
        this.superUserFlag = superUserFlag;
    }

    public void setGolfGroup(GolfGroupDTO golfGroup) {
        this.golfGroup = golfGroup;
    }

    public int getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(int administratorID) {
        this.administratorID = administratorID;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
}

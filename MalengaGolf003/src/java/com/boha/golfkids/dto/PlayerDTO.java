/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.dto;

import com.boha.golfkids.data.Player;
import com.boha.golfkids.data.TourneyPlayerScore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aubrey Malabie
 */
public class PlayerDTO {

    private int playerID;
    private String cellphone;
    private long dateOfBirth;
    private long dateRegistered;
    private String email;
    private String firstName;
    private int gender;
    private String lastName;
    private String middleName;
    private String pin;
    private int yearJoined;
    private ParentDTO parent;
    private List<TourneyPlayerScoreDTO> scores;

    public PlayerDTO(Player a, boolean getScores) {
        playerID = a.getPlayerID();
        cellphone = a.getCellphone();
        dateOfBirth = a.getDateOfBirth().getTime();
        dateRegistered = a.getDateRegistered().getTime();
        email = a.getEmail();
        firstName = a.getFirstName();
        gender = a.getGender();
        lastName = a.getLastName();
        middleName = a.getMiddleName();
        pin = a.getPin();
        yearJoined = a.getYearJoined();
        //
        if (a.getParent() != null) {
            parent = new ParentDTO(a.getParent(), false);
        }
        if (getScores) {
            if (a.getTourneyPlayerScoreList() != null) {
                scores = new ArrayList<TourneyPlayerScoreDTO>();
                List<TourneyPlayerScore> tpList = a.getTourneyPlayerScoreList();
                for (TourneyPlayerScore tourneyPlayerScore : tpList) {
                    scores.add(new TourneyPlayerScoreDTO(tourneyPlayerScore, false, false));
                }
            }
        }
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public List<TourneyPlayerScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<TourneyPlayerScoreDTO> scores) {
        this.scores = scores;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.golfkids.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "tourneyPlayerScore")
@NamedQueries({
    @NamedQuery(name = "TourneyPlayerScore.findByTournament", 
            query = "SELECT t FROM TourneyPlayerScore t where t.tournament.tournamentID = :id")})
public class TourneyPlayerScore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tourneyPlayerScoreID")
    private Integer tourneyPlayerScoreID;
    @Column(name = "scoreRound1")
    private Integer scoreRound1;
    @Column(name = "scoreRound2")
    private Integer scoreRound2;
    @Column(name = "scoreRound3")
    private Integer scoreRound3;
    @Column(name = "scoreRound4")
    private Integer scoreRound4;
    @Column(name = "tourneyPosition")
    private Integer tourneyPosition;
    @Column(name = "tourneyPositionTied")
    private Integer tourneyPositionTied;
    @Column(name = "winnerFlag")
    private Integer winnerFlag;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "paidFlag")
    private Integer paidFlag;
    @Column(name = "totalScore")
    private Integer totalScore;
    @JoinColumn(name = "ageGroupID", referencedColumnName = "ageGroupID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Agegroup ageGroup;
    @JoinColumn(name = "tournamentID", referencedColumnName = "tournamentID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tournament tournament;
    @JoinColumn(name = "playerID", referencedColumnName = "playerID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Administrator administrator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourneyPlayerScore", fetch = FetchType.EAGER)
    private List<TeeTime> teeTimeList;
    @OneToMany(mappedBy = "tourneyPlayerScore", fetch = FetchType.EAGER)
    private List<TourneyScoreByRound> tourneyScoreByRoundList;

    public TourneyPlayerScore() {
    }

    public TourneyPlayerScore(Integer tourneyPlayerScoreID) {
        this.tourneyPlayerScoreID = tourneyPlayerScoreID;
    }

    public Integer getTourneyPlayerScoreID() {
        return tourneyPlayerScoreID;
    }

    public void setTourneyPlayerScoreID(Integer tourneyPlayerScoreID) {
        this.tourneyPlayerScoreID = tourneyPlayerScoreID;
    }

    public Integer getScoreRound1() {
        return scoreRound1;
    }

    public void setScoreRound1(Integer scoreRound1) {
        this.scoreRound1 = scoreRound1;
    }

    public Integer getScoreRound2() {
        return scoreRound2;
    }

    public void setScoreRound2(Integer scoreRound2) {
        this.scoreRound2 = scoreRound2;
    }

    public Integer getScoreRound3() {
        return scoreRound3;
    }

    public void setScoreRound3(Integer scoreRound3) {
        this.scoreRound3 = scoreRound3;
    }

    public Integer getScoreRound4() {
        return scoreRound4;
    }

    public void setScoreRound4(Integer scoreRound4) {
        this.scoreRound4 = scoreRound4;
    }

    public Integer getTourneyPosition() {
        return tourneyPosition;
    }

    public void setTourneyPosition(Integer tourneyPosition) {
        this.tourneyPosition = tourneyPosition;
    }

    public Integer getTourneyPositionTied() {
        return tourneyPositionTied;
    }

    public void setTourneyPositionTied(Integer tourneyPositionTied) {
        this.tourneyPositionTied = tourneyPositionTied;
    }

    public Integer getWinnerFlag() {
        return winnerFlag;
    }

    public void setWinnerFlag(Integer winnerFlag) {
        this.winnerFlag = winnerFlag;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getPaidFlag() {
        return paidFlag;
    }

    public void setPaidFlag(Integer paidFlag) {
        this.paidFlag = paidFlag;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Agegroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Agegroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<TeeTime> getTeeTimeList() {
        return teeTimeList;
    }

    public void setTeeTimeList(List<TeeTime> teeTimeList) {
        this.teeTimeList = teeTimeList;
    }

    public List<TourneyScoreByRound> getTourneyScoreByRoundList() {
        return tourneyScoreByRoundList;
    }

    public void setTourneyScoreByRoundList(List<TourneyScoreByRound> tourneyScoreByRoundList) {
        this.tourneyScoreByRoundList = tourneyScoreByRoundList;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourneyPlayerScoreID != null ? tourneyPlayerScoreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourneyPlayerScore)) {
            return false;
        }
        TourneyPlayerScore other = (TourneyPlayerScore) object;
        if ((this.tourneyPlayerScoreID == null && other.tourneyPlayerScoreID != null) || (this.tourneyPlayerScoreID != null && !this.tourneyPlayerScoreID.equals(other.tourneyPlayerScoreID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.golfkids.data.TourneyPlayerScore[ tourneyPlayerScoreID=" + tourneyPlayerScoreID + " ]";
    }
    
}

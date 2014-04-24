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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "tournament")
@NamedQueries({
    @NamedQuery(name = "Tournament.findByGolfGroup",
            query = "SELECT t FROM Tournament t "
            + "where t.golfGroup.golfGroupID = :id "
            + "order by t.startDate desc"),
    @NamedQuery(name = "Tournament.findByPlayer",
            query = "SELECT distinct t FROM Tournament t, LeaderBoard b "
                    + "where t.tournamentID = b.tournament.tournamentID "
                    + "and b.player.playerID = :id "
                    + "order by t.startDate desc"),

    @NamedQuery(name = "Tournament.findByClub",
            query = "select a from Tournament a where a.club.clubID = :id")
})
public class Tournament implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournament")
    private List<TournamentCourse> tournamentCourseList;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "holesPerRound")
    private int holesPerRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "par")
    private int par;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournament", fetch = FetchType.LAZY)
    private List<LeaderBoard> leaderBoardList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tournamentID")
    private Integer tournamentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tourneyName")
    private String tourneyName;
    @Column(name = "closingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "golfRounds")
    private int golfRounds;

    @Column(name = "closedForScoringFlag")
    private int closedForScoringFlag;
    
    @Column(name = "closedForRegistrationFlag")
    private int closedForRegistrationFlag;
    
    @JoinColumn(name = "golfGroupID", referencedColumnName = "golfGroupID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GolfGroup golfGroup;
    @JoinColumn(name = "clubID", referencedColumnName = "clubID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Club club;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournament", fetch = FetchType.EAGER)
    private List<TournamentVolunteer> tournamentVolunteerList;

    public Tournament() {
    }

    public Tournament(Integer tournamentID) {
        this.tournamentID = tournamentID;
    }

    public Tournament(Integer tournamentID, String tourneyName, Date endDate, Date startDate, int golfRounds) {
        this.tournamentID = tournamentID;
        this.tourneyName = tourneyName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.golfRounds = golfRounds;
    }

    public Integer getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Integer tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTourneyName() {
        return tourneyName;
    }

    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }

    public int getClosedForRegistrationFlag() {
        return closedForRegistrationFlag;
    }

    public void setClosedForRegistrationFlag(int closedForRegistrationFlag) {
        this.closedForRegistrationFlag = closedForRegistrationFlag;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public int getClosedForScoringFlag() {
        return closedForScoringFlag;
    }

    public void setClosedForScoringFlag(int closedForScoringFlag) {
        this.closedForScoringFlag = closedForScoringFlag;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getGolfRounds() {
        return golfRounds;
    }

    public void setGolfRounds(int golfRounds) {
        this.golfRounds = golfRounds;
    }

    public GolfGroup getGolfGroup() {
        return golfGroup;
    }

    public void setGolfGroup(GolfGroup golfGroup) {
        this.golfGroup = golfGroup;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<TournamentVolunteer> getTournamentVolunteerList() {
        return tournamentVolunteerList;
    }

    public void setTournamentVolunteerList(List<TournamentVolunteer> tournamentVolunteerList) {
        this.tournamentVolunteerList = tournamentVolunteerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tournamentID != null ? tournamentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.tournamentID == null && other.tournamentID != null) || (this.tournamentID != null && !this.tournamentID.equals(other.tournamentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.golfkids.data.Tournament[ tournamentID=" + tournamentID + " ]";
    }

    public List<LeaderBoard> getLeaderBoardList() {
        return leaderBoardList;
    }

    public void setLeaderBoardList(List<LeaderBoard> leaderBoardList) {
        this.leaderBoardList = leaderBoardList;
    }

    public int getHolesPerRound() {
        return holesPerRound;
    }

    public void setHolesPerRound(int holesPerRound) {
        this.holesPerRound = holesPerRound;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public List<TournamentCourse> getTournamentCourseList() {
        return tournamentCourseList;
    }

    public void setTournamentCourseList(List<TournamentCourse> tournamentCourseList) {
        this.tournamentCourseList = tournamentCourseList;
    }
    

}

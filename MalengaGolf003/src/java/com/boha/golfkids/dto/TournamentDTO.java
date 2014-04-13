/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.dto;

import com.boha.golfkids.data.Tournament;
import java.util.List;

/**
 *
 * @author Aubrey Malabie
 */
public class TournamentDTO implements Comparable<TournamentDTO> {

    private int tournamentID;
    private long closingDate;
    private long endDate;
    private int golfRounds;
    private int closedForScoringFlag;
    private long startDate;
    private String tourneyName, clubName;
    private int clubID;
    private int clubCourseID;
    private int golfGroupID, par = 72;
    private List<TourneyPlayerScoreDTO> scores;
    private List<VolunteerDTO> volunteers;

    public TournamentDTO(Tournament a) {
        tournamentID = a.getTournamentID();
        closedForScoringFlag = a.getClosedForScoringFlag();
        if (a.getClosingDate() != null) {
            closingDate = a.getClosingDate().getTime();
        }
        if (a.getEndDate() != null) {
            endDate = a.getEndDate().getTime();
        }
        golfRounds = a.getGolfRounds();
        if (a.getStartDate() != null) {
            startDate = a.getStartDate().getTime();
        }
        tourneyName = a.getTourneyName();
        if (a.getClubCourse() != null) {
            clubCourseID = a.getClubCourse().getClubCourseID();
            par = a.getClubCourse().getPar();
        }
        if (a.getClub() != null) {
            clubID = a.getClub().getClubID();
            clubName = a.getClub().getClubName();
        }
        if (a.getGolfGroup() != null) {
            golfGroupID = a.getGolfGroup().getGolfGroupID();
        }

    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public long getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(long closingDate) {
        this.closingDate = closingDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getGolfRounds() {
        return golfRounds;
    }

    public void setGolfRounds(int golfRounds) {
        this.golfRounds = golfRounds;
    }

    public int getClosedForScoringFlag() {
        return closedForScoringFlag;
    }

    public void setClosedForScoringFlag(int closedForScoringFlag) {
        this.closedForScoringFlag = closedForScoringFlag;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public String getTourneyName() {
        return tourneyName;
    }

    public int getGolfGroupID() {
        return golfGroupID;
    }

    public void setGolfGroupID(int golfGroupID) {
        this.golfGroupID = golfGroupID;
    }

    public List<TourneyPlayerScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<TourneyPlayerScoreDTO> scores) {
        this.scores = scores;
    }

    public List<VolunteerDTO> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<VolunteerDTO> volunteers) {
        this.volunteers = volunteers;
    }

    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }

    @Override
    public int compareTo(TournamentDTO t) {

        if (startDate > t.startDate) {
            return 1;
        }
        if (startDate < t.startDate) {
            return -1;
        }

        return 0;
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public int getClubCourseID() {
        return clubCourseID;
    }

    public void setClubCourseID(int clubCourseID) {
        this.clubCourseID = clubCourseID;
    }
}

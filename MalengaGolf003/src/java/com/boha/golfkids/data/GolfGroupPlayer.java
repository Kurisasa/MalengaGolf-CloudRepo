/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "golfGroupPlayer")
@NamedQueries({
    @NamedQuery(name = "GolfGroupPlayer.findAll", query = "SELECT g FROM GolfGroupPlayer g"),
    @NamedQuery(name = "GolfGroupPlayer.findByGolfGroupPlayerID", query = "SELECT g FROM GolfGroupPlayer g WHERE g.golfGroupPlayerID = :golfGroupPlayerID"),
    @NamedQuery(name = "GolfGroupPlayer.findByDateRegistered", query = "SELECT g FROM GolfGroupPlayer g WHERE g.dateRegistered = :dateRegistered")})
public class GolfGroupPlayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "golfGroupPlayerID")
    private int golfGroupPlayerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "playerID", referencedColumnName = "playerID")
    @ManyToOne(optional = false)
    private Player player;
    @JoinColumn(name = "golfGroupID", referencedColumnName = "golfGroupID")
    @ManyToOne(optional = false)
    private GolfGroup golfGroup;

    public GolfGroupPlayer() {
    }

    public GolfGroupPlayer(int golfGroupPlayerID) {
        this.golfGroupPlayerID = golfGroupPlayerID;
    }

    public GolfGroupPlayer(int golfGroupPlayerID, Date dateRegistered) {
        this.golfGroupPlayerID = golfGroupPlayerID;
        this.dateRegistered = dateRegistered;
    }

    public int getGolfGroupPlayerID() {
        return golfGroupPlayerID;
    }

    public void setGolfGroupPlayerID(int golfGroupPlayerID) {
        this.golfGroupPlayerID = golfGroupPlayerID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GolfGroup getGolfGroup() {
        return golfGroup;
    }

    public void setGolfGroup(GolfGroup golfGroup) {
        this.golfGroup = golfGroup;
    }

    
    @Override
    public String toString() {
        return "com.boha.golfkids.data.GolfGroupPlayer[ golfGroupPlayerID=" + golfGroupPlayerID + " ]";
    }
    
}

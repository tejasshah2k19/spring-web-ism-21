package com.entity.annotation.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sports")
public class SportsEntity {

	@Id
	@GeneratedValue
	int sportsId;

	String sportsName;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "sports_player", joinColumns = { @JoinColumn(name = "sportId") }, inverseJoinColumns = {
			@JoinColumn(name = "playerId") })
	Set<PlayerEntity> players;

	public int getSportsId() {
		return sportsId;
	}

	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public Set<PlayerEntity> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerEntity> players) {
		this.players = players;
	}

}

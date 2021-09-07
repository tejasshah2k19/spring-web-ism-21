package com.entity.annotation.manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="players")
public class PlayerEntity {

	@Id
	@GeneratedValue
	int playerId;
	String name;

	@ManyToMany(mappedBy="sports")
	Set<SportsEntity> sports;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

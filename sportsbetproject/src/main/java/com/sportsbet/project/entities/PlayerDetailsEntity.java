package com.sportsbet.project.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_playerDetails")
public class PlayerDetailsEntity {

	@Id
	private Long playerId;
	
	@Column(name="player_name")
	private String playerName;

	@Column(name="player_position")
	private String position;
	
	@Column(name="position_depth")
	private String positionDepth;
	
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositionDepth() {
		return positionDepth;
	}

	public void setPositionDepth(String positionDepth) {
		this.positionDepth = positionDepth;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((positionDepth == null) ? 0 : positionDepth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDetailsEntity other = (PlayerDetailsEntity) obj;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (positionDepth == null) {
			if (other.positionDepth != null)
				return false;
		} else if (!positionDepth.equals(other.positionDepth))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "playerDetailsEntity [playerId=" + playerId + ", playerName=" + playerName + ", position=" + position
				+ ", positionDepth=" + positionDepth + "]";
	}
	
	
}


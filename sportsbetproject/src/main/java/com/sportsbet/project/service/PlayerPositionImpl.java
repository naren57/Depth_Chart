package com.sportsbet.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.sportsbet.project.exception.RecordNotFoundException;
import com.sportsbet.project.entities.PlayerDetailsEntity;
import com.sportsbet.project.repository.PlayerDetailRepository;
import java.util.List;
import java.util.Map;
@Service
public class PlayerPositionImpl {
	
	@Autowired 
	PlayerDetailRepository repository;
	private static Map<String, LinkedList<PlayerDetailsEntity>> positionMapList = new HashMap<String, LinkedList<PlayerDetailsEntity>>();

	
	public PlayerDetailsEntity addPlayerToDepthChart(PlayerDetailsEntity playerDetails) throws RecordNotFoundException {
    
		positionMapList.putIfAbsent(playerDetails.getPosition(), new LinkedList<PlayerDetailsEntity>());
		
		LinkedList<PlayerDetailsEntity> details = positionMapList.getOrDefault(playerDetails.getPosition(),
				new LinkedList<PlayerDetailsEntity>());
		
		
		if (playerDetails.getPositionDepth() == null) {
			details.addLast(playerDetails);
			System.out.println("Details 1"+details);
			
		}else {
		details.add(Integer.parseInt(playerDetails.getPositionDepth()), playerDetails);
		}     
		repository.save(playerDetails);
		return playerDetails;
	}

	public PlayerDetailsEntity removePlayerFromDepthChart(String playername, String position) throws RecordNotFoundException {
		LinkedList<PlayerDetailsEntity> details = positionMapList.getOrDefault(position,
				new LinkedList<PlayerDetailsEntity>());
		Optional<PlayerDetailsEntity> optlayer = details.stream().filter(player -> player.getPlayerName().equals(playername)).findFirst();
		PlayerDetailsEntity playerEntity=null;
		if(optlayer.isPresent()) {
			playerEntity=optlayer.get();
			details.remove(playerEntity);
		}else {
			throw new RecordNotFoundException("No player is found for the playername and position");
		}
		return playerEntity;
	}

	public List<PlayerDetailsEntity> getPlayersUnderPlayerInDepthChart(long playerId, String playerPosition) throws RecordNotFoundException {
		
		LinkedList<PlayerDetailsEntity> details = positionMapList.getOrDefault(playerPosition,
				new LinkedList<PlayerDetailsEntity>());
		Optional<PlayerDetailsEntity> optlayer = details.stream().filter(player -> player.getPlayerId()==playerId).findFirst();
		List <PlayerDetailsEntity> retplayer = new ArrayList<PlayerDetailsEntity>();
		if(optlayer.isPresent()) {
			Iterator<PlayerDetailsEntity> itr= details.listIterator(details.indexOf(optlayer.get()) + 1);
			while(itr.hasNext()) {
				retplayer.add(itr.next());
			}
		}	else{
			throw new RecordNotFoundException("No player is found for the playerID and position");
		}
		return retplayer;
	}

	public Map<String, LinkedList<PlayerDetailsEntity>> getPlayerUnderPlayer() {
		
	
		return positionMapList;
	}

}

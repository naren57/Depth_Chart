package com.sportsbet.project.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sportsbet.project.entities.PlayerDetailsEntity;
import com.sportsbet.project.exception.RecordNotFoundException;
import com.sportsbet.project.service.PlayerPositionImpl;

@RestController
public class SportsberController {
	@Autowired
	PlayerPositionImpl playerpositionImpl;
	
	 @PostMapping(path="/addPlayerToDepthChart")
	    public ResponseEntity<PlayerDetailsEntity> addPlayerList(@RequestBody PlayerDetailsEntity playerDetails)
	                                                    throws RecordNotFoundException {
	    	PlayerDetailsEntity addplayer = playerpositionImpl.addPlayerToDepthChart(playerDetails);
	        return new ResponseEntity<PlayerDetailsEntity>(addplayer, new HttpHeaders(), HttpStatus.OK);
	    }
	    
	
	    @GetMapping(path="/PlayerInDepthChart")
		public ResponseEntity<List <PlayerDetailsEntity>> getPlayers(@RequestParam("playerId") String  playerId,@RequestParam("playerPosition") String playerPosition) throws RecordNotFoundException{
		
			List<PlayerDetailsEntity> getplayer = playerpositionImpl.getPlayersUnderPlayerInDepthChart(Long.parseLong(playerId), playerPosition);
			return new ResponseEntity <List <PlayerDetailsEntity>>(getplayer, new HttpHeaders(),HttpStatus.OK);
		} 
	
	@PutMapping(path="/removePlayerFromDepthChart/{playername}/{position}")
	public ResponseEntity<PlayerDetailsEntity> removePlayerList(@PathVariable(value = "playername")String playername,
				@PathVariable(value = "position")String position) throws RecordNotFoundException{
		
		PlayerDetailsEntity removePlayer = playerpositionImpl.removePlayerFromDepthChart(playername,position);
		return new ResponseEntity<PlayerDetailsEntity>(removePlayer,new HttpHeaders(),HttpStatus.OK);
	}
	

	@GetMapping(path="/player-list")
	    public ResponseEntity<Map<String, LinkedList<PlayerDetailsEntity>>> getFullDepthChart() {
		
		Map<String, LinkedList<PlayerDetailsEntity>> list = playerpositionImpl.getPlayerUnderPlayer(); 
	        return new ResponseEntity<Map<String, LinkedList<PlayerDetailsEntity>>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	    
	}

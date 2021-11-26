package com.sportsbet.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sportsbet.project.entities.PlayerDetailsEntity;

@Repository
public interface PlayerDetailRepository 
		extends CrudRepository<PlayerDetailsEntity, Long>{
	

}

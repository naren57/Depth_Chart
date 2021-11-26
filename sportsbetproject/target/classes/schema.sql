DROP TABLE IF EXISTS TBL_playerDetails;
 
CREATE TABLE TBL_playerDetails(
  player_id INT NOT NULL PRIMARY KEY,
  player_name VARCHAR(50) NOT NULL,
  player_position VARCHAR(3) NOT NULL,
  position_depth VARCHAR(3) DEFAULT NULL
);
package GaMEAPP;

import java.util.List;

public interface gameUtility {

	 int insertGame(GameEntity GameEntity);
	 List<GameEntity> getAllGame();
	 List<GameEntity> getGameLocation(String loc);
     List<String> getAllPlayers();
     List<String> getAllMalePlayers();
     List<String> getAllFemalePlayers(); 
	 boolean deletePlayers(String players);
}

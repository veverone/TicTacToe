package com.tictactoe.db;

import com.tictactoe.TTTPlayer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/* define basic CRUD operations */
public interface TicTacToeRepository extends MongoRepository<TTTPlayer, String>, TicTacToeOperations {
	
	public TTTPlayer findByPlayerName(String playerName); 
	
	@Query("{ 'playerName' : 'Bogdan' , 'points' : ?0 }")
	public List<TTTPlayer> findBogsAdversariesWithPoints(int points);
	
}

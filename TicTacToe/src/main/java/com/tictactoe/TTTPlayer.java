package com.tictactoe;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class TTTPlayer {

	@Id
	private String playerName;
	
	@Field("totalPoints")
	private int points;
	
	private Collection<TTTGame> tttGames = new LinkedHashSet<>();  
	
	public String getPlayerName(){
		return playerName;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Collection<TTTGame> getTttGames() {
		return new LinkedHashSet<>(tttGames);
	}
	
	// how to just add an item?
	
}

package com.tictactoe;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tictactoe.db.TicTacToeRepository;

@Controller
@RequestMapping("/")
public class TTTController {
	
	private TicTacToeRepository tttRepository;
	
	@Autowired
	public TTTController(TicTacToeRepository tttRepository) {
		this.tttRepository = tttRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String welcomeHome(Map<String,Object> model){
		List<TTTPlayer> playerList = tttRepository.findAll();
		model.put("playerList", playerList);
		return "home";
	}
	
	@RequestMapping(value="/games",method=RequestMethod.GET)
	public String playedGames(){
		return "games";
	}
	
	@RequestMapping(value="/player/register", method=RequestMethod.POST)
	public String submit(TTTPlayer player){
		tttRepository.save(player);
		return "redirect:/";
	}

}

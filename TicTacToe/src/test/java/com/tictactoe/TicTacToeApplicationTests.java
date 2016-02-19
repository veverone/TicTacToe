package com.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tictactoe.db.TicTacToeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicTacToeApplication.class)
@WebAppConfiguration
public class TicTacToeApplicationTests {

	@Autowired
	private TicTacToeRepository tttRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldAddAPlayer(){
		
		assertEquals(0, tttRepository.count());
		
		TTTPlayer tttp = new TTTPlayer();
		tttRepository.insert(tttp);
		
		assertEquals(1, tttRepository.count());
	}
	
	@Before
	public void shouldCleanRepository(){
		System.out.println("ran one time");
		tttRepository.deleteAll();		
	}
}

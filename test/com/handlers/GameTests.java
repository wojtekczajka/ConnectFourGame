package com.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTests {

	@Test
	public void testIsWinVertically() {
		Game game = new Game();
		int[][] testArray1 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWinVertically(1));
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				};
		game.setGameBoard(testArray2);
		assertTrue(game.isWinVertically(1));
		
		int[][] testArray3 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				};
		game.setGameBoard(testArray3);
		assertFalse(game.isWinVertically(1));
		
		int[][] testArray4 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				};
		game.setGameBoard(testArray4);
		assertTrue(game.isWinVertically(1));
		
		int[][] testArray5 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 0, 1, 0 },
				{ 1, 1, 0, 1, 0, 1, 1 },
				{ 0, 1, 0, 0, 0, 1, 1 },
				};
		game.setGameBoard(testArray5);
		assertTrue(game.isWinVertically(1));
	}

	@Test
	public void testIsWinHorizontally() {
		Game game = new Game();
		int[][] testArray1 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWinHorizontally(1));
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray2);
		assertTrue(game.isWinHorizontally(1));
		
		int[][] testArray3 = { 
				{ 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 1, 1, 0 },
				};
		game.setGameBoard(testArray3);
		assertFalse(game.isWinHorizontally(1));
		
		int[][] testArray4 = { 
				{ 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 0, 1, 0 },
				};
		game.setGameBoard(testArray4);
		assertTrue(game.isWinHorizontally(1));
	}

//	@Test
//	public void testIsWinSecondDiagonall() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testIsWinFirstDiagonall() {
		Game game = new Game();
		int[][] testArray1 = { 
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWinFirstDiagonall(1));
		
//		int[][] testArray2 = { 
//				{ 0, 0, 0, 0, 1, 0, 0 },
//				{ 0, 0, 0, 1, 0, 0, 0 },
//				{ 0, 0, 1, 0, 0, 0, 0 },
//				{ 0, 1, 1, 0, 0, 0, 0 },
//				{ 1, 1, -1, 0, 0, 0, 0 },
//				{ 1, 1, 1, 0, 0, 0, 0 },
//				};
//		game.setGameBoard(testArray2);
//		assertTrue(game.isWinFirstDiagonall(2));
	}

}

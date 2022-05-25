package com.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.handlers.GameHandler;

public class GameTests {

	@Test
	public void testIsWinVertically() {
		GameHandler game = new GameHandler();
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
		GameHandler game = new GameHandler();
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

	@Test
	public void testIsWinFirstDiagonall() {
		GameHandler game = new GameHandler();
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
	
	
	@Test
	public void testIsColumnFull() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isColumnFull(1));
		
		int[][] testArray2 = { 
				{ 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0 },
				};
		game.setGameBoard(testArray2);
		assertTrue(game.isColumnFull(5));
		
		int[][] testArray3 = { 
				{ 0, 1, 0, 1, 0, 0, 1 },
				{ 0, 1, 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				};
		game.setGameBoard(testArray3);
		assertFalse(game.isColumnFull(6));
		
		int[][] testArray4 = { 
				{ 0, 1, 0, 1, 1, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 0, 0 },
				};
		game.setGameBoard(testArray4);
		assertFalse(game.isColumnFull(4));
	}
	
	@Test
	public void testIsGameBoardFull() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isGameBoardFull());
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray2);
		assertFalse(game.isGameBoardFull());
	}
	
	@Test
	public void testMakeMove() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 0, 0, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				};
		game.setGameBoard(testArray1);
		game.makeMove(5,1);
		assertTrue(testArray1[5][5] == 1);
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray2);
		game.makeMove(0,-1);
		assertTrue(testArray2[5][0] == -1);
		
		int[][] testArray3 = { 
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				};
		game.setGameBoard(testArray3);
		assertTrue(game.makeMove(3,-1) == 0);
		
		int[][] testArray4 = { 
				{ 0, 1, 0, 1, 0, 0, 1 },
				{ 0, 1, 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 0, 1 },
				};
		game.setGameBoard(testArray4);
		game.makeMove(4,1);
		assertTrue(testArray4[2][4] == 1);
		
		int[][] testArray5 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 1 },
				};
		game.setGameBoard(testArray5);
		game.makeMove(2,-1);
		assertTrue(testArray5[3][2] == -1);
	}
	
	@Test
	public void testIsWin() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWin(1));
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray2);
		assertTrue(game.isWin(1));
		
		int[][] testArray3 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0 },
				};
		game.setGameBoard(testArray3);
		assertTrue(game.isWin(1));
		
		int[][] testArray4 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray4);
		assertFalse(game.isWin(1));
		
		int[][] testArray5 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, -1 },
				{ 0, -1, -1, -1, -1, 0, 0 },
				{ 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray5);
		assertTrue(game.isWin(-1));
	}

	@Test
	public void testIsWinDiagonally() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWinDiagonally(1));
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray2);
		assertFalse(game.isWinDiagonally(1));
		
		int[][] testArray3 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, -1, 0, 0, 0 },
				{ 0, 0, 1, 0, -1, 0, 0 },
				{ 0, 1, 0, 0, 0, -1, 0 },
				{ 1, 0, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				};
		game.setGameBoard(testArray3);
		assertTrue(game.isWinDiagonally(-1));
		
		int[][] testArray4 = { 
				{ 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, -1, 0 },
				{ 0, 0, -1, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, -1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray4);
		assertFalse(game.isWinDiagonally(-1));
	}
	
	@Test
	public void testIsWinSecondDiagonall() {
		GameHandler game = new GameHandler();
		int[][] testArray1 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray1);
		assertTrue(game.isWinSecondDiagonall(1));
		
		int[][] testArray2 = { 
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, -1, 0, 0, 0 },
				{ 1, 0, 0, 1, -1, 0, 0 },
				{ 0, 0, 0, 0, 1, -1, 0 },
				{ 0, 0, 0, 0, 0, 1, -1 },
				};
		game.setGameBoard(testArray2);
		assertTrue(game.isWinSecondDiagonall(-1));
		
		int[][] testArray3 = { 
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				};
		game.setGameBoard(testArray3);
		assertFalse(game.isWinSecondDiagonall(1));
	}
	
	
}

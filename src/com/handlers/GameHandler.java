package com.handlers;

import java.util.Random;

public class GameHandler {
	private int[][] gameBoard = new int[6][7];
	
	public void setGameBoard(int[][] arr) {
		this.gameBoard = arr;
	}
	
	public void printGameBoard() {
		for (int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++)
				System.out.print(gameBoard[i][j]);
			System.out.println("");
		}
	}
	
	public void printGameBoard(int[][] gameBoard) {
		for (int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++)
				System.out.print(gameBoard[i][j]);
			System.out.println("");
		}
	}
	
	public int[][] getGameBoard() {
		return gameBoard;
	}
	
	public int makeMove(int colIndex, int value) {
		for (int i = 5; i >= 0; i--) {
			if (gameBoard[i][colIndex] == 0) {
				gameBoard[i][colIndex] = value;
				return value;
			}
		}
		return 0;
	}
	
	public boolean isColumnFull(int colIndex) {
		for (int i = 0; i < 6; i++) {
			if(gameBoard[i][colIndex] == 0)
				return false;
		}
		return true;
	}
	
	public boolean isGameBoardFull() {
		for (int i = 0; i < 7; i++) {
			if (!isColumnFull(i))
				return false;
		}
		return true;
	}
	
	public int makeRandomMove(int value) {
		if (isGameBoardFull())
			return 0;
		
		Random random = new Random();
		int colIndex = random.nextInt(7);
		
		while (makeMove(colIndex, value) != value) {
			colIndex = random.nextInt(7);
		}
		
		return value;
	}
	
	public boolean isWin(int value) {
		return isWinVertically(value) || isWinHorizontally(value) || isWinDiagonally(value);
	}
	
	public boolean isWinVertically(int value) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[j][i] == value && gameBoard[j + 1][i] == value 
						&& gameBoard[j + 2][i] == value && gameBoard[j + 3][i] == value) {
					if (value == 1) {
					gameBoard[j][i] = 2; gameBoard[j + 1][i] = 2; gameBoard[j + 2][i] = 2; gameBoard[j + 3][i] = 2;
					}
					else {
						gameBoard[j][i] = -2; gameBoard[j + 1][i] = -2; gameBoard[j + 2][i] = -2; gameBoard[j + 3][i] = -2;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isWinHorizontally(int value) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (gameBoard[i][j] == value && gameBoard[i][j + 1] == value && 
						gameBoard[i][j + 2] == value && gameBoard[i][j + 3] == value) {
					if (value == 1) {
						gameBoard[i][j] = 2; gameBoard[i][j + 1] = 2; gameBoard[i][j + 2] = 2; gameBoard[i][j + 3] = 2;
						}
					else {
						gameBoard[i][j] = -2; gameBoard[i][j + 1] = -2; gameBoard[i][j + 2] = -2; gameBoard[i][j + 3] = -2;
						}
					return true;
				}
			}
		}
		return false;
	}

	public boolean isWinDiagonally(int value) {
		return isWinFirstDiagonall(value) || isWinSecondDiagonall(value);
	}
	
	public boolean isWinFirstDiagonall(int value) {
		for (int k = 0; k < 3; k++) {
            for(int i = 3 + k, j = 0; j <= 3 - k; i += 2 - k, j += 3 - k) {
                for (int l = 0; l < k + 1; l++) {
                	if (gameBoard[i - l][j + l] == value && gameBoard[i - 1 - l][j + 1 + l] == value &&
                			gameBoard[i - 2 - l][j + 2 + l] == value && gameBoard[i - 3 - l][j + 3 + l] == value) {
                		if (value == 1) {
                			gameBoard[i - l][j + l] = 2; gameBoard[i - 1 - l][j + 1 + l] = 2; gameBoard[i - 2 - l][j + 2 + l] = 2; gameBoard[i - 3 - l][j + 3 + l] = 2;
                		}
                		else {
                			gameBoard[i - l][j + l] = -2; gameBoard[i - 1 - l][j + 1 + l] = -2; gameBoard[i - 2 - l][j + 2 + l] = -2; gameBoard[i - 3 - l][j + 3 + l] = -2;
                		}
                		return true;
                	}
                		
                }
            }
        }
		return false;
	}
	
	public boolean isWinSecondDiagonall(int value) {
		for(int k = 0; k < 3; k++) {
			for (int i = 5, j = 3 + k; j <= 6; i -= 2 - k, j += 3 - k) {
				for (int l = 0; l < k + 1; l++) {	
					if(gameBoard[i - l][j - l] == value && gameBoard[i - l - 1][j - l - 1] == value &&
							gameBoard[i - l - 2][j - l - 2] == value && gameBoard[i - l - 3][j - l - 3] == value) {
						if (value == 1) {
							gameBoard[i - l][j - l] = 2; gameBoard[i - l - 1][j - l - 1] = 2; gameBoard[i - l - 2][j - l - 2] = 2; gameBoard[i - l - 3][j - l - 3] = 2;
						}
						else {
							gameBoard[i - l][j - l] = -2; gameBoard[i - l - 1][j - l - 1] = -2; gameBoard[i - l - 2][j - l - 2] = -2; gameBoard[i - l - 3][j - l - 3] = -2;
						}
						return true;		
					}
				}
			}
		}
		return false;
	}
	
}

	

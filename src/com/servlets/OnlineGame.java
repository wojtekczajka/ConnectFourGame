package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.handlers.GameHandler;
import com.handlers.HTMLHandler;
import com.handlers.PlayersHandler;

/**
 * Servlet implementation class OnlineGame
 */
@WebServlet("/OnlineGame")
public class OnlineGame extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, GameHandler> games;
	private Map<String, PlayersHandler> players;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineGame() {
        super();
        games = new TreeMap<>();
        players = new TreeMap<>();
    }
    
    public boolean isExistingGame(String gameID) {
    	if(games.get(gameID) == null)
    		return false;
    	return true;
    }
    
    public boolean isExistingPayers(String gameID) {
    	if(players.get(gameID) == null)
    		return false;
    	return true;
    }

    public GameHandler getGame(String gameID) {
    	return games.get(gameID);
    }
    
    public PlayersHandler getPlayers(String gameID) {
    	return players.get(gameID);
    }
    
    public GameHandler putNewGame(String gameID) {
    	GameHandler newGame = new GameHandler();
    	games.put(gameID, newGame);
    	return newGame;
    }
    
    public PlayersHandler putNewPlayers(String gameID) {
    	PlayersHandler p = new PlayersHandler();
    	players.put(gameID, p);
    	return p;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		    PlayersHandler currentPlayers;
		    
		    HttpSession session = request.getSession();
		    String gameID = (String) session.getAttribute("gameID");
		    String player = (String) session.getAttribute("player");
		    String colChoice = request.getParameter("colChoice");
		    
		    GameHandler game;
		    
		    if (!isExistingGame(gameID)) {
		    	game = putNewGame(gameID);
		    }
		    else {
		    	game = getGame(gameID);
		    }
		    
		    if (!isExistingPayers(gameID)) {
		    	currentPlayers = putNewPlayers(gameID);
		    }
		    else {
		    	currentPlayers = getPlayers(gameID);
		    }
		    
		    if (currentPlayers.player1.makeMove == false && currentPlayers.player1.waitingForMove == false && currentPlayers.player1.readyForMove == false) {
		    	currentPlayers.player1.makeMove = true;
		    	currentPlayers.player1.waitingForMove = false;
		    	currentPlayers.player1.readyForMove = false;
		    	players.put(gameID, currentPlayers);
		    	out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard(), false));
		    	return; 	
		    }
		    
		    if (currentPlayers.player2.makeMove == false && currentPlayers.player2.waitingForMove == false && currentPlayers.player2.readyForMove == false) {
		    	currentPlayers.player2.makeMove = false;
		    	currentPlayers.player2.waitingForMove = true;
		    	players.put(gameID, currentPlayers);
		    	out.print(HTMLHandler.connectFourWaitGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard()));
		    	return;
		    }
		    
		    int counter = 0;
		    
		    while (counter < 15) {
		    	if (session.getAttribute("player").equals("player1")) {
		    		if (currentPlayers.player1.makeMove == true && currentPlayers.player2.waitingForMove == true) {
		    			System.out.println("1 if");
		    			currentPlayers.player1.waitingForMove = true;
		    			currentPlayers.player1.makeMove = false;
		    			currentPlayers.player1.readyForMove = false;
		    			currentPlayers.player2.readyForMove = true;
		    			currentPlayers.player2.waitingForMove = false;
		    			players.put(gameID, currentPlayers);
		    			if (game.makeMove(Integer.valueOf(colChoice), 1) == 0) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong move, repeat again", "multi_player", game.getGameBoard(), false));
		    	   		 	return;
		    			}
		    			if (game.isWin(1)) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "start", game.getGameBoard(), true));
		   		    	 	return;
		    			}
		    			out.print(HTMLHandler.connectFourWaitGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard()));
		    			return;
		    		}
		    		if (currentPlayers.player1.waitingForMove == true) {
		    			System.out.println("2 if");
				    	out.print(HTMLHandler.connectFourWaitGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard()));
				    	return;
		    		}
		    		if (currentPlayers.player1.readyForMove == true) {
		    			if (game.isWin(-1)) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You lose", "start", game.getGameBoard(), true));
		   		    	 	games.remove(gameID);
		   		    	 	return;
		    			}
		    			if (game.isGameBoardFull()) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "Draw", game.getGameBoard(), true));
		   		    	 	games.remove(gameID);
		   		    	 	return;
		    			}
		    			System.out.println("3 if");
		    			out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard(), false));
		    			currentPlayers.player1.readyForMove = false;
		    			currentPlayers.player1.makeMove = true;
		    			return;
		    		}
		    	}
		    	else {
		    		if (currentPlayers.player2.makeMove == true) {
		    			System.out.println("4 if");
		    			currentPlayers.player2.waitingForMove = true;
		    			currentPlayers.player2.makeMove = false;
		    			currentPlayers.player2.readyForMove = false;
		    			currentPlayers.player1.readyForMove = true;
		    			currentPlayers.player1.waitingForMove = false;
		    			game.makeMove(Integer.valueOf(colChoice), -1);
		    			if (game.isWin(-1)) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "start", game.getGameBoard(), true));
		   		    	 	return;
		    			}
		    			if (game.isGameBoardFull()) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "Draw", game.getGameBoard(), true));
		   		    	 	return;
		    			}
		    			out.print(HTMLHandler.connectFourWaitGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard()));
		    			return;
		    		}
		    		if (currentPlayers.player2.waitingForMove == true) {
		    			System.out.println("5 if");
				    	out.print(HTMLHandler.connectFourWaitGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard()));
				    	return;
		    		}
		    		if (currentPlayers.player2.readyForMove == true) {
		    			System.out.println("6 if");
		    			if (game.isWin(2)) {
		    				out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You lose", "start", game.getGameBoard(), true));
		   		    	 	games.remove(gameID);
		   		    	 	return;
		    			}
		    			out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You are playing online", "multi_player", game.getGameBoard(), false));
		    			currentPlayers.player2.readyForMove = false;
		    			currentPlayers.player2.makeMove = true;
		    			return;
		    		}
		    	}
		    	counter++;
		    }
		    
			
		} catch(Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
        	out.print(HTMLHandler.connectFourErrorPage(request.getContextPath(), "Something went wrong, press return to go back to the start page"));
        	out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

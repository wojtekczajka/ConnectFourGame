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

import com.handlers.Game;
import com.handlers.HTMLHandler;

/**
 * Servlet implementation class OnlineGame
 */
@WebServlet("/OnlineGame")
public class OnlineGame extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Game> games;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineGame() {
        super();
        games = new TreeMap<>();
    }
    
    public boolean isExistingGame(String gameID) {
    	if(games.get(gameID) == null)
    		return false;
    	return true;
    }
    
    public Game getGame(String gameID) {
    	return games.get(gameID);
    }
    
    public Game putNewGame(String gameID) {
    	Game newGame = new Game();
    	games.put(gameID, newGame);
    	return newGame;
    }
    
    public boolean isGameSet(Game game) {
    	return game.player1 != null && game.player2 != null;
    }
    
    public void putPlayer(HttpSession session, Game game) {
    	if (game.player1 == null)
    		game.player1 = session;
    	else 
    		game.player2 = session;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String colChoice = request.getParameter("colChoice");
		String gameID = String.valueOf(session.getAttribute("gameID"));
		String userLogin = (String) session.getAttribute("userLogin");
		String startingPlayerLogin = (String) session.getAttribute("startingPlayer");
		Game currentGame;
		String player1Login = "kkk";
		String player2Login = "ddd";
		
		if (!isExistingGame(gameID)) 
			currentGame = putNewGame(gameID);
		else
			currentGame = getGame(gameID);
		
		if (userLogin == startingPlayerLogin) {
			System.out.println("co ja robie tu");
			if (!isGameSet(currentGame)) {
				session.setAttribute("showGameBoard", "true");
				session.setAttribute("updateGameBoard", "false");
				currentGame.player1 = session;
			}
		} 
		else {
			if (!isGameSet(currentGame)) {
				session.setAttribute("showGameBoard", "false");
				session.setAttribute("updateGameBoard", "false");
				currentGame.player2 = session;
			}			
		}
		
		while (true) {
			if (userLogin != startingPlayerLogin) {
				if (currentGame.player2.getAttribute("updateGameBoard").equals("true")) {
					
					if (currentGame.makeMove(Integer.valueOf(colChoice), -1) == 0) {
						out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong move, repeat again", "servlet4", currentGame.getGameBoard(), false));
			    		out.close();
			    		return;
					}
					
					currentGame.player2.setAttribute("updateGameBoard", "false");
					currentGame.player1.setAttribute("showGameBoard", "true");
					
					if (currentGame.isWin(-1)) {
						out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You won!", "servlet5", currentGame.getGameBoard(), true));
			    		out.close();
			    		return;
					}
				}
				if (currentGame.player2.getAttribute("showGameBoard").equals("true")) {
					if (currentGame.isWin(1)) {
						out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "You lost, " + player1Login + "win", "servlet5", currentGame.getGameBoard(), true));
						out.close();
						return;
					}
					currentGame.player2.setAttribute("updateGameBoard", "true");
					currentGame.player2.setAttribute("showGameBoard", "false");
					out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Playing against " + player1Login, "servlet4", currentGame.getGameBoard(), false));
					out.close();
					return;
				}
			}
			else {
				System.out.println(currentGame.player1.getAttribute("showGameBoard"));
				if (currentGame.player1.getAttribute("updateGameBoard").equals("true")) {
					if (currentGame.makeMove(Integer.valueOf(colChoice), 1) == 0) {
						out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong move, repeat again", "servlet4", currentGame.getGameBoard(), false));
			    		out.close();
			    		return;
					}
					
					currentGame.player1.setAttribute("updateGameBoard", "false");
					currentGame.player2.setAttribute("showGameBoard", "true");
					
					if (currentGame.isWin(1)) {
						out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You won!", "servlet5", currentGame.getGameBoard(), true));
			    		out.close();
			    		return;
					}
				}
				if (currentGame.player1.getAttribute("showGameBoard").equals("true")) {
					if (currentGame.isWin(-1)) {
						out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "You lost, " + player2Login + "win", "servlet5", currentGame.getGameBoard(), true));
						out.close();
						return;
					}
					currentGame.player1.setAttribute("updateGameBoard", "true");
					currentGame.player1.setAttribute("showGameBoard", "false");
					out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Playing against " + player2Login, "servlet4", currentGame.getGameBoard(), false));
					out.close();
					return;
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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

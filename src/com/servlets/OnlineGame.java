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
	private Map<String, Game> games = new TreeMap<>();
	private int x = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineGame() {
        super();
        // TODO Auto-generated constructor stub
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
		} else {
			if (!isGameSet(currentGame)) {
				session.setAttribute("showGameBoard", "false");
				session.setAttribute("updateGameBoard", "false");
				currentGame.player2 = session;
			}			
		}
		
		while (true) {
			if (userLogin != startingPlayerLogin) {
				if (currentGame.player2.getAttribute("updateGameBoard").equals("true")) {
					System.out.println("player2 pierwszy if");
					currentGame.makeMove(Integer.valueOf(colChoice), -1);
					currentGame.player2.setAttribute("updateGameBoard", "false");
					currentGame.player1.setAttribute("showGameBoard", "true");
					System.out.println("tututu:" + currentGame.player1.getAttribute("showGameBoard"));
				}
				if (currentGame.player2.getAttribute("showGameBoard").equals("true")) {
					System.out.println("player2 drugi if");
					currentGame.player2.setAttribute("updateGameBoard", "true");
					currentGame.player2.setAttribute("showGameBoard", "false");
					out.println(HTMLHandler.connectFourMultiGamePage(request.getContextPath(), currentGame.getGameBoard()));
					out.close();
					return;
				}
			}
			else {
				System.out.println(currentGame.player1.getAttribute("showGameBoard"));
				if (currentGame.player1.getAttribute("updateGameBoard").equals("true")) {
					System.out.println("player1 pierwszy if");
					currentGame.makeMove(Integer.valueOf(colChoice), 1);
					currentGame.player1.setAttribute("updateGameBoard", "false");
					currentGame.player2.setAttribute("showGameBoard", "true");
				}
				if (currentGame.player1.getAttribute("showGameBoard").equals("true")) {
					System.out.println("player1 drugi if");
					currentGame.player1.setAttribute("updateGameBoard", "true");
					currentGame.player1.setAttribute("showGameBoard", "false");
					out.println(HTMLHandler.connectFourMultiGamePage(request.getContextPath(), currentGame.getGameBoard()));
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
		
		
//		while (true) {
//			if (userLogin == startingPlayerLogin) {
//				if (session.getAttribute("move").equals("true") && currentGame.player2.getAttribute("move").equals("false")) {
//					System.out.println("if dla plejera pierwszego do zrobienia ruchu");
//					out.println(HTMLHandler.connectFourMultiGamePage(request.getContextPath(), currentGame.getGameBoard()));
//					out.close();
//					session.setAttribute("move", "false");
//					session.setAttribute("sendResponse", "false");
//					currentGame.player1 = session;
//					return;
//				}
//				if (session.getAttribute("move").equals("false") && session.getAttribute("sendResponse").equals("true")) {
//					System.out.println("drugi if dla plejera pierwszego do zrobienia ruchu");
//					session.setAttribute("move", "false");
//					session.setAttribute("sendResponse", "false");
//					currentGame.makeMove(Integer.valueOf(colChoice), 1);
//				}
//			}
//			else {
//				if (session.getAttribute("move").equals("true") && currentGame.player1.getAttribute("move").equals("false")) {
//					
//				}
//			}
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

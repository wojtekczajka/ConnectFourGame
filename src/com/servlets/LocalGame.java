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
 * Servlet implementation class LocalGame
 */
@WebServlet("/LocalGame")
public class LocalGame extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Game> games;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalGame() {
        super();
        games = new TreeMap<>();
    }
    
    public boolean isExistingGame(String gameID) {
    	if(games.get(gameID) == null)
    		return false;
    	return true;
    }
    
    public void putNewGame(String userLogin) {
    	games.put(userLogin, new Game());
    }
    
    public Game getGame(String userLogin) {
    	return games.get(userLogin);
    }
    
//    public void setNewLocalGame(HttpSession session) {
//    	game = new Game();
//    	session.setAttribute("gameState", "player1Move");
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession();
	    String gameID = (String) session.getAttribute("gameID");
	    String colChoice = request.getParameter("colChoice");
	    String gameState = (String) session.getAttribute("gameState");
	    
	    if (!isExistingGame(gameID))
	    	 putNewGame(gameID);
	    Game userGame = getGame(gameID);
	    
	    if (gameState.equals("startNewGame")) {
	    	session.setAttribute("gameState", "player1Move");
	    	out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Player1 move", "servlet3", userGame.getGameBoard(), false));
	    }
	    if (userGame.isGameBoardFull()) {
	    	out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Draw", "servlet5", userGame.getGameBoard(), true));
	    	out.close();
	    	return;
	    }
	    else if (session.getAttribute("gameState").equals("player1Move")) {
	    		if (userGame.makeMove(Integer.valueOf(colChoice), 1) == 0) {
	    			out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong Player1 move, repeat again", "servlet3", userGame.getGameBoard(), false));
		    		out.close();
		    		return;
	    		}
	    		if (userGame.isWin(1)) {
	    			out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Player1 win!", "servlet5", userGame.getGameBoard(), true));
		    		session.setAttribute("gameState", "startNewGame");
		    		games.remove(gameID);
	    		}
	    		else {
	    			out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Player2 move", "servlet3", userGame.getGameBoard(), false));
	    			session.setAttribute("gameState", "player2Move");
	    		}
	    }
	    else if (session.getAttribute("gameState").equals("player2Move")) {
	    	if (userGame.makeMove(Integer.valueOf(colChoice), -1) == 0) {
    			out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong Player2 move, repeat again", "servlet3", userGame.getGameBoard(), false));
	    		out.close();
	    		return;
    		}
    		if (userGame.isWin(-1)) {
    			out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Player2 win!", "servlet3", userGame.getGameBoard(), true));
	    		session.setAttribute("gameState", "startNewGame");
	    		games.remove(gameID);
    		}
    		else {
    			out.println(HTMLHandler.connectFourGamePage(request.getContextPath(), "Player1 move", "servlet3", userGame.getGameBoard(), false));
    			session.setAttribute("gameState", "player1Move");
    		}
	    }
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

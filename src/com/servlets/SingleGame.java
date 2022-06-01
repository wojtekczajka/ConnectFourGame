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

/**
 * Servlet implementation class SingleGame
 */
@WebServlet("/SingleGame")
public class SingleGame extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, GameHandler> games;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleGame() {
    	super();
    	games = new TreeMap<>();
    }
    
    public boolean isExistingGame(String gameID) {
    	if(games.get(gameID) == null)
    		return false;
    	return true;
    }
    
    public void putNewGame(String userLogin) {
    	games.put(userLogin, new GameHandler());
    }
    
    public GameHandler getGame(String userLogin) {
    	return games.get(userLogin);
    }
    
    public void makeRequestMove(GameHandler game, String colChoice, String gameID, String contextPatch, PrintWriter out) {
    	if (game.makeMove(Integer.valueOf(colChoice), 1) == 0) {
    		out.print(HTMLHandler.connectFourGamePage(contextPatch, "Wrong move, repeat again", "single_game", game.getGameBoard(), false));
   		 	return;
   	 	}
   		 
   	 	if (game.makeRandomMove(-1) == 0) {
   		 	out.print(HTMLHandler.connectFourGamePage(contextPatch, "Draw", "start", game.getGameBoard(), true));
	    	games.remove(gameID);
	    	return;
   	 	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { /*Declaration of the get method*/
			  
			 response.setContentType("text/html");
		     PrintWriter out = response.getWriter();
		  
		     HttpSession session = request.getSession(false);
		     
		     String gameID = (String) session.getAttribute("gameID");
		     String colChoice = request.getParameter("colChoice");

		     if (!isExistingGame(gameID))
		    	 putNewGame(gameID);
		     GameHandler userGame = getGame(gameID);
		     
		     if (colChoice != null) {
		    	 if (userGame.makeMove(Integer.valueOf(colChoice), 1) == 0) {
		    		 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong move, repeat again", "single_game", userGame.getGameBoard(), false));
		    		 out.close();
		    		 return;
		    	 }
		    		 
		    	 if (userGame.makeRandomMove(-1) == 0) {
		    		 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Draw", "start", userGame.getGameBoard(), true));
			    	 games.remove(gameID);
			    	 return;
		    	 }
		     }
		     
		     
		     if (userGame.isWin(1)) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "start", userGame.getGameBoard(), true));
		    	 games.remove(gameID);
		    	 
		     }
		     else if (userGame.isWin(-1)) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "CPU win", "start", userGame.getGameBoard(), true));
		    	 games.remove(gameID);
		     }
		     else if (userGame.isGameBoardFull()) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Draw", "start", userGame.getGameBoard(), true));
		    	 games.remove(gameID);
		     }
		     else {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You are playing against the computer", "single_game", userGame.getGameBoard(), false));
		     }
		     out.close();
            
        }
        catch (Exception e) {
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

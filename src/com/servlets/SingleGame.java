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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { /*Declaration of the get method*/
			  
			 response.setContentType("text/html");
		     PrintWriter out = response.getWriter();
		  
		     HttpSession session = request.getSession(false);
		  
		     String userLogin = (String) session.getAttribute("userLogin");
		     String gameID = (String) session.getAttribute("gameID");
		     String colChoice = request.getParameter("colChoice");

		     if (!isExistingGame(gameID))
		    	 putNewGame(gameID);
		     GameHandler userGame = getGame(gameID);
		     
		     if (colChoice != null) {
		    	 if (userGame.makeMove(Integer.valueOf(colChoice), 1) == 0) {
		    		 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Wrong move, repeat again", "servlet5", userGame.getGameBoard(), false));
		    		 out.close();
		    		 return;
		    	 }
		    		 
		    	 userGame.makeRandomMove(-1);
		     }
		     
		     if (userGame.isWin(1)) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You win", "servlet5", userGame.getGameBoard(), true));
		    	 games.remove(userLogin);
		    	 
		     }
		     else if (userGame.isWin(-1)) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "CPU win", "servlet5", userGame.getGameBoard(), true));
		    	 games.remove(userLogin);
		     }
		     else if (userGame.isGameBoardFull()) {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "Draw", "servlet5", userGame.getGameBoard(), true));
		    	 games.remove(userLogin);
		     }
		     else {
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), "You are playing against the computer", "servlet2", userGame.getGameBoard(), false));
		     }
		     out.close();
            
        }
        catch (Exception e) {
            e.printStackTrace();
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

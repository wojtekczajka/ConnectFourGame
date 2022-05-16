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
 * Servlet implementation class SingleGame
 */
@WebServlet("/SingleGame")
public class SingleGame extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Game> games;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleGame() {
    	
    	super();
    	games = new TreeMap<>();
    }
    
    public boolean isExistingGame(String userLogin) {
    	if(games.get(userLogin) == null)
    		return false;
    	return true;
    }
    
    public void putNewGame(String userLogin) {
    	games.put(userLogin, new Game());
    }
    
    public Game getGame(String userLogin) {
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
		  
		     String userLogin = (String)session.getAttribute("userLogin");
		     String gameChoice = (String)session.getAttribute("gameChoice");
		     String colChoice = request.getParameter("colChoice");

		     if (!isExistingGame(userLogin))
		    	 putNewGame(userLogin);
		     Game userGame = getGame(userLogin);
		     
		     if (colChoice != null) {
		    	 userGame.makeMove(Integer.valueOf(colChoice), 1);
		    	 userGame.makeRandomMove(-1);
		     }
		     
		     if (userGame.isWin(-1)) 
		    	 out.println(HTMLHandler.infoPage(request.getContextPath(), "You lost don't worry :)"));
		     else if (userGame.isWin(1)) 
		    	 out.println(HTMLHandler.infoPage(request.getContextPath(), "You win, congrats :)"));
		     else {
		    	 out.println(userLogin);
		    	 out.print(HTMLHandler.connectFourGamePage(request.getContextPath(), userGame.getGameBoard()));
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

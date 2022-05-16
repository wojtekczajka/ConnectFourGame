package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

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
    private Game game;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalGame() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void setNewLocalGame(HttpSession session) {
    	game = new Game();
    	session.setAttribute("gameState", "player1Move");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession();
	    if (session.getAttribute("gameState").equals("startNewGame")) {
	    	setNewLocalGame(session);
	    	out.println(HTMLHandler.localGamePage(request.getContextPath(), "Player1 move", game.getGameBoard()));
	    }
	    else if (session.getAttribute("gameState").equals("player1Move")) {
	    		game.makeMove(Integer.valueOf(request.getParameter("colChoice")), 1);
	    		if (game.isWin(1)) {
	    			out.println(HTMLHandler.infoPage(request.getContextPath(), "Player 1 win! :)"));
		    		session.setAttribute("gameState", "startNewGame");
	    		}
	    		else {
	    			out.println(HTMLHandler.localGamePage(request.getContextPath(), "Player2 move", game.getGameBoard()));
	    			session.setAttribute("gameState", "player2Move");
	    		}
	    }
	    else if (session.getAttribute("gameState").equals("player2Move")) {
	    	game.makeMove(Integer.valueOf(request.getParameter("colChoice")), -1);
    		if (game.isWin(-1)) {
    			out.println(HTMLHandler.infoPage(request.getContextPath(), "Player 2 win! :)"));
	    		session.setAttribute("gameState", "startNewGame");
    		}
    		else {
    			out.println(HTMLHandler.localGamePage(request.getContextPath(), "Player1 move", game.getGameBoard()));
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

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.handlers.HTMLHandler;

/**
 * Servlet implementation class SessionCreator
 */
@WebServlet("/SessionCreator")
public class SessionCreator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<HttpSession> usersInLobby = new ArrayList<HttpSession>();
    private long gameID = 0;  
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionCreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); // Setting the content type to text
        
        String gameChoice = request.getParameter("gameChoice");
        
        HttpSession session = request.getSession();
        session.setAttribute("gameChoice", gameChoice);
        
        if (gameChoice.equals("MultiPlayer")) {
        	int counter = 0;
        	try {
        		usersInLobby.add(session);
        		session.removeAttribute("gameID");
				while (true) {
					if (counter == 30) {
						usersInLobby.remove(session);
						PrintWriter out = response.getWriter();
						out.print(HTMLHandler.connectFourErrorPage(request.getContextPath(),  "Waiting for opponent timeout :("));
						return;
					}
					System.out.println(session.getAttribute("gameID") == null);
					if (usersInLobby.size() > 1 && session.getAttribute("gameID") == null) {
						usersInLobby.remove(session);
						session.setAttribute("gameID", Long.toString(gameID));
						session.setAttribute("waitingForMove", "false");
						session.setAttribute("makeMove", "true");
						session.setAttribute("player", "player1");
						HttpSession opponentSession = usersInLobby.remove(0);
						opponentSession.setAttribute("gameID", Long.toString(gameID));
						opponentSession.setAttribute("waitingForMove", "true");
						opponentSession.setAttribute("makeMove", "false");
						opponentSession.setAttribute("player", "player2");
						gameID += 1;
					}
					if (session.getAttribute("gameID") != null) 
			            break; // IMPORTANT BREAK !!!
					Thread.sleep(500);	
					counter++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/multi_player");
            dispatcher.forward(request, response);
        }
        else if(gameChoice.equals("SinglePlayer")) {
        	session.setAttribute("gameID", Long.toString(gameID));
        	gameID += 1;
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/single_game");
        	dispatcher.forward(request, response);
        }
        else {
        	session.setAttribute("gameState", "startNewGame");
        	session.setAttribute("gameID", Long.toString(gameID));
        	gameID += 1;
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/local_game");
            dispatcher.forward(request, response);
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

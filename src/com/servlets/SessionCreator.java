package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCreator
 */
@WebServlet("/SessionCreator")
public class SessionCreator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<HttpSession> usersInLobby = new ArrayList<HttpSession>();
    private int gameID = 0;  
    
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
        
        String userLogin = request.getParameter("userLogin"); 
        String gameChoice = request.getParameter("gameChoice");
        
        HttpSession session = request.getSession();
        session.setAttribute("userLogin", userLogin);
        session.setAttribute("gameChoice", gameChoice);
        
        if (gameChoice.equals("MultiPlayer")) {
        	int counter = 0;
        	try {
        		usersInLobby.add(session);
        		session.removeAttribute("gameID");
				while (true) {
					if (counter == 15) {
						usersInLobby.remove(session);
						return;
					}
					System.out.println(session.getAttribute("gameID") == null);
					if (usersInLobby.size() > 1 && session.getAttribute("gameID") == null) {
						usersInLobby.remove(session);
						session.setAttribute("gameID", gameID);
						session.setAttribute("move", "true");
						session.setAttribute("startingPlayer", userLogin);
						HttpSession opponentSession = usersInLobby.remove(0);
						opponentSession.setAttribute("gameID", Integer.toString(gameID));
						opponentSession.setAttribute("move", "false");
						opponentSession.setAttribute("startingPlayer", userLogin);
						gameID += 1;
					}
					if (session.getAttribute("gameID") != null) 
			            break; // IMPORTANT BREAK !!!
					Thread.sleep(1000);	
					counter++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/servlet4");
            dispatcher.forward(request, response);
        }
        else if(gameChoice.equals("SinglePlayer")) {
        	session.setAttribute("gameID", Integer.toString(gameID));
        	gameID += 1;
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/servlet2");
        	dispatcher.forward(request, response);
        }
        else {
        	session.setAttribute("gameState", "startNewGame");
        	session.setAttribute("gameID", Integer.toString(gameID));
        	gameID += 1;
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/servlet3");
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

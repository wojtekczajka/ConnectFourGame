package com.handlers;

import javax.servlet.http.HttpSession;

public class OnlineGameHandler extends GameHandler {
	
	public static final int FIRST_PLAYER = 0;
	public static final int SECOND_PLAYER = 1;
	
	private SessionHandler player1;
	private SessionHandler player2;
	
	public void setSession(HttpSession session) {
		if (player1 == null)
			player1 = new SessionHandler(session);
		else
			player2 = new SessionHandler(session);
	}
	
	public boolean isSet() {
		return player1 != null && player2 != null;
	}
	
	public void setPlayer(HttpSession session, int player) {
		if (player == FIRST_PLAYER)
			player1.setSession(session);
		else if (player == SECOND_PLAYER)
			player2.setSession(session);
	}
	
	public boolean isReadyToUpdate(int player) {
		if (player == FIRST_PLAYER)
			return player1.getAttribute("updateGameBoard").equals("true");
		return player2.getAttribute("updateGameBoard").equals("true");
	}
	
	public boolean isReadyToShow(int player) {
		if (player == FIRST_PLAYER)
			return player1.getAttribute("showGameBoard").equals("true");
		return player2.getAttribute("showGameBoard").equals("true");
	}
	
	public void updatePlayer(String attrName, String attr, int player) {
		if (player == FIRST_PLAYER)
			player1.setAttribute(attrName, attr);
		else if (player == SECOND_PLAYER)
			player2.setAttribute(attrName, attr);
	}

}

package com.handlers;

import javax.servlet.http.HttpSession;

public class SessionHandler {
	
	private HttpSession session;
	
	public SessionHandler(HttpSession session) {
		this.session = session;
	}
	
	public void setSession(HttpSession session) {
		System.out.println(this.session = null);
		this.session = session;
	}
	
	public String getAttribute(String attribute) {
		return (String) session.getAttribute(attribute);
	}
	
	public void setAttribute(String attrName, String attr) {
		session.setAttribute(attrName, attr);
	}

}

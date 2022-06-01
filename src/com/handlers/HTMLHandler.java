package com.handlers;

public class HTMLHandler {
		
	public static String connectFourStartPage(String contextPath) {
		//String url = contextPath + "/xptheme.jpg";
		String urlForCss = contextPath + "/style.css";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\""
				+ urlForCss
				+ "\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body class=\"hello-window\">" + 
				"<div class=\"window\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" +  
				"</div>\n" + 
				"<div class=\"window-body main-window\">\n" + 
				"<div class=\"field-row-stacked\">\n" + 
				"<form action=\"servlet1\">  \n" +
				"</div>\n" + 
				"<div>\n" + 
				"<button type=\"submit\" name=\"gameChoice\" value=\"SinglePlayer\">Single-Player</button>\n" + 
				"</div>\n" + 
				"<div>\n" + 
				"<button onclick=\"myFunction()\" type=\"submit\" name=\"gameChoice\" value=\"MultiPlayer\">2Players-Online (not working yet)</button>\n" +
				"</div>" +
				"<div>\n" + 
				"<button type=\"submit\" name=\"gameChoice\" value=\"MultiPlayerLocally\">2Players-Locally</button>\n" + 
				"</div>\n" + 
				"</form>  \n" +
				"</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<script>\n" + 
				"function myFunction() {\n" + 
				"  document.getElementById(\"popInfoWindow\").innerHTML = \"Waiting for the opponent\";\n" + 
				"}\n" + 
				"</script>" +
				"</body>\n" + 
				"\n" + 
				"</html>";
		return html;
	}
	
	public static String connectFourErrorPage(String contextPath, String msg) {
		//String url = contextPath + "/xptheme.jpg";
		String urlForCss = contextPath + "/style.css";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\""
				+ urlForCss
				+ "\">\n" + 
				"</head>\n" + 
				"<body class=\"hello-window\">" + 
				"<div>"+
				msg +
				"</div>\n" +  
				"<form action=\"start\">  \n" +
				"<button type=\"submit\" name=\"gameChoice\" value=\"SinglePlayer\">Return</button>\n" +  
				"</form>  \n" +
				"</body>\n" + 
				"</html>";
		return html;
	}
	
	public static String connectFourGamePage(String contextPath, String msg, String servlet, int[][] gameBoard, boolean isEndOfGame) {
		
		String urlForCss = contextPath + "/style.css";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\""
				+ urlForCss
				+ "\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>";
				if (!isEndOfGame)
					html += "<div>Make a move...</div>";
				html += "<div class=\"window\" >\n" + 
				"<div class=\"title-bar title-bar-game\">\n" + 
				"<div class=\"title-bar-text title-bar-game-text\">"
				+ msg
				+ "</div>" + 
				"</div>\n" +
				"<div class=\"window-body\">";
		for (int i = 0; i < 6; i++) {
			html += "<div class=\"row\">";
			for(int j = 0; j < 7; j++) {
				html += "<div ";
				if(gameBoard[i][j] == 1) {
					html += "class=\"playerOne\"";
							
				}
				else if(gameBoard[i][j] == -1) {
					html += "class=\"playerTwo\"";
							
				}
				else if(gameBoard[i][j] == 2) {
					html += "class=\"playerOneWin\"";
				}
				else if(gameBoard[i][j] == -2) {
					html += "class=\"playerTwoWin\"";
				}
				else {
					html += "class=\"empty\"";
				}
				html += "></div>";
			}
			html += "</div>";
		}
		
		html += "<div class=\"buttons\">";
		html += "<form action=\"";
		html +=	servlet;
		html += "\">";
		if (!isEndOfGame) {
			for (int i = 0; i < 7; i++) {
				String value = Integer.toString(i);
				html += "<button type=\"submit\" name=\"colChoice\" value=\"" + value + "\">";
				html += value;
				html += "</button>";
			}
		}
		else {
			html += "<button type=\"submit\"\">";
			html += "New Game";
			html += "</button>";
		}
		html += "</form>  \n";
		html += "</div>\n";
		html +=	"</div>\n";
		html +=	"</div>\n"; 
		html +=	"</body>\n";
		html +=	"</html>";
		
		return html;
	}
	
public static String connectFourWaitGamePage(String contextPath, String msg, String servlet, int[][] gameBoard) {
		
		String urlForCss = contextPath + "/style.css";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\""
				+ urlForCss
				+ "\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>";
				html += "<div class=\"window\" >\n" + 
				"<div class=\"title-bar title-bar-game\">\n" + 
				"<div class=\"title-bar-text title-bar-game-text\">"
				+ msg
				+ "</div>" + 
				"</div>\n" +
				"<div class=\"window-body\">";
		for (int i = 0; i < 6; i++) {
			html += "<div class=\"row\">";
			for(int j = 0; j < 7; j++) {
				html += "<div ";
				if(gameBoard[i][j] == 1) {
					html += "class=\"playerOne\"";
							
				}
				else if(gameBoard[i][j] == -1) {
					html += "class=\"playerTwo\"";
							
				}
				else if(gameBoard[i][j] == 2) {
					html += "class=\"playerOneWin\"";
				}
				else if(gameBoard[i][j] == -2) {
					html += "class=\"playerTwoWin\"";
				}
				else {
					html += "class=\"empty\"";
				}
				html += "></div>";
			}
			html += "</div>";
		}
		
		html += "<div class=\"buttons\">";
		html += "<form action=\"";
		html +=	servlet;
		html += "\">";
		html += "<button type=\"submit\"\">";
		html += "Refresh";
		html += "</button>";
		html += "</form>  \n";
		html += "</div>\n";
		html +=	"</div>\n";
		html +=	"</div>\n"; 
		html +=	"</body>\n";
		html +=	"</html>";
		
		return html;
	}
	
}




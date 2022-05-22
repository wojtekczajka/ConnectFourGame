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
				"<label for=\"login\">Login</label>\n" + 
				"<input name=\"userLogin\" type=\"text\" />\n" + 
				"</div>\n" + 
				"<div>\n" + 
				"<button type=\"submit\" name=\"gameChoice\" value=\"SinglePlayer\">Single-Player</button>\n" + 
				"</div>\n" + 
				"<div>\n" + 
				"<button onclick=\"myFunction()\" type=\"submit\" name=\"gameChoice\" value=\"MultiPlayer\">2Players-Online</button>\n" +
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
				"<body>" +
				"<div>Make a move...</div>" +
				"<div class=\"window\" >\n" + 
				"<div class=\"title-bar title-bar-game\">\n" + 
				"<div class=\"title-bar-text title-bar-game-text\">"
				+ msg
				+ "</div>\n" + 
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
	
}




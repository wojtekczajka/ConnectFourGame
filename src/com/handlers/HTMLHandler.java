package com.handlers;

public class HTMLHandler {
		
	public static String connectFourStartPage(String contextPath) {
		String url = contextPath + "/xptheme.jpg";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"text-align: center; background-image: url(" +
				url +
				");\">" + 
				"<div id=\"popInfoWindow\"></div>" +
				"<div class=\"window\" style=\"width: 400px; height: 230px; margin: auto; margin-top: 200px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\">\n" + 
				"<div class=\"field-row-stacked\" style=\"width: 200px; margin: auto\">\n" + 
				"<form action=\"servlet1\">  \n" +
				"<label for=\"login\">Login</label>\n" + 
				"<input name=\"userLogin\" type=\"text\" />\n" + 
				"</div>\n" + 
				"<div style=\"margin: auto; text-align: center;\">\n" + 
				"<button style=\"width:200px; margin-top: 20px\" type=\"submit\" name=\"gameChoice\" value=\"SinglePlayer\">Single-Player</button>\n" + 
				"</div>\n" + 
				"<div style=\"margin: auto; text-align: center;\">\n" + 
				"<button onclick=\"myFunction()\" style=\"width:200px; margin-top: 20px\" type=\"submit\" name=\"gameChoice\" value=\"MultiPlayer\">2Players-Online</button>\n" +
				"<div style=\"margin: auto; text-align: center;\">\n" + 
				"<button style=\"width:200px; margin-top: 20px\" type=\"submit\" name=\"gameChoice\" value=\"MultiPlayerLocally\">2Players-Locally</button>\n" + 
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
	
	public static String connectFourGamePage(String contextPath, int[][] gameBoard) {
		String url = contextPath + "/xptheme.jpg";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"text-align: center; background-image: url(" +
				url +
				");\">" +
				"<div>Make a move...</div>" +
				"<div class=\"window\" style=\"width: 910px; height: 800px; margin: auto; margin-top: 60px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\">";
		for (int i = 0; i < 6; i++) {
			html += "<div style=\"width: 910px; height: 120px\">";
			for(int j = 0; j < 7; j++) {
				html += "<div style=\"float: left; width: 130; text-align: center; font-size: 50px;\">";
				html += Integer.toString(gameBoard[i][j]);
				html += "</div>";
			}
			html += "</div>";
		}
		
		html += "<div style=\"width: 910px; height: 50px\">";
		html += "<form action=\"servlet2\">  \n";
		for (int i = 0; i < 7; i++) {
			String value = Integer.toString(i);
			html += "<button style=\"float: left; width:130\" type=\"submit\" name=\"colChoice\" value=\"" + value + "\">";
			html += value;
			html += "</button>";
		}
		html += "</form>  \n";
		html += "</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		
		return html;
	}
	
	public static String connectFourMultiGamePage(String contextPath, int[][] gameBoard) {
		String url = contextPath + "/xptheme.jpg";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"text-align: center; background-image: url(" +
				url +
				");\">" +
				"<div>Make a move...</div>" +
				"<div class=\"window\" style=\"width: 910px; height: 800px; margin: auto; margin-top: 60px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\">";
		
		for (int i = 0; i < 6; i++) {
			html += "<div style=\"width: 910px; height: 120px\">";
			for(int j = 0; j < 7; j++) {
				html += "<div style=\"float: left; width: 130; text-align: center; font-size: 50px;\">";
				html += Integer.toString(gameBoard[i][j]);
				html += "</div>";
			}
			html += "</div>";
		}
		
		html += "<div style=\"width: 910px; height: 50px\">";
		html += "<form action=\"servlet4\">  \n";
		
		for (int i = 0; i < 7; i++) {
			String value = Integer.toString(i);
			html += "<button style=\"float: left; width:130\" type=\"submit\" name=\"colChoice\" value=\"" + value + "\">";
			html += value;
			html += "</button>";
		}
		
		html += "</form>  \n";
		html += "</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		
		return html;
	}
	
	public static String winnerInfoPage(String winner) {
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"<link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"background-color:black\">\n" + 
				"<div class=\"window\" style=\"width: 400px; height: 200px; margin: auto; margin-top: 90px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\" style=\"text-align: center;\">            \n" + 
				"<div class=\"field-row-stacked\" style=\"width: 200px; margin: auto\">\n" + 
				"<h3>" +
				winner +
				" WIN!</h3>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		return html;
	}
	
	public static String infoPage(String contextPath, String info) {
		String url = contextPath + "/xptheme.jpg";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"<link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"text-align: center; background-image: url(" +
				url +
				");\">" + 
				"<div class=\"window\" style=\"width: 400px; height: 200px; margin: auto; margin-top: 90px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\" style=\"text-align: center;\">            \n" + 
				"<div class=\"field-row-stacked\" style=\"width: 200px; margin: auto\">\n" + 
				"<h3>" +
				info +
				"</h3>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		return html;
	}
	
	public static String localGamePage(String contextPath, String info, int gameBoard[][]) {
		String url = contextPath + "/xptheme.jpg";
		String html = 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"    <link rel=\"stylesheet\" href=\"https://unpkg.com/xp.css\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"text-align: center; background-image: url(" +
				url +
				");\">" + 
				"<div>\n" + 
				info +
				"</div>" +
				"<div class=\"window\" style=\"width: 910px; height: 800px; margin: auto; margin-top: 60px\">\n" + 
				"<div class=\"title-bar\">\n" + 
				"<div class=\"title-bar-text\">Connect Four Game</div>\n" + 
				"<div class=\"title-bar-controls\">\n" + 
				"<button aria-label=\"Minimize\"></button>\n" + 
				"<button aria-label=\"Maximize\"></button>\n" + 
				"<button aria-label=\"Close\"></button>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"<div class=\"window-body\">";
		for (int i = 0; i < 6; i++) {
			html += "<div style=\"width: 910px; height: 120px\">";
			for(int j = 0; j < 7; j++) {
				html += "<div style=\"float: left; width: 130; text-align: center; font-size: 50px;\">";
				html += Integer.toString(gameBoard[i][j]);
				html += "</div>";
			}
			html += "</div>";
		}
		
		html += "<div style=\"width: 910px; height: 50px\">";
		html += "<form action=\"servlet3\">  \n";
		for (int i = 0; i < 7; i++) {
			String value = Integer.toString(i);
			html += "<button style=\"float: left; width:130\" type=\"submit\" name=\"colChoice\" value=\"" + value + "\">";
			html += value;
			html += "</button>";
		}
		html += "</form>  \n";
		html += "</div>\n" + 
				"</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		
		return html;
		
	}
	
}




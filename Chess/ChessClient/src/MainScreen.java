import java.awt.*;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private static BufferedReader messageIn;
	private static PrintWriter messageOut;
	private static int portNum = 3456;
	private static Socket socket;
	private String playerColor;
	private GameHistoryPanel gameHistoryPanel;
	private ClientGameBoard gameBoard;
	private GameChat gameChat;

	public MainScreen() {
		
		try {
			socket = new Socket("localhost", portNum);

			messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			messageOut = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Connection success");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		gameHistoryPanel = new GameHistoryPanel(messageOut);
		gameHistoryPanel.setSize(new Dimension(200, 400));
		
		gameBoard = new ClientGameBoard(messageOut, gameHistoryPanel);
		gameBoard.setSize(new Dimension(400,400));
		try {
			gameBoard.displayWaitingImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gameChat = new GameChat(messageOut);
		gameChat.setSize(new Dimension(600, 200));
		
		this.add(gameBoard);
		this.add(gameHistoryPanel);
		this.add(gameChat);
		
		this.setLayout(new BorderLayout(4, 8));
		this.add(gameBoard, BorderLayout.WEST);
		this.add(gameHistoryPanel, BorderLayout.EAST);
		this.add(gameChat, BorderLayout.SOUTH);
		
		this.getRootPane().setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void listenToServer() {

		try {
			while (true) {
				String input = messageIn.readLine();
				
				if (input != null) {
					System.out.println(input);
					if (input.startsWith("move")) {
						int[] coords = new int[4];
						int coordsIndex = 0;
						for (int i = 4; i < input.length(); i++) {
							if (input.charAt(i) == ' ') {
								coords[coordsIndex] = Character.getNumericValue(input.charAt(i + 1));
								coordsIndex++;
							}
						}

						if(gameBoard.getSpaces().get(coords[0]).get(coords[1]).getCurrentPieceId() == null){
							gameHistoryPanel.newMove(gameBoard.getSpaces().get(coords[2]).get(coords[3]).getCurrentPieceId(), coords[0], coords[1], coords[2], coords[3], false);
						}else{
							gameHistoryPanel.newMove(gameBoard.getSpaces().get(coords[2]).get(coords[3]).getCurrentPieceId(), coords[0], coords[1], coords[2], coords[3], true);

						}
						
						gameBoard.moveSpace(coords[0], coords[1], coords[2], coords[3]);
						
						gameBoard.setIsCurrentPlayer(true);
					}else if (input.startsWith("castle")){
						int[] coords = new int[2];
						int coordsIndex = 0;
						for (int i = 6; i < input.length(); i++) {
							if (input.charAt(i) == ' ') {
								coords[coordsIndex] = Character.getNumericValue(input.charAt(i + 1));
								coordsIndex++;
							}
						}
						
						if(coords[0] == 7 && coords[1] == 6){
							gameBoard.moveSpace(coords[0], coords[1], 7, 4);
							gameBoard.moveSpace(7, 5, 7, 7);
							gameHistoryPanel.castle(5);
						}else if(coords[0] == 7 && coords[1] == 2){
							gameBoard.moveSpace(coords[0], coords[1], 7, 4);
							gameBoard.moveSpace(7, 3, 7, 0);
							gameHistoryPanel.castle(3);
						}else if(coords[0] == 0 && coords[1] == 6){
							gameBoard.moveSpace(coords[0], coords[1], 0, 4);
							gameBoard.moveSpace(0, 5, 0, 7);
							gameHistoryPanel.castle(5);
						}else if(coords[0] == 0 && coords[1] == 2){
							gameBoard.moveSpace(coords[0], coords[1], 0, 4);
							gameBoard.moveSpace(0, 3, 0, 0);
							gameHistoryPanel.castle(3);
						}
						

						gameBoard.setIsCurrentPlayer(true);
					}else if (input.startsWith("invert")) {
						gameBoard.invertBoard();
					} else if (input.startsWith("Color")) {
						playerColor = input.substring(5);
						System.out.println(playerColor);

						if(playerColor.equals("white")){
							gameBoard.setPieces();
						}

					}else if (input.startsWith("checkOnly")){
						gameHistoryPanel.check();
					}else if (input.startsWith("checkmate")){
						gameHistoryPanel.checkmate();
					}else if (input.startsWith("stalemate")){
						JOptionPane.showMessageDialog(null, "Stalemate!");
						System.exit(0);
					}else if (input.startsWith("promotion")){
						tokenizePromotion(input);
					}else if(input.startsWith("concede")){
						JOptionPane.showMessageDialog(null, "Your opponent conceded!");
						System.exit(0);
					}else if(input.startsWith("draw")){
					    int drawReply = JOptionPane.showConfirmDialog(null, "Your opponent has proposed a draw.", "Draw", JOptionPane.YES_NO_OPTION);
					    if (drawReply == JOptionPane.YES_OPTION)
					    {
					    	messageOut.println("accept");
					    	JOptionPane.showMessageDialog(null, "The game has ended in a draw!");
					    	System.exit(0);
					    }else{
					    	messageOut.println("decline");
					    }
					}else if(input.startsWith("accept")){
						JOptionPane.showMessageDialog(null, "The game has ended in a draw!");
						System.exit(0);
					}else if(input.startsWith("decline")){
						JOptionPane.showMessageDialog(null, "Your opponent chose not to draw.");
					}else if(input.startsWith("exit")){
						JOptionPane.showMessageDialog(null, "Your opponent left!");
					}else if(input.startsWith("chat")){
						gameChat.recieveAndPrintMessage(input.substring(5));
					}

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void tokenizePromotion(String input) {
		
		int[] coords = new int[2];
		int coordsIndex = 0;
		String pieceId = "";
		String pieceColor;
		for (int i = 6; i < input.length(); i++) {
			if (input.charAt(i) == ' ' && coordsIndex < 2) {
				coords[coordsIndex] = Character.getNumericValue(input.charAt(i + 1));
				coordsIndex++;
			}else if(input.charAt(i) == ' ' && coordsIndex == 2){
				pieceId = input.substring(i + 1);
			}
		}
		
		if(pieceId.startsWith("white")){
			pieceColor = "white";
		}else{
			pieceColor = "black";
		}
		
		gameBoard.getSpaces().get(coords[0]).get(coords[1]).promote(pieceId, pieceColor);
		
		
	}
}
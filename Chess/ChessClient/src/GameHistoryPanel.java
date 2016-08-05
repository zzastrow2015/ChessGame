import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.PrintWriter;

public class GameHistoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel history;
	JPanel textContainer;
	JScrollPane historyScrollPanel;
	boolean blackTurn = false;
	boolean firstTurn = true;
	boolean scrollFlag = true;
	private PrintWriter messageOut;

	public GameHistoryPanel(PrintWriter messageOut2) {
		setSize(200, 400);
		setLayout(new BorderLayout());
		
		messageOut = messageOut2;

		JLabel title = new JLabel();
		title.setText("Game History");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setPreferredSize(new Dimension(200, 50));

		history = new JLabel();
		history.setText("<html></html>");
		history.setHorizontalAlignment(JLabel.LEFT);
		history.setVerticalAlignment(JLabel.TOP);
		history.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		history.setBackground(Color.WHITE);
		history.setOpaque(true);

		historyScrollPanel = new JScrollPane(history, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		historyScrollPanel.setPreferredSize(new Dimension(200, 300));
		historyScrollPanel.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				if (scrollFlag == true) {
					e.getAdjustable().setValue(e.getAdjustable().getMaximum());
					scrollFlag = false;
				}

			}
		});

		JButton concede = new JButton("Concede");
		
		concede.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "You have conceded.");
				messageOut.println("concede");
				System.exit(0);
				
			}
			
		});
		
		
		concede.setPreferredSize(new Dimension(100, 50));
		
		
		
		JButton draw = new JButton("Propose Draw");
		
		
		draw.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				messageOut.println("draw");
				JOptionPane.showMessageDialog(null, "Waiting on opponent to accept draw...");

				
			}
			
		});
		
		draw.setMargin(new Insets(0, 0, 0, 0));
		draw.setPreferredSize(new Dimension(100, 50));

		textContainer = new JPanel(new BorderLayout());
		textContainer.setPreferredSize(new Dimension(200, 350));
		textContainer.add(title, BorderLayout.NORTH);
		textContainer.add(historyScrollPanel, BorderLayout.SOUTH);

		JPanel buttonContainer = new JPanel(new BorderLayout());
		buttonContainer.setPreferredSize(new Dimension(200, 50));
		buttonContainer.add(concede, BorderLayout.EAST);
		buttonContainer.add(draw, BorderLayout.WEST);

		add(textContainer, BorderLayout.NORTH);
		add(buttonContainer, BorderLayout.SOUTH);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 400);
	}

	public void newMove(String piece, int x1, int y1, int x2, int y2, boolean capture) {

		scrollFlag = true;
		String pieceNotation = determinePieceNotation(piece);
		String endNotation = generateLocation(x1, y1);

		if (blackTurn == false) {
			if (firstTurn == true) {
				history.setText(
						getHistoryWithoutHTMLTag(history.getText()) + pieceNotation + endNotation + " " + "</html>");
				firstTurn = false;
			} else {
				if(capture == false){
					history.setText(getHistoryWithoutHTMLTag(history.getText()) + "<br><br>" + pieceNotation + endNotation
							+ " " + "</html>");	
				}else{
					history.setText(getHistoryWithoutHTMLTag(history.getText()) + "<br><br>" + pieceNotation + "x" + endNotation
							+ " " + "</html>");
				}
				

			}
			blackTurn = true;
		} else {
			if(capture == false){
				history.setText(getHistoryWithoutHTMLTag(history.getText()) + pieceNotation + endNotation + " " + "</html>");
				
			}else{
				history.setText(getHistoryWithoutHTMLTag(history.getText()) + pieceNotation + "x" + endNotation + " " + "</html>");
			}
			blackTurn = false;
		}

	}

	private String determinePieceNotation(String piece) {

		if (piece == "whitePawn" || piece == "blackPawn") {
			return "";
		} else if (piece == "whiteRook" || piece == "blackRook") {
			return "R";
		} else if (piece == "whiteKnight" || piece == "blackKnight") {
			return "N";
		} else if (piece == "whiteBishop" || piece == "blackBishop") {
			return "B";
		} else if (piece == "whiteQueen" || piece == "blackQueen") {
			return "Q";
		} else if (piece == "whiteKing" || piece == "blackKing") {
			return "K";
		}

		return "error!";
	}

	private String getHistoryWithoutHTMLTag(String fullText) {

		return fullText.substring(0, fullText.length() - 7);

	}

	private String generateLocation(int x, int y) {

		String xValue = "";
		String yValue = "";

		switch (y) {
		case 0:
			xValue = "a";
			break;
		case 1:
			xValue = "b";
			break;
		case 2:
			xValue = "c";
			break;
		case 3:
			xValue = "d";
			break;
		case 4:
			xValue = "e";
			break;
		case 5:
			xValue = "f";
			break;
		case 6:
			xValue = "g";
			break;
		case 7:
			xValue = "h";
			break;
		}

		switch (x) {
		case 0:
			yValue = "8";
			break;
		case 1:
			yValue = "7";
			break;
		case 2:
			yValue = "6";
			break;
		case 3:
			yValue = "5";
			break;
		case 4:
			yValue = "4";
			break;
		case 5:
			yValue = "3";
			break;
		case 6:
			yValue = "2";
			break;
		case 7:
			yValue = "1";
			break;
		}

		return xValue + yValue;
	}

	public void castle(int side) {

		if (side == 3) {
			if (blackTurn == false) {

				history.setText(getHistoryWithoutHTMLTag(history.getText()) + "<br><br>" + "0-0-0" + " " + "</html>");

				blackTurn = true;
			} else {
				history.setText(getHistoryWithoutHTMLTag(history.getText()) + "0-0-0" + " " + "</html>");
				blackTurn = false;
			}
		} else if (side == 5) {
			if (blackTurn == false) {

				history.setText(getHistoryWithoutHTMLTag(history.getText()) + "<br><br>" + "0-0" + " " + "</html>");

				blackTurn = true;
			} else {
				history.setText(getHistoryWithoutHTMLTag(history.getText()) + "0-0" + " " + "</html>");
				blackTurn = false;
			}
		} else {
			System.out.println("error!");
		}

	}
	
	public void check(){
		history.setText(getHistoryWithoutHTMLTagOrSpace(history.getText()) + "+ " + "</html>");
	}
	
	public void checkmate(){
		history.setText(getHistoryWithoutHTMLTagOrSpace(history.getText()) + "++ " + "</html>");
	}
	
	private String getHistoryWithoutHTMLTagOrSpace(String fullText) {

		return fullText.substring(0, fullText.length() - 8);

	}
}

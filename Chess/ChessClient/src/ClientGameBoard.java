import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ClientGameBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage bgImage;
	private static ArrayList<ArrayList<ClientSpace>> spaces;
	private JPanel grid = new JPanel();
	private boolean possibleMovesShown = false;
	private ClientSpace selectedSpace;
	private static PrintWriter messageOut;
	private String playerColor;
	private boolean isCurrentPlayer;
	private StalemateChecker stalemateChecker = new StalemateChecker();
	private GameHistoryPanel gameHistoryPanel;
	private String[] promotionOptions = { "Queen", "Rook", "Bishop", "Knight" };
	private WaitingImage waitingImage;

	public ClientGameBoard(PrintWriter messageOut2, GameHistoryPanel gc) {
		setLayout(new BorderLayout());

		messageOut = messageOut2;
		gameHistoryPanel = gc;

		grid.setLayout(new GridLayout(8, 8, 0, 0));
		grid.setPreferredSize(new Dimension(400, 400));

		try {
			bgImage = ImageIO.read(new File("images\\chessBoard.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bgImage, 0, 0, null);

	}

	public void displayWaitingImage() throws IOException {
		waitingImage = new WaitingImage();
		waitingImage.displayWaitingImage();
		waitingImage.setLayout(new FlowLayout(FlowLayout.CENTER));
		waitingImage.setPreferredSize(new Dimension(300, 100));
		this.add(waitingImage);
	}

	public void showPossibleMoves(ClientSpace space) {

		if (space.getCurrentPieceId().equals("whitePawn") && playerColor.equals("white")) {

			if (space.getX() > 0) {
				if (spaces.get(space.getX() - 1).get(space.getY()).getCurrentPieceId() == null) {
					highlightSpace(spaces.get(space.getX() - 1).get(space.getY()), Color.GREEN);

					if (space.getX() == 6) {
						if (spaces.get(space.getX() - 2).get(space.getY()).getCurrentPieceId() == null) {
							highlightSpace(spaces.get(space.getX() - 2).get(space.getY()), Color.GREEN);
						}
					}

				}

				if (space.getY() > 0) {
					if (spaces.get(space.getX() - 1).get(space.getY() - 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getX() - 1).get(space.getY() - 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 1), Color.RED);
						}
					}
				}

				if (space.getY() < 7) {
					if (spaces.get(space.getX() - 1).get(space.getY() + 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getX() - 1).get(space.getY() + 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 1), Color.RED);

						}
					}
				}
			}

		} else if (space.getCurrentPieceId().equals("blackPawn") && playerColor.equals("black")) {
			if (space.getX() < 7) {
				if (spaces.get(space.getX() + 1).get(space.getY()).getCurrentPieceId() == null) {
					highlightSpace(spaces.get(space.getX() + 1).get(space.getY()), Color.GREEN);

					if (space.getX() == 1) {
						if (spaces.get(space.getX() + 2).get(space.getY()).getCurrentPieceId() == null) {
							highlightSpace(spaces.get(space.getX() + 2).get(space.getY()), Color.GREEN);

						}
					}

				}

				if (space.getY() > 0) {
					if (spaces.get(space.getX() + 1).get(space.getY() - 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getX() + 1).get(space.getY() - 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 1), Color.RED);

						}
					}
				}

				if (space.getY() < 7) {
					if (spaces.get(space.getX() + 1).get(space.getY() + 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getX() + 1).get(space.getY() + 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 1), Color.RED);

						}
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteRook") || space.getCurrentPieceId().equals("blackRook")) {
			for (int x = space.getX() + 1; x <= 7; x++) {
				if (spaces.get(x).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);

						}
					} else if (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(x).get(space.getY()), Color.GREEN);

					}

				}
			}

			for (int x = space.getX() - 1; x >= 0; x--) {
				if (spaces.get(x).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(x).get(space.getY()), Color.GREEN);

					}
				}
			}

			for (int y = space.getY() + 1; y <= 7; y++) {
				if (spaces.get(space.getX()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(y), Color.GREEN);

					}
				}
			}

			for (int y = space.getY() - 1; y >= 0; y--) {
				if (spaces.get(space.getX()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					}
					break;
				} else {
					spaces.get(space.getX()).get(y).setOpaque(true);
					if ((space.getCurrentPieceId().equals("whiteRook") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackRook") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(y), Color.GREEN);

					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteKnight") || space.getCurrentPieceId().equals("blackKnight")) {
			if (space.getX() + 2 <= 7 && space.getY() + 1 <= 7) {
				if (spaces.get(space.getX() + 2).get(space.getY() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() + 2).get(space.getY() + 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() + 2).get(space.getY() + 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() + 2).get(space.getY() + 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 2).get(space.getY() + 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() + 2).get(space.getY() + 1), Color.GREEN);
					}

				}
			}

			if (space.getX() + 2 <= 7 && space.getY() - 1 >= 0) {
				if (spaces.get(space.getX() + 2).get(space.getY() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() + 2).get(space.getY() - 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() + 2).get(space.getY() - 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() + 2).get(space.getY() - 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 2).get(space.getY() - 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() + 2).get(space.getY() - 1), Color.GREEN);
					}
				}
			}

			if (space.getX() + 1 <= 7 && space.getY() + 2 <= 7) {
				if (spaces.get(space.getX() + 1).get(space.getY() + 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() + 1).get(space.getY() + 2).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 2), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() + 1).get(space.getY() + 2).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 2), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 2), Color.GREEN);
					}
				}
			}

			if (space.getX() + 1 <= 7 && space.getY() - 2 >= 0) {
				if (spaces.get(space.getX() + 1).get(space.getY() - 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() + 1).get(space.getY() - 2).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 2), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() + 1).get(space.getY() - 2).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 2), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 2), Color.GREEN);
					}
				}
			}

			if (space.getX() - 2 >= 0 && space.getY() - 1 >= 0) {
				if (spaces.get(space.getX() - 2).get(space.getY() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() - 2).get(space.getY() - 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 2).get(space.getY() - 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() - 2).get(space.getY() - 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() - 2).get(space.getY() - 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() - 2).get(space.getY() - 1), Color.GREEN);
					}
				}
			}

			if (space.getX() - 2 >= 0 && space.getY() + 1 <= 7) {
				if (spaces.get(space.getX() - 2).get(space.getY() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() - 2).get(space.getY() + 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 2).get(space.getY() + 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() - 2).get(space.getY() + 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() - 2).get(space.getY() + 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() - 2).get(space.getY() + 1), Color.GREEN);
					}
				}
			}

			if (space.getX() - 1 >= 0 && space.getY() - 2 >= 0) {
				if (spaces.get(space.getX() - 1).get(space.getY() - 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() - 1).get(space.getY() - 2).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 2), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() - 1).get(space.getY() - 2).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 2), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 2), Color.GREEN);
					}
				}
			}

			if (space.getX() - 1 >= 0 && space.getY() + 2 <= 7) {
				if (spaces.get(space.getX() - 1).get(space.getY() + 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white")) {
						if (spaces.get(space.getX() - 1).get(space.getY() + 2).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 2), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black")) {
						if (spaces.get(space.getX() - 1).get(space.getY() + 2).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 2), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKnight") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 2), Color.GREEN);
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteBishop") || space.getCurrentPieceId().equals("blackBishop")) {
			int tempX, tempY;

			tempY = space.getY() + 1;
			for (int x = space.getX() + 1; x <= 7; x++) {
				if (tempY <= 7) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(x).get(tempY), Color.GREEN);

						}
					}
				}
				tempY++;
			}

			tempY = space.getY() - 1;
			for (int x = space.getX() + 1; x <= 7; x++) {
				if (tempY >= 0) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(x).get(tempY), Color.GREEN);

						}
					}
				}
				tempY--;

			}

			tempX = space.getX() - 1;
			for (int y = space.getY() - 1; y >= 0; y--) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(tempX).get(y), Color.GREEN);
						}
					}
				}
				tempX--;

			}

			tempX = space.getX() - 1;
			for (int y = space.getY() + 1; y <= 7; y++) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteBishop") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackBishop") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(tempX).get(y), Color.GREEN);

						}
					}
				}
				tempX--;

			}
		} else if (space.getCurrentPieceId().equals("whiteQueen") || space.getCurrentPieceId().equals("blackQueen")) {
			int tempX, tempY;

			tempY = space.getY() + 1;
			for (int x = space.getX() + 1; x <= 7; x++) {
				if (tempY <= 7) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(x).get(tempY), Color.GREEN);

						}
					}
				}
				tempY++;
			}

			tempY = space.getY() - 1;
			for (int x = space.getX() + 1; x <= 7; x++) {
				if (tempY >= 0) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								highlightSpace(spaces.get(x).get(tempY), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(x).get(tempY), Color.GREEN);
						}
					}
				}
				tempY--;

			}

			tempX = space.getX() - 1;
			for (int y = space.getY() - 1; y >= 0; y--) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(tempX).get(y), Color.GREEN);

						}
					}
				}
				tempX--;

			}

			tempX = space.getX() - 1;
			for (int y = space.getY() + 1; y <= 7; y++) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								highlightSpace(spaces.get(tempX).get(y), Color.RED);
							}
						}
						break;
					} else {
						if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(tempX).get(y), Color.GREEN);

						}
					}
				}
				tempX--;

			}

			for (int x = space.getX() + 1; x <= 7; x++) {
				if (spaces.get(x).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(x).get(space.getY()), Color.GREEN);

					}
				}
			}

			for (int x = space.getX() - 1; x >= 0; x--) {
				if (spaces.get(x).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
						if (spaces.get(x).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(x).get(space.getY()), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(x).get(space.getY()), Color.GREEN);

					}
				}
			}

			for (int y = space.getY() + 1; y <= 7; y++) {
				if (spaces.get(space.getX()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(y), Color.GREEN);

					}
				}
			}

			for (int y = space.getY() - 1; y >= 0; y--) {
				if (spaces.get(space.getX()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(y).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(y), Color.RED);
						}
					}
					break;
				} else {
					if ((space.getCurrentPieceId().equals("whiteQueen") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackQueen") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(y), Color.GREEN);

					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteKing") || space.getCurrentPieceId().equals("blackKing")) {

			if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
				if (space.getX() == 7 && space.getY() == 4) {
					checkForCastleWhite();
				}
			} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
				if (space.getX() == 0 && space.getY() == 4) {
					checkForCastleBlack();
				}
			}

			if (space.getX() > 0) {
				if (spaces.get(space.getX() - 1).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
						if (spaces.get(space.getX() - 1).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY()), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
						if (spaces.get(space.getX() - 1).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY()), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() - 1).get(space.getY()), Color.GREEN);

					}
				}

				if (space.getY() > 0) {
					if (spaces.get(space.getX() - 1).get(space.getY() - 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
							if (spaces.get(space.getX() - 1).get(space.getY() - 1).getPlayer() == "black") {
								highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 1), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
							if (spaces.get(space.getX() - 1).get(space.getY() - 1).getPlayer() == "white") {
								highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 1), Color.RED);
							}
						}
					} else {
						if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() - 1), Color.GREEN);

						}
					}
				}

				if (space.getY() < 7) {
					if (spaces.get(space.getX() - 1).get(space.getY() + 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
							if (spaces.get(space.getX() - 1).get(space.getY() + 1).getPlayer() == "black") {
								highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 1), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
							if (spaces.get(space.getX() - 1).get(space.getY() + 1).getPlayer() == "white") {
								highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 1), Color.RED);
							}
						}
					} else {
						if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(space.getX() - 1).get(space.getY() + 1), Color.GREEN);

						}
					}
				}
			}

			if (space.getX() < 7) {
				if (spaces.get(space.getX() + 1).get(space.getY()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
						if (spaces.get(space.getX() + 1).get(space.getY()).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY()), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
						if (spaces.get(space.getX() + 1).get(space.getY()).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY()), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX() + 1).get(space.getY()), Color.GREEN);

					}
				}

				if (space.getY() > 0) {
					if (spaces.get(space.getX() + 1).get(space.getY() - 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
							if (spaces.get(space.getX() + 1).get(space.getY() - 1).getPlayer() == "black") {
								highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 1), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
							if (spaces.get(space.getX() + 1).get(space.getY() - 1).getPlayer() == "white") {
								highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 1), Color.RED);
							}
						}
					} else {
						if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() - 1), Color.GREEN);

						}
					}
				}

				if (space.getY() < 7) {
					if (spaces.get(space.getX() + 1).get(space.getY() + 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
							if (spaces.get(space.getX() + 1).get(space.getY() + 1).getPlayer() == "black") {
								highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 1), Color.RED);
							}
						} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
							if (spaces.get(space.getX() + 1).get(space.getY() + 1).getPlayer() == "white") {
								highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 1), Color.RED);
							}
						}
					} else {
						if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
								|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
							highlightSpace(spaces.get(space.getX() + 1).get(space.getY() + 1), Color.GREEN);

						}
					}
				}
			}

			if (space.getY() > 0) {
				if (spaces.get(space.getX()).get(space.getY() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(space.getY() - 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(space.getY() - 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(space.getY() - 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(space.getY() - 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(space.getY() - 1), Color.GREEN);

					}
				}
			}

			if (space.getY() < 7) {
				if (spaces.get(space.getX()).get(space.getY() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white")) {
						if (spaces.get(space.getX()).get(space.getY() + 1).getPlayer() == "black") {
							highlightSpace(spaces.get(space.getX()).get(space.getY() + 1), Color.RED);
						}
					} else if (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black")) {
						if (spaces.get(space.getX()).get(space.getY() + 1).getPlayer() == "white") {
							highlightSpace(spaces.get(space.getX()).get(space.getY() + 1), Color.RED);
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKing") && playerColor.equals("white"))
							|| (space.getCurrentPieceId().equals("blackKing") && playerColor.equals("black"))) {
						highlightSpace(spaces.get(space.getX()).get(space.getY() + 1), Color.GREEN);

					}
				}
			}

		}
	}

	private void highlightSpace(ClientSpace clientSpace, Color color) {
		clientSpace.setOpaque(true);
		clientSpace.setBackground(color);
		clientSpace.toggleHighlighted();
		
	}

	public void removePossibleMoves() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (spaces.get(i).get(j).getHighlighted() == true) {
					spaces.get(i).get(j).setOpaque(false);
					spaces.get(i).get(j).setBackground(Color.BLACK);
					spaces.get(i).get(j).toggleHighlighted();
				}
			}
		}

	}

	public void checkForCastleWhite() {

		if (spaces.get(7).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(7).get(7).getOriginalPieceHasMoved() == false) {
			if (spaces.get(7).get(5).getCurrentPieceId() == null && spaces.get(7).get(6).getCurrentPieceId() == null) {
				spaces.get(7).get(6).setOpaque(true);
				spaces.get(7).get(6).setBackground(Color.YELLOW);
				spaces.get(7).get(6).toggleHighlighted();
				spaces.get(7).get(6).setCastleMove(true);

			}
		}

		if (spaces.get(7).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(7).get(0).getOriginalPieceHasMoved() == false) {
			if (spaces.get(7).get(3).getCurrentPieceId() == null && spaces.get(7).get(2).getCurrentPieceId() == null
					&& spaces.get(7).get(1).getCurrentPieceId() == null) {
				spaces.get(7).get(2).setOpaque(true);
				spaces.get(7).get(2).setBackground(Color.YELLOW);
				spaces.get(7).get(2).toggleHighlighted();
				spaces.get(7).get(2).setCastleMove(true);
			}
		}

	}

	public void checkForCastleBlack() {

		if (spaces.get(0).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(0).get(7).getOriginalPieceHasMoved() == false) {
			if (spaces.get(0).get(5).getCurrentPieceId() == null && spaces.get(0).get(6).getCurrentPieceId() == null) {
				spaces.get(0).get(6).setOpaque(true);
				spaces.get(0).get(6).setBackground(Color.YELLOW);
				spaces.get(0).get(6).toggleHighlighted();
				spaces.get(0).get(6).setCastleMove(true);
			}
		}

		if (spaces.get(0).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(0).get(0).getOriginalPieceHasMoved() == false) {
			if (spaces.get(0).get(3).getCurrentPieceId() == null && spaces.get(0).get(2).getCurrentPieceId() == null
					&& spaces.get(0).get(1).getCurrentPieceId() == null) {
				spaces.get(0).get(2).setOpaque(true);
				spaces.get(0).get(2).setBackground(Color.YELLOW);
				spaces.get(0).get(2).toggleHighlighted();
				spaces.get(0).get(2).setCastleMove(true);
			}
		}

	}

	public void movePiece(ClientSpace newSpace, ClientSpace oldSpace) {

		newSpace.setPiece(oldSpace.getCurrentPiece(), oldSpace);
		oldSpace.removePiece();

	}

	public void moveSpace(int coord0, int coord1, int coord2, int coord3) {
		spaces.get(coord0).get(coord1).setPiece(spaces.get(coord2).get(coord3).getCurrentPiece(),
				spaces.get(coord2).get(coord3));
		spaces.get(coord2).get(coord3).removePiece();
	}


	public void setPieces() {

		this.remove(waitingImage);

		playerColor = "white";

		isCurrentPlayer = true;

		spaces = new ArrayList<ArrayList<ClientSpace>>();

		ArrayList<ClientSpace> rows;
		for (int i = 0; i < 8; i++) {

			rows = new ArrayList<ClientSpace>();

			for (int j = 0; j < 8; j++) {
				ClientSpace s = new ClientSpace(i, j);
				s.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (isCurrentPlayer == true) {
							if (possibleMovesShown == false) {
								if (s.getCurrentPieceId() != null) {
									selectedSpace = s;
									showPossibleMoves(s);
									possibleMovesShown = true;
								}
							} else {

								if (s.getHighlighted() == true) {

									if (s.isCastleMove() == true) {

										if (s.getX() == 7 && s.getY() == 6) {
											movePiece(spaces.get(7).get(5), spaces.get(7).get(7));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(5);
										} else if (s.getX() == 7 && s.getY() == 2) {
											movePiece(spaces.get(7).get(3), spaces.get(7).get(0));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(3);
										} else if (s.getX() == 0 && s.getY() == 6) {
											movePiece(spaces.get(0).get(5), spaces.get(0).get(7));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(5);
										} else if (s.getX() == 0 && s.getY() == 2) {
											movePiece(spaces.get(0).get(3), spaces.get(0).get(0));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(3);
										} else {
											System.out.println("ERROR!");
										}
									}

									ClientSpace tempSpace = new ClientSpace(s.getX(), s.getY());
									tempSpace.setCurrentPiece(s.getCurrentPiece());
									tempSpace.setCurrentPieceId(s.getCurrentPieceId());
									tempSpace.setPlayer(s.getPlayer());
									String capturedSpaceId = s.getCurrentPieceId();
									movePiece(s, selectedSpace);

									if (checkForCurrentPlayerCheck(s.getPlayer()) == true) {

										JOptionPane.showMessageDialog(null, "You can't put yourself in check!");
										movePiece(selectedSpace, s);
										movePiece(s, tempSpace);
										return;
									} else {

										selectedSpace.setOriginalPieceHasMoved(true);
										s.setOriginalPieceHasMoved(true);

									}

									if (s.isCastleMove() == false) {
										messageOut.println("move " + s.getX() + " " + s.getY() + " "
												+ selectedSpace.getX() + " " + selectedSpace.getY());
										if (capturedSpaceId == null) {

											gameHistoryPanel.newMove(s.getCurrentPieceId(), s.getX(), s.getY(),
													selectedSpace.getX(), selectedSpace.getY(), false);

										} else {
											gameHistoryPanel.newMove(s.getCurrentPieceId(), s.getX(), s.getY(),
													selectedSpace.getX(), selectedSpace.getY(), true);

										}

									} else {
										messageOut.println("castle " + s.getX() + " " + s.getY());
									}

									if (s.getCurrentPieceId().equals("whitePawn") && s.getX() == 0) {
										Object chosenPiece = JOptionPane.showInputDialog(null, "Select a new piece!",
												"Selection", JOptionPane.DEFAULT_OPTION, null, promotionOptions, "0");
										String chosenPieceString;
										if (chosenPiece != null) {
											chosenPieceString = chosenPiece.toString();
										} else {
											chosenPieceString = "Queen";
										}
										messageOut.println("promotion " + s.getX() + " " + s.getY() + " white"
												+ chosenPieceString);
										s.promote("white" + chosenPieceString, s.getPlayer());

									} else if (s.getCurrentPieceId().equals("blackPawn") && s.getX() == 7) {
										Object chosenPiece = JOptionPane.showInputDialog(null, "Select a new piece!",
												"Selection", JOptionPane.DEFAULT_OPTION, null, promotionOptions, "0");
										String chosenPieceString;
										if (chosenPiece != null) {
											chosenPieceString = chosenPiece.toString();
										} else {
											chosenPieceString = "Queen";
										}
										messageOut.println("promotion " + s.getX() + " " + s.getY() + " black"
												+ chosenPieceString);
										s.promote("black" + chosenPieceString, s.getPlayer());

									}

									if (checkForOpponentCheck(s.getPlayer()) == true) {
										if (checkForCheckmate(s.getPlayer()) == true) {
											JOptionPane.showMessageDialog(null, "Checkmate! You win!");
											messageOut.println("checkmate");
											gameHistoryPanel.checkmate();
										} else {
											gameHistoryPanel.check();
											messageOut.println("checkOnly ");
										}

									} else {
										if (checkForStalemate(s.getPlayer()) == true) {
											JOptionPane.showMessageDialog(null, "Stalemate.");
											messageOut.println("stalemate");
										}
									}

									isCurrentPlayer = false;
								}
								removePossibleMoves();
								possibleMovesShown = false;

							}
						}

					}

					@Override
					public void mouseReleased(MouseEvent me) {

					}
				});
				rows.add(s);
			}
			spaces.add(rows);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid.add(spaces.get(i).get(j));
			}
		}
		
		grid.setOpaque(false);
		this.add(grid);
		this.validate();
	}

	public void invertBoard() {

		this.remove(waitingImage);

		playerColor = "black";

		grid.removeAll();
		grid.invalidate();
		this.remove(grid);

		grid = new JPanel();
		grid.setLayout(new GridLayout(8, 8, 0, 0));
		grid.setPreferredSize(new Dimension(400, 400));

		spaces = new ArrayList<ArrayList<ClientSpace>>();

		ArrayList<ClientSpace> rows;

		for (int i = 0; i < 8; i++) {

			rows = new ArrayList<ClientSpace>();

			for (int j = 0; j < 8; j++) {
				ClientSpace s = new ClientSpace(i, j);

				s.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (isCurrentPlayer == true) {
							if (possibleMovesShown == false) {
								if (s.getCurrentPieceId() != null) {
									selectedSpace = s;
									showPossibleMoves(s);
									possibleMovesShown = true;
								}
							} else {

								if (s.getHighlighted() == true) {

									if (s.isCastleMove() == true) {

										if (s.getX() == 7 && s.getY() == 6) {
											movePiece(spaces.get(7).get(5), spaces.get(7).get(7));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(5);
										} else if (s.getX() == 7 && s.getY() == 2) {
											movePiece(spaces.get(7).get(3), spaces.get(7).get(0));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(3);
										} else if (s.getX() == 0 && s.getY() == 6) {
											movePiece(spaces.get(0).get(5), spaces.get(0).get(7));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(5);
										} else if (s.getX() == 0 && s.getY() == 2) {
											movePiece(spaces.get(0).get(3), spaces.get(0).get(0));
											spaces.get(7).get(7).setOriginalPieceHasMoved(true);
											gameHistoryPanel.castle(3);
										} else {
											System.out.println("ERROR!");
										}
									}

									ClientSpace tempSpace = new ClientSpace(s.getX(), s.getY());
									tempSpace.setCurrentPiece(s.getCurrentPiece());
									tempSpace.setCurrentPieceId(s.getCurrentPieceId());
									tempSpace.setPlayer(s.getPlayer());
									String capturedSpaceId = s.getCurrentPieceId();
									movePiece(s, selectedSpace);

									if (checkForCurrentPlayerCheck(s.getPlayer()) == true) {
										JOptionPane.showMessageDialog(null, "You can't put yourself in check!");
										movePiece(selectedSpace, s);
										movePiece(s, tempSpace);
										return;
									} else {

										selectedSpace.setOriginalPieceHasMoved(true);
										s.setOriginalPieceHasMoved(true);

									}

									if (s.isCastleMove() == false) {
										messageOut.println("move " + s.getX() + " " + s.getY() + " "
												+ selectedSpace.getX() + " " + selectedSpace.getY());

										if (capturedSpaceId == null) {
											gameHistoryPanel.newMove(s.getCurrentPieceId(), s.getX(), s.getY(),
													selectedSpace.getX(), selectedSpace.getY(), false);

										} else {
											gameHistoryPanel.newMove(s.getCurrentPieceId(), s.getX(), s.getY(),
													selectedSpace.getX(), selectedSpace.getY(), true);

										}

									} else {
										messageOut.println("castle " + s.getX() + " " + s.getY());
									}

									if (s.getCurrentPieceId().equals("blackPawn") && s.getX() == 7) {
										Object chosenPiece = JOptionPane.showInputDialog(null, "Select a new piece!",
												"Selection", JOptionPane.DEFAULT_OPTION, null, promotionOptions, "0");
										String chosenPieceString;
										if (chosenPiece != null) {
											chosenPieceString = chosenPiece.toString();
										} else {
											chosenPieceString = "Queen";
										}
										messageOut.println("promotion " + s.getX() + " " + s.getY() + " black"
												+ chosenPieceString);
										s.promote("black" + chosenPieceString, s.getPlayer());

									} else if (s.getCurrentPieceId().equals("whitePawn") && s.getX() == 0) {
										Object chosenPiece = JOptionPane.showInputDialog(null, "Select a new piece!",
												"Selection", JOptionPane.DEFAULT_OPTION, null, promotionOptions, "0");
										String chosenPieceString;
										if (chosenPiece != null) {
											chosenPieceString = chosenPiece.toString();
										} else {
											chosenPieceString = "Queen";
										}
										messageOut.println("promotion " + s.getX() + " " + s.getY() + " white"
												+ chosenPieceString);
										s.promote("white" + chosenPieceString, s.getPlayer());

									}

									if (checkForOpponentCheck(s.getPlayer()) == true) {
										if (checkForCheckmate(s.getPlayer()) == true) {
											JOptionPane.showMessageDialog(null, "Checkmate! You win!");
											messageOut.println("checkmate");
											gameHistoryPanel.checkmate();
										} else {
											gameHistoryPanel.check();
											messageOut.println("checkOnly ");
										}

									} else {
										if (checkForStalemate(s.getPlayer()) == true) {
											JOptionPane.showMessageDialog(null, "Stalemate.");
											messageOut.println("stalemate");
										}
									}

									isCurrentPlayer = false;
								}

								removePossibleMoves();
								possibleMovesShown = false;

							}
						}

					}

					@Override
					public void mouseReleased(MouseEvent me) {

					}
				});
				rows.add(s);
			}
			spaces.add(rows);
		}

		for (int i = 7; i >= 0; i--) {
			for (int j = 7; j >= 0; j--) {
				grid.add(spaces.get(i).get(j));
			}
		}
		
		grid.setOpaque(false);
		this.add(grid);
		this.validate();

	}

	public boolean checkForCurrentPlayerCheck(String currentPlayerColor) {

		ClientSpace kingPosition;

		if (currentPlayerColor.equals("white")) {
			kingPosition = findKingPosition("black");
		} else {
			kingPosition = findKingPosition("white");
		}

		if (currentPlayerColor.equals("white")) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getPlayer() == "black") {
						if (spaces.get(i).get(j).getCurrentPieceId() == "blackPawn") {

							if (j > 0) {
								if (spaces.get(i + 1).get(j - 1) == kingPosition) {
									return true;
								}
							}

							if (j < 7) {
								if (spaces.get(i + 1).get(j + 1) == kingPosition) {
									return true;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackRook") {
							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackKnight") {
							if (i + 2 <= 7 && j + 1 <= 7) {
								if (spaces.get(i + 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 2 <= 7 && j - 1 >= 0) {
								if (spaces.get(i + 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j + 2 <= 7) {
								if (spaces.get(i + 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j - 2 >= 0) {
								if (spaces.get(i + 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j - 1 >= 0) {
								if (spaces.get(i - 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j + 1 <= 7) {
								if (spaces.get(i - 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j - 2 >= 0) {
								if (spaces.get(i - 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j + 2 <= 7) {
								if (spaces.get(i - 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackBishop") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackQueen") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackKing") {

							if (i > 0) {
								if (spaces.get(i - 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 1) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i - 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i - 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (i < 7) {
								if (spaces.get(i + 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i + 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i + 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (j > 0) {
								if (spaces.get(i).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (j < 7) {
								if (spaces.get(i).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		} else if (currentPlayerColor.equals("black")) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getPlayer() == "white") {
						if (spaces.get(i).get(j).getCurrentPieceId() == "whitePawn") {

							if (j > 0) {
								if (spaces.get(i + 1).get(j - 1) == kingPosition) {
									return true;
								}
							}

							if (j < 7) {
								if (spaces.get(i + 1).get(j + 1) == kingPosition) {
									return true;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteRook") {
							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKnight") {
							if (i + 2 <= 7 && j + 1 <= 7) {
								if (spaces.get(i + 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 2 <= 7 && j - 1 >= 0) {
								if (spaces.get(i + 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j + 2 <= 7) {
								if (spaces.get(i + 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j - 2 >= 0) {
								if (spaces.get(i + 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j - 1 >= 0) {
								if (spaces.get(i - 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j + 1 <= 7) {
								if (spaces.get(i - 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j - 2 >= 0) {
								if (spaces.get(i - 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j + 2 <= 7) {
								if (spaces.get(i - 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteBishop") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteQueen") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKing") {

							if (i > 0) {
								if (spaces.get(i - 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 1) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i - 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i - 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (i < 7) {
								if (spaces.get(i + 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i + 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i + 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (j > 0) {
								if (spaces.get(i).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (j < 7) {
								if (spaces.get(i).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	public boolean checkForOpponentCheck(String currentPlayerColor) {

		ClientSpace kingPosition = findKingPosition(currentPlayerColor);

		if (currentPlayerColor.equals("white")) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getPlayer() == "white") {
						if (spaces.get(i).get(j).getCurrentPieceId() == "whitePawn") {

							if (j > 0) {
								if (spaces.get(i + 1).get(j - 1) == kingPosition) {
									return true;
								}
							}

							if (j < 7) {
								if (spaces.get(i + 1).get(j + 1) == kingPosition) {
									return true;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteRook") {
							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKnight") {
							if (i + 2 <= 7 && j + 1 <= 7) {
								if (spaces.get(i + 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 2 <= 7 && j - 1 >= 0) {
								if (spaces.get(i + 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j + 2 <= 7) {
								if (spaces.get(i + 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j - 2 >= 0) {
								if (spaces.get(i + 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j - 1 >= 0) {
								if (spaces.get(i - 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j + 1 <= 7) {
								if (spaces.get(i - 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j - 2 >= 0) {
								if (spaces.get(i - 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j + 2 <= 7) {
								if (spaces.get(i - 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteBishop") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteQueen") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKing") {

							if (i > 0) {
								if (spaces.get(i - 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 1) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i - 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i - 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (i < 7) {
								if (spaces.get(i + 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i + 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i + 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (j > 0) {
								if (spaces.get(i).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (j < 7) {
								if (spaces.get(i).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		} else if (currentPlayerColor.equals("black")) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getPlayer() == "black") {
						if (spaces.get(i).get(j).getCurrentPieceId() == "blackPawn") {

							if (j > 0) {
								if (spaces.get(i + 1).get(j - 1) == kingPosition) {
									return true;
								}
							}

							if (j < 7) {
								if (spaces.get(i + 1).get(j + 1) == kingPosition) {
									return true;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackRook") {
							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackKnight") {
							if (i + 2 <= 7 && j + 1 <= 7) {
								if (spaces.get(i + 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 2 <= 7 && j - 1 >= 0) {
								if (spaces.get(i + 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i + 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j + 2 <= 7) {
								if (spaces.get(i + 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i + 1 <= 7 && j - 2 >= 0) {
								if (spaces.get(i + 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j - 1 >= 0) {
								if (spaces.get(i - 2).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 2 >= 0 && j + 1 <= 7) {
								if (spaces.get(i - 2).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i - 2).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j - 2 >= 0) {
								if (spaces.get(i - 1).get(j - 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 2) == kingPosition) {
										return true;
									}
								}
							}

							if (i - 1 >= 0 && j + 2 <= 7) {
								if (spaces.get(i - 1).get(j + 2).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j + 2) == kingPosition) {
										return true;
									}
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackBishop") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackQueen") {
							int tempX, tempY;

							tempY = j + 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY <= 7) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY++;
							}

							tempY = j - 1;
							for (int x = i + 1; x <= 7; x++) {
								if (tempY >= 0) {
									if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
										if (spaces.get(x).get(tempY) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempY--;

							}

							tempX = i - 1;
							for (int y = j - 1; y >= 0; y--) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							tempX = i - 1;
							for (int y = j + 1; y <= 7; y++) {
								if (tempX >= 0) {
									if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
										if (spaces.get(tempX).get(y) == kingPosition) {
											return true;
										}
										break;
									}
								}
								tempX--;

							}

							for (int x = i + 1; x <= 7; x++) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int x = i - 1; x >= 0; x--) {
								if (spaces.get(x).get(j).getCurrentPieceId() != null) {
									if (spaces.get(x).get(j) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j + 1; y <= 7; y++) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}

							for (int y = j - 1; y >= 0; y--) {
								if (spaces.get(i).get(y).getCurrentPieceId() != null) {
									if (spaces.get(i).get(y) == kingPosition) {
										return true;
									}
									break;
								}
							}
						} else if (spaces.get(i).get(j).getCurrentPieceId() == "blackKing") {

							if (i > 0) {
								if (spaces.get(i - 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i - 1).get(j - 1) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i - 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i - 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i - 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (i < 7) {
								if (spaces.get(i + 1).get(j).getCurrentPieceId() != null) {
									if (spaces.get(i + 1).get(j) == kingPosition) {
										return true;
									}
								}

								if (j > 0) {
									if (spaces.get(i + 1).get(j - 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j - 1) == kingPosition) {
											return true;
										}
									}
								}

								if (j < 7) {
									if (spaces.get(i + 1).get(j + 1).getCurrentPieceId() != null) {
										if (spaces.get(i + 1).get(j + 1) == kingPosition) {
											return true;
										}
									}
								}
							}

							if (j > 0) {
								if (spaces.get(i).get(j - 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j - 1) == kingPosition) {
										return true;
									}
								}
							}

							if (j < 7) {
								if (spaces.get(i).get(j + 1).getCurrentPieceId() != null) {
									if (spaces.get(i).get(j + 1) == kingPosition) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	public boolean checkForCheckmate(String currentPlayerColor) {

		ClientSpace kingPosition = findKingPosition(currentPlayerColor);

		String opponentColor;
		if (currentPlayerColor.equals("white")) {
			opponentColor = "black";
		} else {
			opponentColor = "white";
		}

		boolean checkmate = true;
		for (int i = 0; i < 8; i++) {
			if (checkmate == false) {
				break;
			}
			for (int j = 0; j < 8; j++) {

				if (spaces.get(i).get(j).getPlayer() == opponentColor) {
					if (stalemateChecker.checkForStalemateForAllPossibleMoves(spaces, spaces.get(i).get(j),
							kingPosition, opponentColor) == false) {
						checkmate = false;
						break;
					}
				}
			}
		}

		return checkmate;

	}

	public boolean checkForStalemate(String currentPlayerColor) {
		ClientSpace kingPosition = null;
		String opponentColor = "";

		if (stalemateChecker.checkForInsufficientPieces(currentPlayerColor, spaces) == true) {
			return true;
		}

		kingPosition = findKingPosition(currentPlayerColor);

		if (currentPlayerColor.equals("white")) {
			opponentColor = "black";
		} else {
			opponentColor = "white";
		}

		boolean stalemate = true;
		for (int i = 0; i < 8; i++) {
			if (stalemate == false) {
				break;
			}
			for (int j = 0; j < 8; j++) {

				if (spaces.get(i).get(j).getPlayer() == opponentColor) {
					if (stalemateChecker.checkForStalemateForAllPossibleMoves(spaces, spaces.get(i).get(j),
							kingPosition, opponentColor) == false) {
						stalemate = false;
						break;
					}
				}
			}
		}

		return stalemate;

	}

	private ClientSpace findKingPosition(String currentPlayerColor) {
		if (currentPlayerColor.equals("white")) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getCurrentPieceId() == "blackKing") {
						return spaces.get(i).get(j);
					}
				}
			}
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKing") {
						return spaces.get(i).get(j);
					}
				}
			}
		}
		return null;
	}

	public void setIsCurrentPlayer(boolean b) {
		isCurrentPlayer = b;

	}

	public ArrayList<ArrayList<ClientSpace>> getSpaces() {
		return spaces;
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ClientSpace extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;
	private Piece currentPiece;
	private String currentPieceId;
	private String player;
	private boolean originalPieceHasMoved;
	private boolean highlighted = false;
	private boolean castleMove;
	
	public ClientSpace(int horizontal, int vertical){
		setLayout(new BorderLayout());
		
		setOpaque(false);
		
		x = horizontal;
		y = vertical;
		originalPieceHasMoved = false;
		castleMove = false;
		
		if(x == 0 && y == 0){
			setInitialPiece("blackRook");
		}else if(x == 0 && y == 1){
			setInitialPiece("blackKnight");
		}else if(x == 0 && y == 2){
			setInitialPiece("blackBishop");
		}else if(x == 0 && y == 3){
			setInitialPiece("blackQueen");
		}else if(x == 0 && y == 4){
			setInitialPiece("blackKing");
		}else if(x == 0 && y == 5){
			setInitialPiece("blackBishop");
		}else if(x == 0 && y == 6){
			setInitialPiece("blackKnight");
		}else if(x == 0 && y == 7){
			setInitialPiece("blackRook");
		}else if(x == 1){
			setInitialPiece("blackPawn");
		}else if(x == 6){
			setInitialPiece("whitePawn");
		}else if(x == 7 && y == 0){
			setInitialPiece("whiteRook");
		}else if(x == 7 && y == 1){
			setInitialPiece("whiteKnight");
		}else if(x == 7 && y == 2){
			setInitialPiece("whiteBishop");
		}else if(x == 7 && y == 3){
			setInitialPiece("whiteQueen");
		}else if(x == 7 && y == 4){
			setInitialPiece("whiteKing");
		}else if(x == 7 && y == 5){
			setInitialPiece("whiteBishop");
		}else if(x == 7 && y == 6){
			setInitialPiece("whiteKnight");
		}else if(x == 7 && y == 7){
			setInitialPiece("whiteRook");
		}
		
	}
	
	public boolean getOriginalPieceHasMoved(){
		return originalPieceHasMoved;
	}
	
	public void setOriginalPieceHasMoved(boolean set){
		originalPieceHasMoved = set;
	}
	
	public void setPiece(Piece newPiece, ClientSpace oldSpace){
		
		oldSpace.setOriginalPieceHasMoved(true);
		originalPieceHasMoved = true;
		
		if(currentPiece != null){
			this.remove(currentPiece);
			this.validate();
		}
		
		currentPiece = oldSpace.getCurrentPiece();
		currentPieceId = oldSpace.getCurrentPieceId();
		player = oldSpace.getPlayer();
		this.add(currentPiece);
		this.revalidate();
		this.repaint();
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}
	
	public void promote(String pieceId, String color){
		this.remove(currentPiece);
		this.validate();
		currentPieceId = null;
		player = null;
		
		currentPiece = new Piece(pieceId + ".png");
		currentPieceId = pieceId;
		player = color;
		this.add(currentPiece);
		this.revalidate();
		this.repaint();
	}
	
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }

	public String getCurrentPieceId(){
		return currentPieceId;
	}
	
	public String getPlayer(){
		return player;
	}
	
	public void toggleHighlighted(){
		if(highlighted == true){
			highlighted = false;
		}else{
			highlighted = true;
		}
	}
	
	public boolean getHighlighted(){
		return highlighted;
	}
	
	public Piece getCurrentPiece(){
		return currentPiece;
	}
	
	public void setCurrentPiece(Piece piece){
		currentPiece = piece;
	}
	
	public void setPlayer(String color){
		player = color;
	}
	
	public void setCurrentPieceId(String id){
		currentPieceId = id;
	}
	
	public void removePiece(){
		this.remove(currentPiece);
		this.validate();
		currentPieceId = null;
		currentPiece = null;
		player = null;
		this.repaint();
		
	}

	public void setPieceWithoutPaint(Piece currentPiece2, ClientSpace oldSpace) {

		currentPieceId = oldSpace.getCurrentPieceId();
		player = oldSpace.getPlayer();
	}

	public void removePieceWithoutPaint() {
	
		currentPieceId = null;
		player = null;
		
		
	}
	
	public boolean isCastleMove(){
		return castleMove;
	}
	
	public void setCastleMove(boolean move){
		castleMove = move;
	}
	
	public int getXPosition(){
		return x;
	}
	
	public int getYPosition(){
		return y;
	}
	
	public void setInitialPiece(String pieceName){
		
		currentPiece = new Piece(pieceName + ".png");
		currentPieceId = pieceName;
		
		if(pieceName.startsWith("white")){
			player = "white";
		}else{
			player = "black";
		}
		
		this.add(currentPiece, BorderLayout.CENTER);
		
	}

}

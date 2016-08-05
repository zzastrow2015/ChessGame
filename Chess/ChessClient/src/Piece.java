import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Piece extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage pieceImage;

	public Piece(String pieceType){
		
		try {
			if(pieceType != null){
				pieceImage = ImageIO.read(new File("images\\" + pieceType));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setBackground(new Color(0,0,0,0));
	}
	
	public BufferedImage getImage(){
		return pieceImage;
	}
	
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(pieceImage, 0, 0, null);
		
	}
	
}

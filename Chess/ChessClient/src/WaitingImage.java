import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WaitingImage extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage waitingImage;

	public void displayWaitingImage() throws IOException{
		setOpaque(false);
		waitingImage = ImageIO.read(new File("images\\waiting.png"));
	}
	
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(waitingImage, 0, 0, null);
		
	}
}

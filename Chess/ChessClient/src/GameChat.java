import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.PrintWriter;

public class GameChat extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter messageOut;
	private JLabel chatBox;
	private JScrollPane chatBoxScrollPanel;
	private boolean scrollFlag = true;
	
	public GameChat(PrintWriter messageOut2){
		setLayout(new BorderLayout());
		
		messageOut = messageOut2;
		
		setSize(600, 200);
		chatBox = new JLabel();
		chatBox.setText("<html>Game Chat</html>");
		chatBox.setHorizontalAlignment(JLabel.LEFT);
		chatBox.setVerticalAlignment(JLabel.TOP);
		chatBox.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		chatBox.setSize(new Dimension(600, 180));
		chatBox.setBackground(Color.WHITE);
		chatBox.setOpaque(true);
		
		
		chatBoxScrollPanel = new JScrollPane(chatBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatBoxScrollPanel.setPreferredSize(new Dimension(600, 180));
		chatBoxScrollPanel.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				if (scrollFlag == true) {
					e.getAdjustable().setValue(e.getAdjustable().getMaximum());
					scrollFlag = false;
				}

			}
		});
		
		add(chatBoxScrollPanel, BorderLayout.NORTH);
		
		JTextField textInput = new JTextField();
		textInput.setText("");
		textInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				printAndSendMessage(textInput.getText());
				
			}
		});
		
		add(textInput, BorderLayout.SOUTH);
		
	}
	
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 200);
    }
    
    private void printAndSendMessage(String text) {
		
    	scrollFlag = true;
    	chatBox.setText(getHistoryWithoutHTMLTag(chatBox.getText()) + "<br><br>" + "<font color='green'>You: " + text + "</font></html>");
		messageOut.println("chat " + text);
	}
    
    public void recieveAndPrintMessage(String text){
    	
    	scrollFlag = true;
    	chatBox.setText(getHistoryWithoutHTMLTag(chatBox.getText()) + "<br><br>" + "<font color='red'>Opponent: " + text + "</font></html>");

    }
    
	private String getHistoryWithoutHTMLTag(String fullText) {

		return fullText.substring(0, fullText.length() - 7);

	}

}

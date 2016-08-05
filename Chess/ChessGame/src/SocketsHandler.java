import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketsHandler extends Thread{
	
	private Socket socket;
	private BufferedReader messageIn;
	private PrintWriter messageOut;
	private SocketsHandler opponent;
	private String color;
	
	
	String message = "";

	public SocketsHandler(Socket passedSocket, String playerColor){
		socket = passedSocket;
		System.out.println("Connection received. " + socket.getInetAddress().getHostName());
	
		color = playerColor;
	
	}
	
	public String getColor(){
		return color;
	}
	
	public void setOpponent(SocketsHandler theOpponent){
		opponent = theOpponent;
	}
	
	public SocketsHandler getOpponent(){
		return opponent;
	}
	
	public void run(){
		try {
			messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//messageIn2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			messageOut = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("running");
			messageOut.println("Color" + color);
			tellClientToInvertBoard();
			
			while(true){
				
				String move = messageIn.readLine();

				if(move.startsWith("move")){
					opponent.sendMessageOut(move);
				}else if(move.startsWith("castle")){
					opponent.sendMessageOut(move);
				}else if(move.equals("checkmate")){
					opponent.sendMessageOut("checkmate");
				}else if(move.startsWith("checkOnly")){
					opponent.sendMessageOut("checkOnly");
				}else if(move.startsWith("stalemate")){
					opponent.sendMessageOut(move);
				}else if(move.startsWith("promotion")){
					opponent.sendMessageOut(move);
				}else if(move.startsWith("concede")){
					opponent.sendMessageOut("concede");
					break;
				}else if(move.startsWith("draw")){
					opponent.sendMessageOut("draw");
				}else if(move.startsWith("accept")){
					opponent.sendMessageOut("accept");
				}else if(move.startsWith("decline")){
					opponent.sendMessageOut("decline");
				}else if(move.startsWith("chat")){
					opponent.sendMessageOut(move);
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			opponent.sendMessageOut("exit");
		}
	}
	
	public void sendMessageOut(String string){
		messageOut.println(string);
	}
	
	public void tellClientToInvertBoard() throws InterruptedException{
		
		if(this.getColor().equals("black")){
			messageOut.println("invert");
		}
		
	}
	
}

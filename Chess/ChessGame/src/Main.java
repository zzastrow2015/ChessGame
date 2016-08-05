import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socketServer = new ServerSocket(3456);
		System.out.println("server is running.");

		try {
			
			SocketsHandler whitePlayer = new SocketsHandler(socketServer.accept(), "white");
			SocketsHandler blackPlayer = new SocketsHandler(socketServer.accept(), "black");
			
			whitePlayer.setOpponent(blackPlayer);
			blackPlayer.setOpponent(whitePlayer);
			
			whitePlayer.start();
			blackPlayer.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			socketServer.close();
		}

	}

}

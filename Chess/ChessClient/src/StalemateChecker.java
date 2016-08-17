
import java.util.ArrayList;
import java.util.List;

public class StalemateChecker {
	
	public boolean checkForStalemateForAllPossibleMoves(ArrayList<ArrayList<ClientSpace>> spaces, ClientSpace space, ClientSpace kingPosition, String currentPlayerColor){
		if (space.getCurrentPieceId().equals("whitePawn")) {

			if (space.getXPosition() > 0) {
				if (spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPieceId() == null) {
					movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
						return false;
					}
					

					if (space.getXPosition() == 6) {
						if (spaces.get(space.getXPosition() - 2).get(space.getYPosition()).getCurrentPieceId() == null) {
							movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition()));
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition()));
								return false;
							}
						}
					}

				}

				if (space.getYPosition() > 0) {
					if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					}
				}

				if (space.getYPosition() < 7) {
					if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					}
				}
			}

		} else if (space.getCurrentPieceId().equals("blackPawn")) {
			if (space.getXPosition() < 6) {
				if (spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPieceId() == null) {
					movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
						return false;
					}

					if (space.getXPosition() == 1) {
						if (spaces.get(space.getXPosition() + 2).get(space.getYPosition()).getCurrentPieceId() == null) {
							movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition()));
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition()));
								return false;
							}
						}
					}

				}

				if (space.getYPosition() > 0) {
					if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					}
				}

				if (space.getYPosition() < 7) {
					if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteRook") || space.getCurrentPieceId().equals("blackRook")) {
			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (spaces.get(x).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackRook")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(x).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(x).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(x).get(space.getYPosition()));
						return false;
					}

				}
			}

			for (int x = space.getXPosition() - 1; x >= 0; x--) {
				if (spaces.get(x).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackRook")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(x).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(x).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(x).get(space.getYPosition()));
						return false;
					}
				}
			}

			for (int y = space.getYPosition() + 1; y <= 7; y++) {
				if (spaces.get(space.getXPosition()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackRook")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(space.getXPosition()).get(y), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(y));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(y));
						return false;
					}
				}
			}

			for (int y = space.getYPosition() - 1; y >= 0; y--) {
				if (spaces.get(space.getXPosition()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteRook")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackRook")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(space.getXPosition()).get(y), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(y));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(y));
						return false;
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteKnight") || space.getCurrentPieceId().equals("blackKnight")) {
			if (space.getXPosition() + 2 <= 7 && space.getYPosition() + 1 <= 7) {
				if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 2, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 2, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					if ((space.getCurrentPieceId().equals("whiteKnight"))
							|| (space.getCurrentPieceId().equals("blackKnight"))) {
						movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1), spaces.get(space.getXPosition()).get(space.getYPosition()));
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
						}else{
							movePiece(spaces.get(space.getXPosition()).get(space.getYPosition()), spaces.get(space.getXPosition() + 2).get(space.getYPosition() + 1));
							return false;
						}
					}

				}
			}

			if (space.getXPosition() + 2 <= 7 && space.getYPosition() - 1 >= 0) {
				if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 2, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 2, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() + 2).get(space.getYPosition() - 1));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() + 1 <= 7 && space.getYPosition() + 2 <= 7) {
				if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() + 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() + 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
						}else{
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 2));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() + 1 <= 7 && space.getYPosition() - 2 >= 0) {
				if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() - 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() - 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
						}else{
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 2));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() - 2 >= 0 && space.getYPosition() - 1 >= 0) {
				if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 2, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 2, space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() - 1));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() - 2 >= 0 && space.getYPosition() + 1 <= 7) {
				if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 2, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 2, space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 2).get(space.getYPosition() + 1));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() - 1 >= 0 && space.getYPosition() - 2 >= 0) {
				if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() - 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() - 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 2));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() - 1 >= 0 && space.getYPosition() + 2 <= 7) {
				if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKnight")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() + 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKnight")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() + 2);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), tempSpace);
								return false;
							}
						}
					}
				} else {
					if (space.getCurrentPieceId().equals("whiteKnight")
							|| space.getCurrentPieceId().equals("blackKnight")) {
						movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 2));
							return false;
						}
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteBishop") || space.getCurrentPieceId().equals("blackBishop")) {
			int tempX, tempY;

			tempY = space.getYPosition() + 1;
			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (tempY <= 7) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackBishop")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(x).get(tempY), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(x).get(tempY));
						}else{
							movePiece(space, spaces.get(x).get(tempY));
							return false;
						}
					}
				}
				tempY++;
			}

			tempY = space.getYPosition() - 1;
			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (tempY >= 0) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackBishop")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(x).get(tempY), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(x).get(tempY));
						}else{
							movePiece(space, spaces.get(x).get(tempY));
							return false;
						}
					}
				}
				tempY--;

			}

			tempX = space.getXPosition() - 1;
			for (int y = space.getYPosition() - 1; y >= 0; y--) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackBishop")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(tempX).get(y), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(tempX).get(y));
						}else{
							movePiece(space, spaces.get(tempX).get(y));
							return false;
						}
					}
				}
				tempX--;

			}

			tempX = space.getXPosition() - 1;
			for (int y = space.getYPosition() + 1; y <= 7; y++) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteBishop")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackBishop")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(tempX).get(y), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(tempX).get(y));
						}else{
							movePiece(space, spaces.get(tempX).get(y));
							return false;
						}
					}
				}
				tempX--;

			}
		} else if (space.getCurrentPieceId().equals("whiteQueen") || space.getCurrentPieceId().equals("blackQueen")) {
			int tempX, tempY;

			tempY = space.getYPosition() + 1;
			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (tempY <= 7) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackQueen")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(x).get(tempY), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(x).get(tempY));
						}else{
							movePiece(space, spaces.get(x).get(tempY));
							return false;
						}
					}
				}
				tempY++;
			}

			tempY = space.getYPosition() - 1;
			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (tempY >= 0) {
					if (spaces.get(x).get(tempY).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen")) {
							if (spaces.get(x).get(tempY).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackQueen")) {
							if (spaces.get(x).get(tempY).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(x, tempY);
								tempSpace.setCurrentPiece(spaces.get(x).get(tempY).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(x).get(tempY).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(x).get(tempY).getPlayer());
								movePiece(spaces.get(x).get(tempY), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
								}else{
									movePiece(space, spaces.get(x).get(tempY));
									movePiece(spaces.get(x).get(tempY), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(x).get(tempY), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(x).get(tempY));
						}else{
							movePiece(space, spaces.get(x).get(tempY));
							return false;
						}
					}
				}
				tempY--;

			}

			tempX = space.getXPosition() - 1;
			for (int y = space.getYPosition() - 1; y >= 0; y--) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackQueen")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(tempX).get(y), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(tempX).get(y));
						}else{
							movePiece(space, spaces.get(tempX).get(y));
							return false;
						}
					}
				}
				tempX--;

			}

			tempX = space.getXPosition() - 1;
			for (int y = space.getYPosition() + 1; y <= 7; y++) {
				if (tempX >= 0) {
					if (spaces.get(tempX).get(y).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteQueen")) {
							if (spaces.get(tempX).get(y).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackQueen")) {
							if (spaces.get(tempX).get(y).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(tempX, y);
								tempSpace.setCurrentPiece(spaces.get(tempX).get(y).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(tempX).get(y).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(tempX).get(y).getPlayer());
								movePiece(spaces.get(tempX).get(y), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
								}else{
									movePiece(space, spaces.get(tempX).get(y));
									movePiece(spaces.get(tempX).get(y), tempSpace);
									return false;
								}
							}
						}
						break;
					} else {
						movePiece(spaces.get(tempX).get(y), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(tempX).get(y));
						}else{
							movePiece(space, spaces.get(tempX).get(y));
							return false;
						}
					}
				}
				tempX--;

			}

			for (int x = space.getXPosition() + 1; x <= 7; x++) {
				if (spaces.get(x).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackQueen")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(x).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(x).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(x).get(space.getYPosition()));
						return false;
					}
				}
			}

			for (int x = space.getXPosition() - 1; x >= 0; x--) {
				if (spaces.get(x).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackQueen")) {
						if (spaces.get(x).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(x, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(x).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(x).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(x).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(x).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(x).get(space.getYPosition()));
								movePiece(spaces.get(x).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(x).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(x).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(x).get(space.getYPosition()));
						return false;
					}
				}
			}

			for (int y = space.getYPosition() + 1; y <= 7; y++) {
				if (spaces.get(space.getXPosition()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackQueen")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(space.getXPosition()).get(y), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(y));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(y));
						return false;
					}
				}
			}

			for (int y = space.getYPosition() - 1; y >= 0; y--) {
				if (spaces.get(space.getXPosition()).get(y).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteQueen")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackQueen")) {
						if (spaces.get(space.getXPosition()).get(y).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), y);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(y).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(y).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(y).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(y), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(y));
								movePiece(spaces.get(space.getXPosition()).get(y), tempSpace);
								return false;
							}
						}
					}
					break;
				} else {
					movePiece(spaces.get(space.getXPosition()).get(y), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(y));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(y));
						return false;
					}
				}
			}
		} else if (space.getCurrentPieceId().equals("whiteKing") || space.getCurrentPieceId().equals("blackKing")) {

			if (space.getCurrentPieceId().equals("whiteKing")) {
				if (space.getXPosition() == 7 && space.getYPosition() == 4) {
					checkForCastleWhite(spaces, currentPlayerColor);
				}
			} else if (space.getCurrentPieceId().equals("blackKing")) {
				if (space.getXPosition() == 0 && space.getYPosition() == 4) {
					checkForCastleBlack(spaces, currentPlayerColor);
				}
			}

			if (space.getXPosition() > 0) {
				if (spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKing")) {
						if (spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
				} else {
					movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition()));
						return false;
					}
				}

				if (space.getYPosition() > 0) {
					if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing")) {
							if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() - 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackKing")) {
							if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() - 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), tempSpace);
									return false;
								}
							}
						}
					} else {
						movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() - 1));
							return false;
						}
					}
				}

				if (space.getYPosition() < 7) {
					if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing")) {
							if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() + 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackKing")) {
							if (spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() - 1, space.getYPosition() + 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), tempSpace);
									return false;
								}
							}
						}
					} else {
						movePiece(spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() - 1).get(space.getYPosition() + 1));
							return false;
						}
					}
				}
			}

			if (space.getXPosition() < 7) {
				if (spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKing")) {
						if (spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition());
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition()).getPlayer());
							movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), tempSpace);
								return false;
							}
						}
					}
				} else {
					movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition()), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
					}else{
						movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition()));
						return false;
					}
				}

				if (space.getYPosition() > 0) {
					if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing")) {
							if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() - 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackKing")) {
							if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() - 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), tempSpace);
									return false;
								}
							}
						}
					} else {
						movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() - 1));
							return false;
						}
					}
				}

				if (space.getYPosition() < 7) {
					if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
						if (space.getCurrentPieceId().equals("whiteKing")) {
							if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer() == "black") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() + 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
									return false;
								}
							}
						} else if (space.getCurrentPieceId().equals("blackKing")) {
							if (spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer() == "white") {
								ClientSpace tempSpace = new ClientSpace(space.getXPosition() + 1, space.getYPosition() + 1);
								tempSpace.setCurrentPiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPiece());
								tempSpace.setCurrentPieceId(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getCurrentPieceId());
								tempSpace.setPlayer(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1).getPlayer());
								movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), space);
								if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
								}else{
									movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
									movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), tempSpace);
									return false;
								}
							}
						}
					} else {
						movePiece(spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1), space);
						if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
						}else{
							movePiece(space, spaces.get(space.getXPosition() + 1).get(space.getYPosition() + 1));
							return false;
						}
					}
				}
			}

			if (space.getYPosition() > 0) {
				if (spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing")) {
						if (spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKing")) {
						if (spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), space.getYPosition() - 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(space.getYPosition() - 1).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() - 1), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() - 1));
						return false;
					}
				}
			}

			if (space.getYPosition() < 7) {
				if (spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getCurrentPieceId() != null) {
					if (space.getCurrentPieceId().equals("whiteKing")) {
						if (spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getPlayer() == "black") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					} else if (space.getCurrentPieceId().equals("blackKing")) {
						if (spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getPlayer() == "white") {
							ClientSpace tempSpace = new ClientSpace(space.getXPosition(), space.getYPosition() + 1);
							tempSpace.setCurrentPiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getCurrentPiece());
							tempSpace.setCurrentPieceId(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getCurrentPieceId());
							tempSpace.setPlayer(spaces.get(space.getXPosition()).get(space.getYPosition() + 1).getPlayer());
							movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), space);
							if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), tempSpace);
							}else{
								movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
								movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), tempSpace);
								return false;
							}
						}
					}
				} else {
					movePiece(spaces.get(space.getXPosition()).get(space.getYPosition() + 1), space);
					if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
						movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
					}else{
						movePiece(space, spaces.get(space.getXPosition()).get(space.getYPosition() + 1));
						return false;
					}
				}
			}

		}
		return true;
		
	}
	




	private boolean checkForCurrentPlayerCheck(ArrayList<ArrayList<ClientSpace>> spaces, String currentPlayerColor) {
		ClientSpace kingPosition = null;
		if (currentPlayerColor.equals("white")) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getCurrentPieceId() == "whiteKing") {
						kingPosition = spaces.get(i).get(j);
					}
				}
			}

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
					if (spaces.get(i).get(j).getCurrentPieceId() == "blackKing") {
						kingPosition = spaces.get(i).get(j);
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (spaces.get(i).get(j).getPlayer() == "white") {
						if (spaces.get(i).get(j).getCurrentPieceId() == "whitePawn") {

							if (j > 1) {
								if (spaces.get(i - 1).get(j - 1) == kingPosition) {
									return true;
								}
							}

							if (j < 7) {
								if (spaces.get(i - 1).get(j + 1) == kingPosition) {
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
	
	public boolean checkForCastleWhite(ArrayList<ArrayList<ClientSpace>> spaces, String currentPlayerColor) {

		if (spaces.get(7).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(7).get(7).getOriginalPieceHasMoved() == false) {
			if (spaces.get(7).get(5).getCurrentPieceId() == null && spaces.get(7).get(6).getCurrentPieceId() == null) {
				ClientSpace tempSpace = new ClientSpace(7, 6);
				tempSpace.setCurrentPiece(spaces.get(7).get(6).getCurrentPiece());
				tempSpace.setCurrentPieceId(spaces.get(7).get(6).getCurrentPieceId());
				tempSpace.setPlayer(spaces.get(7).get(6).getPlayer());
				movePiece(spaces.get(7).get(6), spaces.get(7).get(4));
				
				ClientSpace tempSpace2 = new ClientSpace(7, 5);
				tempSpace2.setCurrentPiece(spaces.get(7).get(5).getCurrentPiece());
				tempSpace2.setCurrentPieceId(spaces.get(7).get(5).getCurrentPieceId());
				tempSpace2.setPlayer(spaces.get(7).get(5).getPlayer());
				movePiece(spaces.get(7).get(5), spaces.get(7).get(7));
				
				if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
					movePiece(spaces.get(7).get(4), spaces.get(7).get(6));
					movePiece(spaces.get(7).get(6), tempSpace);
					
					movePiece(spaces.get(7).get(7), spaces.get(7).get(5));
					movePiece(spaces.get(7).get(5), tempSpace2);
				}else{
					movePiece(spaces.get(7).get(4), spaces.get(7).get(6));
					movePiece(spaces.get(7).get(6), tempSpace);
					
					movePiece(spaces.get(7).get(7), spaces.get(7).get(5));
					movePiece(spaces.get(7).get(5), tempSpace2);
					return false;
				}
			}
		}

		if (spaces.get(7).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(7).get(0).getOriginalPieceHasMoved() == false) {
			if (spaces.get(7).get(3).getCurrentPieceId() == null && spaces.get(7).get(2).getCurrentPieceId() == null
					&& spaces.get(7).get(1).getCurrentPieceId() == null) {
				ClientSpace tempSpace = new ClientSpace(7, 2);
				tempSpace.setCurrentPiece(spaces.get(7).get(2).getCurrentPiece());
				tempSpace.setCurrentPieceId(spaces.get(7).get(2).getCurrentPieceId());
				tempSpace.setPlayer(spaces.get(7).get(2).getPlayer());
				movePiece(spaces.get(7).get(2), spaces.get(7).get(4));
				
				ClientSpace tempSpace2 = new ClientSpace(7, 2);
				tempSpace2.setCurrentPiece(spaces.get(7).get(3).getCurrentPiece());
				tempSpace2.setCurrentPieceId(spaces.get(7).get(3).getCurrentPieceId());
				tempSpace2.setPlayer(spaces.get(7).get(3).getPlayer());
				movePiece(spaces.get(7).get(3), spaces.get(7).get(0));
				
				if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
					movePiece(spaces.get(7).get(4), spaces.get(7).get(2));
					movePiece(spaces.get(7).get(2), tempSpace);
					
					movePiece(spaces.get(7).get(0), spaces.get(7).get(5));
					movePiece(spaces.get(7).get(3), tempSpace2);
				}else{
					movePiece(spaces.get(7).get(4), spaces.get(7).get(2));
					movePiece(spaces.get(7).get(2), tempSpace);
					
					movePiece(spaces.get(7).get(0), spaces.get(7).get(5));
					movePiece(spaces.get(7).get(3), tempSpace2);
					return false;
				}
			}
		}
		
		return true;

	}
	
	public boolean checkForCastleBlack(ArrayList<ArrayList<ClientSpace>> spaces, String currentPlayerColor) {

		if (spaces.get(0).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(0).get(7).getOriginalPieceHasMoved() == false) {
			if (spaces.get(0).get(5).getCurrentPieceId() == null && spaces.get(0).get(6).getCurrentPieceId() == null) {
				ClientSpace tempSpace = new ClientSpace(0, 6);
				tempSpace.setCurrentPiece(spaces.get(0).get(6).getCurrentPiece());
				tempSpace.setCurrentPieceId(spaces.get(0).get(6).getCurrentPieceId());
				tempSpace.setPlayer(spaces.get(0).get(6).getPlayer());
				movePiece(spaces.get(0).get(6), spaces.get(0).get(4));
				
				ClientSpace tempSpace2 = new ClientSpace(0, 5);
				tempSpace2.setCurrentPiece(spaces.get(0).get(5).getCurrentPiece());
				tempSpace2.setCurrentPieceId(spaces.get(0).get(5).getCurrentPieceId());
				tempSpace2.setPlayer(spaces.get(0).get(5).getPlayer());
				movePiece(spaces.get(0).get(5), spaces.get(0).get(7));
				
				if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
					movePiece(spaces.get(0).get(4), spaces.get(0).get(6));
					movePiece(spaces.get(0).get(6), tempSpace);
					
					movePiece(spaces.get(0).get(7), spaces.get(0).get(5));
					movePiece(spaces.get(0).get(5), tempSpace2);
				}else{
					movePiece(spaces.get(0).get(4), spaces.get(0).get(6));
					movePiece(spaces.get(0).get(6), tempSpace);
					
					movePiece(spaces.get(0).get(7), spaces.get(0).get(5));
					movePiece(spaces.get(0).get(5), tempSpace2);
					return false;
				}
			}
		}

		if (spaces.get(0).get(4).getOriginalPieceHasMoved() == false
				&& spaces.get(0).get(0).getOriginalPieceHasMoved() == false) {
			if (spaces.get(0).get(3).getCurrentPieceId() == null && spaces.get(0).get(2).getCurrentPieceId() == null
					&& spaces.get(0).get(1).getCurrentPieceId() == null) {
				ClientSpace tempSpace = new ClientSpace(0, 2);
				tempSpace.setCurrentPiece(spaces.get(0).get(2).getCurrentPiece());
				tempSpace.setCurrentPieceId(spaces.get(0).get(2).getCurrentPieceId());
				tempSpace.setPlayer(spaces.get(0).get(2).getPlayer());
				movePiece(spaces.get(0).get(2), spaces.get(7).get(4));
				
				ClientSpace tempSpace2 = new ClientSpace(0, 3);
				tempSpace2.setCurrentPiece(spaces.get(0).get(3).getCurrentPiece());
				tempSpace2.setCurrentPieceId(spaces.get(0).get(3).getCurrentPieceId());
				tempSpace2.setPlayer(spaces.get(0).get(3).getPlayer());
				movePiece(spaces.get(0).get(3), spaces.get(0).get(0));
				
				if(checkForCurrentPlayerCheck(spaces, currentPlayerColor) == true){
					movePiece(spaces.get(0).get(4), spaces.get(0).get(2));
					movePiece(spaces.get(0).get(2), tempSpace);
					
					movePiece(spaces.get(0).get(0), spaces.get(0).get(5));
					movePiece(spaces.get(0).get(3), tempSpace2);
				}else{
					movePiece(spaces.get(0).get(4), spaces.get(0).get(2));
					movePiece(spaces.get(0).get(2), tempSpace);
					
					movePiece(spaces.get(0).get(0), spaces.get(0).get(5));
					movePiece(spaces.get(0).get(3), tempSpace2);
					return false;
				}
			}
		}
		
		return true;

	}
	
	private void movePiece(ClientSpace newSpace, ClientSpace oldSpace) {

		newSpace.setPieceWithoutPaint(oldSpace.getCurrentPiece(), oldSpace);
		oldSpace.removePieceWithoutPaint();

	}
	
	public boolean checkForInsufficientPieces(String currentPlayerColor, ArrayList<ArrayList<ClientSpace>> spaces){
		
		int knights = 0;
		int blackBishops = 0;
		int whiteBishops = 0;
		int bishops = 0;
		List<Integer> bishopCoords = new ArrayList<Integer>();
		
		/*if(currentPlayerColor == "white"){
			opponentColor = "black";
		}else{
			opponentColor = "white";
		}*/
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (spaces.get(i).get(j).getCurrentPieceId() == "blackQueen" || spaces.get(i).get(j).getCurrentPieceId() == "whiteQueen" || spaces.get(i).get(j).getCurrentPieceId() == "blackRook" || spaces.get(i).get(j).getCurrentPieceId() == "whiteRook" || spaces.get(i).get(j).getCurrentPieceId() == "blackPawn" || spaces.get(i).get(j).getCurrentPieceId() == "whitePawn") {
					return false;
				}else if(spaces.get(i).get(j).getCurrentPieceId() == "blackBishop"){
					blackBishops++;
					bishops++;
					bishopCoords.add(i + j);
				}else if(spaces.get(i).get(j).getCurrentPieceId() == "whiteBishop"){
					whiteBishops++;
					bishops++;
					bishopCoords.add(i + j);
				}else if(spaces.get(i).get(j).getCurrentPieceId() == "blackKnight"){
					knights++;
				}else if(spaces.get(i).get(j).getCurrentPieceId() == "whiteKnight"){
					knights++;
				}
			}
		}
		
		if(knights >= 2 || bishops >= 3 || bishops <= 1 || (knights == 1 && bishops == 1)){
			return false;
		}
		
		if(bishops == 2){
			if(whiteBishops == 1 & blackBishops == 1){
				if((bishopCoords.get(0) - bishopCoords.get(1)) % 2 == 1){
					return false;
				}
			}
		}
		
		
		return true;
	}
}

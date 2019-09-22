package chapter18.tic_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws Exception {

		ServerSocket server = null;
		System.out.println("Start");
		try {
			server = new ServerSocket(9111);
			while (true) {
				Game game = new Game();

				Player player1 = new Player(game, server.accept(), 'X');
				Player player2 = new Player(game, server.accept(), 'O');

				player1.setOther(player2);
				player2.setOther(player1);

				player1.start();
				player2.start();
				System.out.println("페어가 만들어졌습니다.");

			}

		} catch (IOException e) {

		} finally {
			try {
				System.out.println("end");
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Game {
	char[][] boards = new char[3][3];

	public char getBoards(int i, int j) {
		return boards[i][j];
	}

	public void setBoards(int i, int j, char playerMark) {
		this.boards[i][j] = playerMark;
	}

	public void printBoard() {
		for (int k = 0; k < 3; k++) {
			System.out.println("  " + boards[k][0] + "|  " + boards[k][1] + "|  " + boards[k][2]);
			if (k != 2) {
				System.out.println("---|---|---");
			}
		}
	}// end of printBoard()

}

class Player extends Thread {
	Game game;
	Socket socket;
	BufferedReader input;
	PrintWriter output;
	char playerMark;
	Player other;

	public Player(Game game, Socket socket, char playerMark) {
		this.game = game;
		this.socket = socket;
		this.playerMark = playerMark;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);

			output.println("START " + playerMark);
			output.println("PRINT  다른 플레이어를 기다리고 있습니다. ");
		} catch (IOException e) {
			System.out.println("연결이 끊어졌습니다.");
		}
	}// end of Player()

	public void setOther(Player other) {
		this.other = other;
	}

	public void run() {
		try {
			output.println("PRINT  모든 경기자가 참가하였습니다.");
			if (playerMark == 'X') {
				output.println("PRINT your turn!");
			}

			while (true) {
				String command = input.readLine();

				if (command == null)
					continue;
				if (command.startsWith("MOVE")) {
					int i = Integer.parseInt(command.substring(5, 6));
					int j = Integer.parseInt(command.substring(7, 8));

					game.setBoards(i, j, playerMark);
					game.printBoard();
					other.output.println("OTHER " + i + " " + j);
					output.println("PRINT 기다리세요.");
					other.output.println("PRINT 당신 차례입니다.");
				} else if (command.startsWith("QUIT")) {
					return;
				}
			} // end of while
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// end of run()
}

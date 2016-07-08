package StudentCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import ImportManager.*;

public class GameManager {

	private char[] board = new char[22];
	//' ' for no players, '1' for player1, '2' for player2, 'b' for both 
	private ArrayList<Card> cards;
	private int index;
	private boolean player;
	//'1' or '2'
	private int player1pos = 0;
	private int player2pos = 0;

	public GameManager() {
		// TODO Auto-generated constructor stub
		index = 0;
		for(int j = 0; j< board.length; j++) {
			board[j] = ' ';
		}
		board[0] = 'b';
		cards = new ArrayList<Card>();
		//cards.add(new Card("you are at home, move 5 spaces","move -1 space"));
		InputStream input = ImportManager.cards;

		Scanner file = new Scanner(ImportManager.cards);

		ArrayList<String> strings = new ArrayList<String>();


		//try	//try-with-resources - new in Java 7

		while(file.hasNext())
		{
			String read = file.nextLine();
			//code to use input ...here's a test:
			//System.out.println("read in: " + read);
			strings.add(read);
		}
		file.close();
		//after getting the file, parsing through each string and adding it to the char array
		for (String line: strings) {
			String[]tokens = line.split("else");
			Card newCard = new Card(tokens[0],tokens[1]);
			cards.add(newCard);
		}

		for (int j = 0; j < cards.size(); j++) {
			System.out.println("Card" + j + ": " + cards.get(j));
		}
	}

	public String nextTurn() {
		//delete, sample code
		Card turn = cards.get(index);
		index++;
		int amt = turn.getMove(board);
		if (player) {
			//if player1
			int destination;
			if (player1pos + amt > 21) {
				destination = 21;
			}
			else if (player1pos + amt < 0) {
				destination = 0;
			}
			else {
				destination = amt;
			}
			removeFromBoard('1', player1pos);
			addToBoard('1', destination);
			player1pos = destination;
		}
		else {
			//if player2
			int destination;
			if (player2pos + amt > 21) {
				destination = 21;
			}
			else if (player2pos + amt < 0) {
				destination = 0;
			}
			else {
				destination = amt;
			}
			removeFromBoard('2', player1pos);
			addToBoard('2', destination);
			player1pos = destination;
		}
		player = !player; // changes player
		return "<html>Your Move: <br> if<br>" + turn.ifMove+ ". <br> else<br>" + turn.elseMove;
	}

	public char[] getBoard() {
		return board;
	}

	public boolean player1Won() {
		return false;
	}
	public boolean player2Won() {
		return false;
	}

	private void removeFromBoard(char player, int position) {
		char occupant = board[position];
		switch (occupant) {
		case '1':
			if (player == '1') {
				board[position] = ' ';
			}
			break;
		case '2':
			if (player == '2') {
				board[position] = ' ';
			}
			break;
		case 'b':
			if (player == '1') {
				board[position] = '2';
			}
			else {
				board[position] = '1';
			}
		}
	}

	private void addToBoard(char player, int position) {
		char oldOccupant = board[position];
		switch (oldOccupant) {
		case '1':
			if (player == '1') {
				board[position] = '1';
			}
			else {
				board[position] = 'b';
			}
			break;
		case '2':
			if (player == '2') {
				board[position] = '2';
			}
			else {
				board[position] = 'b';
			}
			break;
		case ' ':
			board[position] = player;

		}
	}

}

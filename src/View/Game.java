package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ImportManager.*;
import StudentCode.*;

public class Game {

	private GameManager manager;
	private JFrame frame;
	private JLabel[] board;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ImportManager.loadFiles();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
		manager = new GameManager();
		//runMoves();
		manager.nextTurn();
		runMoves();
	}

	private void runMoves() {
		char[] gameBoard = manager.getBoard();
		for (int j = 0; j < gameBoard.length; j++) {
			switch(gameBoard[j]) {
			case ' ':
				//case empty square
				if (j != 0){
					board[j].setIcon(new ImageIcon(ImportManager.empty));
				}
				else {
					board[j].setIcon(new ImageIcon(ImportManager.emptyStart));
				}
				break;
			case '1':
				//case player1 square
				if (j != 0){
					board[j].setIcon(new ImageIcon(ImportManager.player1));
				}
				else {
					if (manager.player1Won()) {
						board[j].setIcon(new ImageIcon(ImportManager.player1end));
					}

					else {
						board[j].setIcon(new ImageIcon(ImportManager.player1start));
					}
				}
				break;
			case '2':
				//case player2 square
				if (j != 0){
					board[j].setIcon(new ImageIcon(ImportManager.player2));
				}
				else {
					if (manager.player2Won()) {
						board[j].setIcon(new ImageIcon(ImportManager.player2end));
					}

					else {
						board[j].setIcon(new ImageIcon(ImportManager.player2start));
					}
				}
				break;
			case 'b':
				if (j != 0){
					board[j].setIcon(new ImageIcon(ImportManager.bothPlayers));
				}
				else {
					if (manager.player1Won()) {
						board[j].setIcon(new ImageIcon(ImportManager.bothEnd));
					}

					else {
						board[j].setIcon(new ImageIcon(ImportManager.bothStart));
					}
				}
				break;
			}
		}
		frame.revalidate();
		frame.repaint();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 795, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel square0 = new JLabel("");
		square0.setIcon(new ImageIcon(ImportManager.emptyStart));
		square0.setBounds(696, 397, 100, 100);
		frame.getContentPane().add(square0);

		JLabel square1 = new JLabel("");
		square1.setIcon(new ImageIcon(ImportManager.empty));
		square1.setBounds(596, 397, 100, 100);
		frame.getContentPane().add(square1);

		JLabel square2 = new JLabel("");
		square2.setIcon(new ImageIcon(ImportManager.empty));
		square2.setBounds(497, 397, 100, 100);
		frame.getContentPane().add(square2);

		JLabel square3 = new JLabel("");
		square3.setIcon(new ImageIcon(ImportManager.empty));
		square3.setBounds(397, 397, 100, 100);
		frame.getContentPane().add(square3);

		JLabel square4 = new JLabel("");
		square4.setIcon(new ImageIcon(ImportManager.empty));
		square4.setBounds(297, 397, 100, 100);
		frame.getContentPane().add(square4);

		JLabel square5 = new JLabel("");
		square5.setIcon(new ImageIcon(ImportManager.empty));
		square5.setBounds(201, 397, 100, 100);
		frame.getContentPane().add(square5);

		JLabel square6 = new JLabel("");
		square6.setIcon(new ImageIcon(ImportManager.empty));
		square6.setBounds(101, 397, 100, 100);
		frame.getContentPane().add(square6);

		JLabel square7 = new JLabel("");
		square7.setIcon(new ImageIcon(ImportManager.empty));
		square7.setBounds(1, 397, 100, 100);
		frame.getContentPane().add(square7);

		JLabel square8 = new JLabel("");
		square8.setIcon(new ImageIcon(ImportManager.empty));
		square8.setBounds(1, 299, 100, 100);
		frame.getContentPane().add(square8);

		JLabel square9 = new JLabel("");
		square9.setIcon(new ImageIcon(ImportManager.empty));
		square9.setBounds(1, 199, 100, 100);
		frame.getContentPane().add(square9);

		JLabel square10 = new JLabel("");
		square10.setIcon(new ImageIcon(ImportManager.empty));
		square10.setBounds(1, 100, 100, 100);
		frame.getContentPane().add(square10);

		JLabel square11 = new JLabel("");
		square11.setIcon(new ImageIcon(ImportManager.empty));
		square11.setBounds(1, 0, 100, 100);
		frame.getContentPane().add(square11);

		JLabel square12 = new JLabel("");
		square12.setIcon(new ImageIcon(ImportManager.empty));
		square12.setBounds(101, 0, 100, 100);
		frame.getContentPane().add(square12);

		JLabel square13 = new JLabel("");
		square13.setIcon(new ImageIcon(ImportManager.empty));
		square13.setBounds(201, 0, 100, 100);
		frame.getContentPane().add(square13);

		JLabel square14 = new JLabel("");
		square14.setIcon(new ImageIcon(ImportManager.empty));
		square14.setBounds(301, 0, 100, 100);
		frame.getContentPane().add(square14);

		JLabel square15 = new JLabel("");
		square15.setIcon(new ImageIcon(ImportManager.empty));
		square15.setBounds(400, 0, 100, 100);
		frame.getContentPane().add(square15);

		JLabel square16 = new JLabel("");
		square16.setIcon(new ImageIcon(ImportManager.empty));
		square16.setBounds(500, 0, 100, 100);
		frame.getContentPane().add(square16);

		JLabel square18 = new JLabel("");
		square18.setIcon(new ImageIcon(ImportManager.empty));
		square18.setBounds(696, 0, 100, 100);
		frame.getContentPane().add(square18);

		JLabel square17 = new JLabel("");
		square17.setIcon(new ImageIcon(ImportManager.empty));
		square17.setBounds(596, 0, 100, 100);
		frame.getContentPane().add(square17);

		JLabel square19 = new JLabel("");
		square19.setIcon(new ImageIcon(ImportManager.empty));
		square19.setBounds(696, 100, 100, 100);
		frame.getContentPane().add(square19);

		JLabel square20 = new JLabel("");
		square20.setIcon(new ImageIcon(ImportManager.empty));
		square20.setBounds(696, 199, 100, 100);
		frame.getContentPane().add(square20);

		JLabel square21 = new JLabel("");
		square21.setIcon(new ImageIcon(ImportManager.empty));
		square21.setBounds(696, 299, 100, 100);
		frame.getContentPane().add(square21);

		JButton btnPickUpCard = new JButton("Pick Up Card");
		btnPickUpCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//open new window showing card
				String newText = manager.nextTurn();
				Game.this.runMoves();
				btnPickUpCard.setText(newText);
			}
		});
		btnPickUpCard.setBounds(101, 100, 595, 299);
		frame.getContentPane().add(btnPickUpCard);

		board = new JLabel[]{square0,square1,square2,square3,square4,square5,square6,square7,square8,square9,square10,square11,square12,square13,square14,square15,square16,square17,square18,square19,square20,square21};

	}
}

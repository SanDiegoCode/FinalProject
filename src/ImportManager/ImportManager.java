package ImportManager;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

/**
 * This is the ImportManager class. This class, at startup, reads in all the required
 * files from its local directory. 
 * 
 * @author Ronak Shah
 *
 */
public class ImportManager {

	//generic title
	public static BufferedImage empty;
	public static BufferedImage player1;
	public static BufferedImage player2;
	public static BufferedImage bothPlayers;
	
	//start/end title
	public static BufferedImage emptyStart;
	public static BufferedImage player1start;
	public static BufferedImage player2start;
	public static BufferedImage player1end;
	public static BufferedImage player2end;
	public static BufferedImage bothStart;
	public static BufferedImage bothEnd;

	//cards
	public static InputStream cards;






	//public static BufferedImage titleScreen;

	/**
	 * Reads in all the files. MUST BE CALLED FIRST (Like absolutely first) in order to not 
	 * get apon thousands apon thousands apon thousands apon thousands apon thousands 
	 * apon thousands apon thousands apon thousands apon thousands apon thousands of java.lang.NULLPOINTEREXCEPTIONS
	 */
	public static void loadFiles(){
		try{
			empty = ImageIO.read(ImportManager.class.getResource("none.png"));
			player1 = ImageIO.read(ImportManager.class.getResource("player1.png"));
			player2 = ImageIO.read(ImportManager.class.getResource("player2.png"));
			bothPlayers = ImageIO.read(ImportManager.class.getResource("both.png"));
			
			emptyStart = ImageIO.read(ImportManager.class.getResource("nonestart.png"));
			player1start = ImageIO.read(ImportManager.class.getResource("redstart.png"));
			player2start = ImageIO.read(ImportManager.class.getResource("greenstart.png"));
			player1end = ImageIO.read(ImportManager.class.getResource("redend.png"));
			player2end = ImageIO.read(ImportManager.class.getResource("greenend.png"));
			bothStart = ImageIO.read(ImportManager.class.getResource("bothstart.png"));
			bothEnd = ImageIO.read(ImportManager.class.getResource("bothend.png"));

			cards = ImportManager.class.getResource("cards.txt").openStream();
			
		}
		catch(IOException e){
			//do nothing
		}
	}

}
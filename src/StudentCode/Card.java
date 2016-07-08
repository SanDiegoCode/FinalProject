package StudentCode;

public class Card {

	public String ifMove;
	public String elseMove;
	
	public Card(String ifMove, String elseMove) {
		this.ifMove = ifMove;
		this.elseMove = elseMove;
	}
	
	//format of string: if home do move 1 else move 0
	//or if 5 away do move 1 else move -5
	//consistent format
	public String getAction() {
		
		//students write this method
		return "1";
		//or "0" or "-1"
	}
	
	public int getMove(char[] board) {
		return 5;
	}
	
	public String toString() {
		return this.ifMove + this.elseMove;
	}
	

}

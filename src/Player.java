/**
 * 
 */

/**
 * @author aaron
 *
 */
public class Player {
	
	private int id;
	private int maxHold;
	private String[] hand;
	private int handPtr = -1;
	
	public Player(int maxHold, int id){
		this.id = id;
		this.maxHold = maxHold;
		this.hand = new String[maxHold];
		for(int i = 0; i < maxHold; i++){
			hand[i] = "XX";
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the maxHold
	 */
	public int getMaxHold() {
		return maxHold;
	}
	
	public boolean takeCard(String card){
		handPtr++;
		if(handPtr >= maxHold){
			handPtr--;
			return false;
		}
		else{
			hand[handPtr] = card;
			return true;
		}
	}
	
	public boolean giveCard(String card){
		handPtr--;
		if(handPtr < 0){
			handPtr++;
			return false;
		}
		else{
			hand[handPtr] = card;
			return true;
		}
	}
	
	public String[] getHand(){
		return hand;
	}
	
	public void remCards(){
		this.hand = new String[maxHold];
		for(int i = 0; i < maxHold; i++){
			hand[i] = "XX";
		}
		handPtr = -1;
	}
}

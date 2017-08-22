/**
 * 
 */

/**
 * @author aaron
 *
 */
public class BlackjackPlayer extends Player {
	
	private boolean oneAce;
	private int handVal;
	/**
	 * @param maxHold
	 * @param id
	 */
	public BlackjackPlayer(int id) {
		super(11, id);
		handVal = 0;
		// TODO Auto-generated constructor stub
	}
	
	public int getAceVal(){
		return oneAce ? 11 : 1;
	}
	
	public void setAceVal(boolean aceVal){
		oneAce = aceVal;
	}
	
	public boolean takeCard(String card){
		boolean init = super.takeCard(card);
		if(init){
			char rank = card.charAt(0);
			int cardVal = Character.getNumericValue(rank);
			if(cardVal >= 10){
				if(rank == 'A'){
					handVal += this.getAceVal();
				}
				else{
					handVal += 10;
				}
			}
			else{
				handVal += cardVal;
			}
		}
		return init;
	}
	
	public int getHandVal(){
		return handVal;
	}

}

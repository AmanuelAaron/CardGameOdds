import java.util.HashMap;
import java.util.ArrayList;;
/**
 * 
 */

/**
 * @author aaron
 *
 */
public class CardCounter {
	/** All of the ranks in a standard deck of cards in order of their value */
	public static final Character[] RANKS = {'2', '3', '4', '5', '6', '7', '8',
											'9', 'T', 'J', 'Q', 'K', 'A'};
	/** All of the suits in a standard deck of cards */
	public static final Character[] SUITS = {'D','H','S','C'};

	/** List of all cards seen by the CardCounter*/
	private ArrayList<String> cards = new ArrayList<String>();
	
	/** A count of the amount of cards with each rank and suit*/
	private HashMap<Character, Integer> rankCount = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> suitCount = new HashMap<Character, Integer>();

	/** Value to hold the rank and suit with the most cards*/
	private Character largestRank;
	private Character largestSuit;
	
	
	public CardCounter(){
		reset();
	}
	
	/**
	 * @return the largestRank
	 */
	public Character getLargestRank() {
		return largestRank;
	}

	/**
	 * @return the largestSuit
	 */
	public Character getLargestSuit() {
		return largestSuit;
	}

	/** Resets the card counter to its starting values
	 * */
	public void reset(){
		// Initialize all counts to 0
		for (Character rank: RANKS){
			rankCount.put(rank, 0);
		}
		for (Character suit: SUITS){
			suitCount.put(suit, 0);
		}
		// Default value of the "largest" values if all vals are 0
		largestRank = '2';
		largestSuit = 'D';
	}
	
	/** Adds card to the counter
	 * 
	 * @param card Card to add
	 * */
	public void add(String card){
		// Add the card to list of cards and get its rank and suit
		cards.add(card);
		char cRank = card.charAt(0);
		char cSuit = card.charAt(1);
		// Update the rank and suit count and the largest values in the counter
		rankCount.put(cRank, rankCount.get(cRank) + 1);
		suitCount.put(cSuit, suitCount.get(cSuit) + 1);
		if(rankCount.get(cRank) > rankCount.get(largestRank)){
			largestRank = cRank;
		}
		if(suitCount.get(cSuit) > suitCount.get(largestSuit)){
			largestSuit = cSuit;
		}
	}
}

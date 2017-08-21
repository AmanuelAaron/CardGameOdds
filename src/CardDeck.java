import java.util.Random;
/**
 * 
 */

/**
 * @author aaron
 *
 */
public class CardDeck {
		/** Standard deck*/
		private static String[] startDeck = {
				"2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD", "AD",
				"2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH", "AH",
				"2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC", "AC",
				"2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS", "AS",
		};
		/** Deck instance in its current state*/
		private String[] currDeck = startDeck.clone();
		/** Points to the index of the card most recently dealt*/
		private int deckPtr = -1;
		/** Var used for randomizing deck*/
		private static final Random rand = new Random();
		
		/** Shuffles the deck*/
		public void shuffle(){
			// Create a new deck to store our random draws
			String[] newDeck = new String[52];
			// Get random draws from our current deck state
			for(int i = 0; i < 52; i++){
				int randIdx = rand.nextInt(52);
				if(currDeck[randIdx] != "XX"){
					newDeck[i] = currDeck[randIdx];
					currDeck[randIdx] = "XX";
				}else{i--;}
			}
			// Set the current deck state to that of our new randomized deck
			currDeck = newDeck.clone();
		}
		/** Deals the top card of the deck*/
		public String deal(){
			// Move the deck pointer up one
			// If we exceed the length of the deck then return the error card and
			// move the pointer to the beginning
			deckPtr++;
			if(deckPtr < 52){
				return currDeck[deckPtr];
			}
			else{
				deckPtr = -1;
				return "XX";
			}
		}

}

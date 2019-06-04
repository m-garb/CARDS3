import java.util.Arrays;

/**
 * Deck class to keep track of the whole deck of cards for a card game
 * interacts with Hand and Card classes
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

class Hand {
   private Card[] myCards;
   private int numCards;
   private static final int MAX_CARDS = 52;     // Instruction mentions public int value
   
   /** Default Constructor */
   Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /** Clears the current hand */
   public void resetHand()
   {
       this.numCards = 0;
   }
   
   /** adds copy of a card to the hand 
    * @param card    Card to be added to hand
    * @return        whether a card was added or not
    */
   public  boolean takeCard(Card card)
   {
       Card tempCard = new Card(card);
       //tempCard = card;
       boolean wasTaken = false;
       if (numCards <= MAX_CARDS-1)
       {
           this.myCards[this.numCards] = tempCard;
           numCards++;
           return true;
       }
       return wasTaken;
   }
   
   /** plays and removes the top card in hand 
    * @return  Card at the highest index 
    *          (or invalid Card if empty hand)
    */
   public Card playCard()
   {   
       Card tempCard = new Card('Z', Card.Suit.SPADES);
       if (this.numCards > 0)
       {
           this.numCards--;
           tempCard = this.myCards[this.numCards-1];
       }
       
       return tempCard;
   }
   
   /** 
    * @return   string representation of all cards in hand
                formatted like "A of spades, 2 of clubs, J of hearts"
    */ 
   public String toString()
   {
       String tempCards = "";
       for(int i = 0; i < numCards; i++)
       {
           tempCards += myCards[i].toString() + ", ";
       }
       return tempCards;
   }
   
   
   /** Accessor for numCards
    * 
    * @return  number of cards in hand
    */
   public int getNumCards()
   {
       return this.numCards;
   }
   
   /** Inspect the card at the hand position.
    * 
    * @param k index of card to inspect in hand
    * @return  card at index k
    *          (or invalid card if k is invalid)
    */
   public Card inspectCard(int k)
   {
      if(k >= this.numCards || k < 0) //invalid k 
         return new Card('z',Card.Suit.SPADES); //invalid card w/ error flag
      else 
         return this.myCards[k];
   }
   
   public void sort()
   {
	   Arrays.sort(myCards);
   }
   
   public Card playCard(int cardIndex)
   {
      if ( numCards == 0 ) //error
      {
         //Creates a card that does not work
         return new Card('M', Card.Suit.SPADES);
      }
      //Decreases numCards.
      Card card = myCards[cardIndex];
      
      numCards--;
      for(int i = cardIndex; i < numCards; i++)
      {
         myCards[i] = myCards[i+1];
      }
      
      myCards[numCards] = null;
      
      return card;
    }
}


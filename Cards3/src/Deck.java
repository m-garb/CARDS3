/**
 * Deck class to keep track of the whole deck of cards for a card game
 * interacts with Hand and Card classes
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

import java.util.Random;
import java.util.Arrays;

class Deck
{
   public static final int CARDS_IN_PACK = 56;
   public final int MAX_CARDS = CARDS_IN_PACK*6; //essentially a max of 6 card packs
   
   /** contains one full pack of cards, to be copied as necessary into the deck */
   private static Card[] masterPack = new Card[CARDS_IN_PACK];
   
   private Card[] cards = new Card[MAX_CARDS];
   private int topCard;
  
   /**Constructor with specified number of packs
    * @param numpacks   number of card packs in deck
   */
   Deck(int numPacks)
   {
      if (masterPack[0]==null)
      {
         allocateMasterPack();
      }

      init(numPacks);
      topCard = (CARDS_IN_PACK * numPacks) - 1;
   }

   /** Default Constructor (calls the constructor with numPacks=1 parameter) */
   Deck()
   {
      this(1);
   }
   
   /** Creates the master pack where all the card values will come from */
   private void allocateMasterPack()
   {
      char[] values = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A','X'};
      int arrayIndex = 0;
      for(char v:values)
         for(int s = 0; s < 4; s++)
            Deck.masterPack[arrayIndex++] = new Card(v, getSuit(s));
   }
   
   /** Switch for getting a suit from an integer
    * @param num  int from 0-3 corresponding to card suits
    * @return     the suit corresponding to the number input
   */
   private Card.Suit getSuit(int num)
   {
      Card.Suit suit  = Card.Suit.SPADES;
      
      switch(num) { 
         case 0:
            suit = Card.Suit.SPADES;
            break;
         case 1:
            suit = Card.Suit.HEARTS;
            break;
         case 2:
            suit = Card.Suit.CLUBS;
            break;
         case 3:
            suit = Card.Suit.DIAMONDS;
            break;
         default:
            //Included for degugging
            System.out.println("Encountered error");
      }

      return suit;
   }

   /** repopulate the deck
    * @param numPacks   number of card packs in deck
    */  
   public void init(int numPacks)
   {
      this.topCard = ((CARDS_IN_PACK * numPacks) - 1);

      // Number of packs
      for (int i = 0; i < numPacks; i++)
         for (int j = 0; j < CARDS_IN_PACK; j++)  
            this.cards[(i*CARDS_IN_PACK)+j] = new Card(masterPack[j]);
      		
      		//System.out.println( (i * CARDS_IN_PACK) + j);
   }
   
   /** 
    * @return reference to the top card (at cards[topCard])
    */
   public Card getTopCard()
   {
      if(topCard<0)
         return new Card('z', Card.Suit.SPADES);
      return inspectCard(topCard);
   }
   
   /** returns and removes the top card from the deck (uses getTopCard())
    * @return reference to the top card (or an illegal card if deck is empty)
    */
   public Card dealCard()
   {
      Card tempCard = getTopCard();
      topCard--;
      return tempCard;
   }

   /** peeks at a card in the deck without removing it
    * @param k index of the desired card to inspect
    * @return  reference to the card at index k
    */
   public Card inspectCard(int k)
   {
      //Return the card in position k
      if(k <= this.topCard)
         return this.cards[k];
      //Return an illegal card
      else
         return new Card('z',Card.Suit.SPADES);
   }

   /** shuffles cards in deck */
   public void shuffle()
   {
      Random rng = new Random();
      int index; 
      Card temp;
      for(int i=topCard; i>0; i--){
         index = rng.nextInt(i);
         //Swap cards[index] with cards[i]
         temp = this.cards[index];
         this.cards[index] = this.cards[i];
         this.cards[i] = temp;
      }
   }
   
   public boolean addCard(Card card)
   {
	   //Check to see if there are too many instances of the card in the deck
	   //return false if too many
	   if(this.topCard >= MAX_CARDS)
	   {
		   return false;
	   }
	   else
	   {
		   this.cards[this.topCard] = card;
		   this.topCard++;
		   return true;
	   }
   }
   
   //put all the cards in the deck back into the right order according to values.
   public void sort()
   {
	   Arrays.sort(cards);
   }
   
   //returns the number of cards remaining in the deck
   public int getNumCards()
   {
	   return topCard;
   }

   public boolean removeCard(Card card)
   {
      boolean isInDeck = false;
      
      for(int i = 0; i <= topCard; i++)
      {
         if(card.equals(inspectCard(i)))
         {
            Card tempCard = new Card();
            tempCard = this.dealCard();
            cards[i] = tempCard;
            isInDeck = true;
         }
      }
      return isInDeck;
   }
}



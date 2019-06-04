class Card
{
   public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}; 
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   /** Default Constructor 
    * calls other constructor with default (A of SPADES) parameter 
    */
   Card()
   {
      this.value = 'A';
      this.suit = Suit.SPADES;
      this.errorFlag = false;
   }
   
   /** Constructor with specified values 
    * @param newValue   desired value for new Card
    * @param newSuit    desired suit for new Card
    */
   Card(char newValue, Suit newSuit)
   {
      if (isValid(newValue, newSuit))
      {
          this.value = Character.toUpperCase(newValue);
          this.suit = newSuit;
      }
      else
      {
          this.errorFlag = true;
      }
   }
   
   /** Copy Constructor 
    * calls other constructor with the parameters of a card to be copied
    * @param card    card to be copied 
    */
   Card(Card card)
   {
      this(card.value, card.suit); //TODO switch back to below lines if this doesn't work for some reason -ka
      //this.value = card.value;
      //this.suit = card.suit;
      //this.errorFlag = card.errorFlag;
   }
   
   /** checks whether 2 cards are the same
    * 
    * @param otherCard  card to be compared
    * @return           whether this and otherCard have same value and suit 
    */
   public boolean equals(Card otherCard)
   {
      return ((this.value == otherCard.value) && (this.suit ==  otherCard.suit));
   }
   
   /** toString overloader for Card class
    * @return string represention of the card
    *          formatted like "A of spades"
    */
   public String toString()
   {
      String cardString;
      
      if(this.errorFlag)
         cardString = "** illegal **";
      else
         cardString = Character.toString(this.value) + " of " + suit;
      
      return cardString;
   }
   
   /** Sets a Card's value and suit
    * 
    * @param value   desired value
    * @param suit    desired suit
    * @return        whether new values are valid & card successfully changed
    */
   public boolean set( char value, Suit suit)
   {
      value = Character.toUpperCase(value);
      if(isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         this.errorFlag = false;
      }
      else 
      {
         this.errorFlag = true;
      }
      
      return !this.errorFlag;
   }
   
   /** Accessor for Card value
    * 
    * @return  value of this card
    */
   public char getValue()
   {
      return this.value;
   }
   
   /** Accessor for Card suit
    * 
    * @return  suit of this card
    */
   public Suit getSuit()
   {
      return this.suit;
   }
   

   /** Checks whether Card is invalid (has an error flag)
    * 
    * @return  error state of this Card
    */
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   private boolean isValid(char value, Suit suit)
   {
      return "123456789TJQKAX".contains(Character.toString(value)) && suit!=null; 
   }
}



import javax.swing.*;
import java.awt.*;

   
public class GUICard {

   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.
   
//   static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
//   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
   private static Icon iconBack;
   static boolean iconsLoaded = false;
   
   static void loadCardIcons()
   {
	   int counter = 0;
	   for(int i = 0; i <= 13; i++)
	   {
		   for(int k = 0; k <=3; k++)
		   {
			   String filename = new String();
			   filename = "images/" + turnIntIntoCardValue(i) + turnIntIntoCardSuit(k) +".gif";
			   System.out.print(filename);
			   Icon image= new ImageIcon(filename);
			   iconCards[i][k] = image;
			   
//			   icon[counter] = image;
//			   counter++;
//			   System.out.printf("Counter %s.  Filename: %s%n", counter, filename);
			   
		   }
		   
		   iconBack = new ImageIcon("images/bk.gif");
		   iconsLoaded = true;
		   
	   }
   }
   
   //accessor for BackCard
	static public Icon getBackCardIcon()
	{
		return iconBack;
	}
   
	//insert Card, get Icon
	static public Icon getIcon(Card card)
	{
		return iconCards[valueAsInt(card)][suitAsInt(card)];
	}
	
	
	  private static int valueAsInt(Card card)
	   {
		   char value = card.getValue();
		   //System.out.printf("Value : %s%n",value);
		   switch (value)
		   {
		   case 'A':
			   return 13;
		   case 'K':
			   return 12;
		   case 'Q':
			   return 11;
		   case 'J':
			   return 10;
		   case 'T':
			   return 9;
		   case 'X':
			   return 0;
		   default:
			   int val = value - '0';
			   //System.out.printf("DEFAULT : %d%n", val);
			   return (val);
		   }
				   
	   }
	   private static int suitAsInt(Card card)
	   {
		   Card.Suit suit = card.getSuit();

		   if (suit == Card.Suit.SPADES)
		   {
			   	return 0;	   
		   }
		   else if (suit == Card.Suit.DIAMONDS)
		   {
			   return 1;
		   }
		   else if (suit == Card.Suit.HEARTS) {
			   return 2;
		   }
		   else if (suit == Card.Suit.CLUBS) {
			   return 3;
		   }
		   // Failed
		   else
		   {
			   return 4;
		   }
	   }
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
	   if ( k > 0 && k < 9)
	   {
		   return String.valueOf(k+1);
	   }
	   else if(k == 0)
	   {
		   return "X";
	   }
	   else if (k==9)
	   {
		   return "T";
	   }
	   else if (k==10)
	   {
		   return "J";
	   }
	   else if (k == 11)
	   {
		   return "Q";
	   }
	   else if (k == 12)
	   {
		   return "K";
	   }
	   else if (k == 13)
	   {
		   return "A";
	   }
	   else
	   {
		   return "F";
	   }

      // an idea for a helper method (do it differently if you wish)
   }
   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
  
	   switch(j)
	   {
	   case 0:
		   return "C";
	   case 1:
		   return "D";
	   case 2:
		   return "H";
	   case 3:
		   return "S";
	   }
	   return "F";
      // an idea for another helper method (do it differently if you wish)
	   //FAILED

   }
   
}
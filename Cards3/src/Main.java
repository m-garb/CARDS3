import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main 
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 



   public static void main(String[] args)
   {
      int numPacksPerDeck = 1;
      int numJokersPerPack = 2;
      int numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;


      int k;
      Icon tempIcon;
      
      CardGameFramework highCardGame = new CardGameFramework( 
            numPacksPerDeck, numJokersPerPack,  
            numUnusedCardsPerPack, unusedCardsPerPack, 
            NUM_PLAYERS, NUM_CARDS_PER_HAND);

   // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // show everything to the user
      myCardTable.setVisible(true);

      
      // CREATE LABELS ----------------------------------------------------
      for (int a = 0; a < NUM_CARDS_PER_HAND; a++)
      {
         computerLabels[a] = new JLabel();
         
         humanLabels[a] = new JLabel();
      }
      
      for (int b = 0; b < NUM_PLAYERS ; b++)
      {
          playedCardLabels[b] = new JLabel();
          playedCardLabels[b].setHorizontalAlignment(JLabel.CENTER);
          playLabelText[b] = new JLabel();
          playLabelText[b].setHorizontalAlignment(JLabel.CENTER);
      }

      
      
      GUICard.loadCardIcons();
      Hand compHand = new Hand();
      Hand playerHand = new Hand();
      Card[] compWins = new Card[(numPacksPerDeck * (52 + numJokersPerPack))];
      Card[] playerWins = new Card[(numPacksPerDeck * (52 + numJokersPerPack))];
      Deck deck = new Deck();
      deck.shuffle();
      
      JButton[] playerCards = new JButton[NUM_CARDS_PER_HAND];
      
      // ADD LABELS TO PANELS -----------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
          compHand.takeCard(deck.dealCard());
          computerLabels[k].setIcon(GUICard.getBackCardIcon());
          myCardTable.pnlComputerHand.add(computerLabels[k]);
          //System.out.printf("CompHand : %d ||| %s%n",k, compHand.inspectCard(k).toString());
          
          playerHand.takeCard(deck.dealCard());
          //playerCards[k].setIcon(GUICard.getIcon(playerHand.inspectCard(k)));
          humanLabels[k].setIcon(GUICard.getIcon(playerHand.inspectCard(k)));
          myCardTable.pnlHumanHand.add(humanLabels[k]);
          //System.out.printf("PlayerHand : %d ||| %s%n",k, playerHand.inspectCard(k).toString());
      }


      playedCardLabels[0].setIcon(GUICard.getIcon(compHand.inspectCard(0)));
      myCardTable.pnlPlayArea.add(playedCardLabels[0]);

      playedCardLabels[1].setIcon(GUICard.getIcon(playerHand.inspectCard(0)));
      myCardTable.pnlPlayArea.add(playedCardLabels[1]);
      myCardTable.pnlPlayArea.add(playLabelText[0]);
      myCardTable.pnlPlayArea.add(playLabelText[1]);
      
      
    
      playLabelText[0].setText("Computer");
      playLabelText[1].setText("You");
      
      
      
      

      // show everything to the user
      myCardTable.setVisible(true);
   }



}




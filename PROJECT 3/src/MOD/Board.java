package MOD;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
public class Board extends JFrame{
    // INSTANCE VARIABLES
    private List<Card> cards;
    private Card selectedCard;
    private Card card1;
    private Card card2;
    private Timer time;

    /**
     * This method sets up the cards and their values, and shuffles them. Also sets up the layout of the cards
     * on the board panel. If a card is clicked on, it'll turn.
     */
    public Board(){
        // VARIABLES
        int pairs = 10;
        List<Card> cardsList = new ArrayList<>();
        List<Integer> cardValues = new ArrayList<>();

        for (int i = 0; i < pairs; i++){
            cardValues.add(i);
            cardValues.add(i);
        }
        Collections.shuffle(cardValues);

        // sets the cards and their values
        for(int i = 0; i < cardValues.size(); i++){
            final Card c = new Card();
            c.setId(cardValues.get(i));
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;

                    // turns the card
                    if (card1 == null && card2 == null){
                        card1 = selectedCard;
                        card1.setText(String.valueOf(card1.getId()));
                    }

                    if (card1 != null && card1 != selectedCard && card2 == null){
                        card2 = selectedCard;
                        card2.setText(String.valueOf(card2.getId()));
                        time.start();
                    }
                }
            });
            cardsList.add(c);
        }
        cards = cardsList; // list of the set up cards

        // set up the timer
        time = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });
        time.setRepeats(false);

        // Set up of the cards for the board
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));

        for(int i = 0; i < cards.size(); i++)
            pane.add(cards.get(i));

        setTitle("Memory Game");
    }

    /**
     * This method checks to see if the cards are a match. If they are a match, then they will be marked. If they
     * aren't a match, they will return to their normal state until the player gets the match correct.
     */
    public void checkCards(){
        // if the cards match
        if (card1.getId() == card2.getId()){
            //disables the button
            card1.setEnabled(false);
            card2.setEnabled(false);

            //flags the button as having been matched
            card1.setMatched(true);
            card2.setMatched(true);

            if (isGameWon()){
                JOptionPane.showMessageDialog(this, "CONGRATS YOU WIN! :)");
                System.exit(0);
            }
        }
        // if the cards don't match
        else{
            // sets the card back the way it was/blank
            card1.setText("");
            card2.setText("");
        }

        //reset c1 and c2
        card1 = null;
        card2 = null;
    }

    /**
     * This method check to see if the player has won
     * @return true if the game is won, false otherwise.
     */
    public boolean isGameWon(){
        for(int i = 0; i < cards.size(); i++)
            if (cards.get(i).getMatched() == false)
                return false;

        return true;
    }

}

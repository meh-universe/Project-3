package MOD;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Card extends JButton{
    // INSTANCE VARIABLES
    private int id;
    private boolean matched = false;

    // SETTER METHODS
    public void setId(int otherID){
        id = otherID;
    }

    public void setMatched(boolean match){
        matched = match;
    }

    // ACCESSOR METHODS
    public int getId(){
        return id;
    }

    public boolean getMatched(){
        return matched;
    }
}
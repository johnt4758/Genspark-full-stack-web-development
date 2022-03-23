package source;

public class HangmanDrawing {

    private int maxNumOfLimbs = 6;

    public int currentLimbCount;

    public void drawNextLimb(){
        //on failed guess, call this method to add the next limb
        currentLimbCount++;
    }
}

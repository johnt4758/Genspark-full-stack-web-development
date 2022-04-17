package john_manuel.genspark.utils;

//library I found that uses DataMuse API (https://www.datamuse.com/api/) to generate a random word
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

public class RandomWord {

    private String chosenWord;

    public RandomWord(){
        if(chosenWord.isEmpty()){
            setChosenWord();
        }
    }

    public String getChosenWord(){return chosenWord;}

    public void setChosenWord(){chosenWord = RandomWordGenerator.getRandomWord();}

}

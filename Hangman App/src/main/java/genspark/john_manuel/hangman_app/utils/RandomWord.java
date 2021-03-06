package genspark.john_manuel.hangman_app.utils;

//library I found that uses DataMuse API (https://www.datamuse.com/api/) to generate a random word
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

public class RandomWord {

    private String generatedWord;

    public int maxNumOfGuesses;

    public void generateNewWord(){
        generatedWord = RandomWordGenerator.getRandomWord();
        maxNumOfGuesses = generatedWord.length() * 2;
    }

    public Integer getWordSize(){
        int letterCount;
        try{
            letterCount = generatedWord.length();
            return letterCount;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NullPointerException("Most likely no word generated to get the size of");
        }
    }

    public String getWord(){
        String currentWord;
        try{
            currentWord = generatedWord;
            return currentWord;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NullPointerException("Most likely no word generated");
        }
    }
}

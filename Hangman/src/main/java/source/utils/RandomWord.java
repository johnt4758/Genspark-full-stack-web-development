package source.utils;

//library I found that uses DataMuse API (https://www.datamuse.com/api/) to generate a random word
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

public class RandomWord {

    public String generateNewWord(){
        String generatedWord;
        return generatedWord = RandomWordGenerator.getRandomWord();
    }
}

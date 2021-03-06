package source;

import org.junit.jupiter.api.*;
import source.utils.Drawing;
import source.utils.RandomWord;

class HangmanTest {

    RandomWord word;

    @BeforeEach
    void setUp() {
        word = new RandomWord();
    }

    @Test
    void randomWordGeneratorImportTest(){
        System.out.println(word.generateNewWord());
    }

    @Test
    void boardDrawingTest(){
        Drawing draw = new Drawing();
        StringBuilder board = draw.boardDrawing();
        draw.displayBoard(board);
        draw.updateMan(board);
        draw.displayBoard(board);
        draw.updateMan(board);
        draw.displayBoard(board);
    }

    @Test
    void winConditionTest(){
        HangmanGame game = new HangmanGame();
        game.newGame();
        game.start();
    }

    @AfterEach
    void tearDown() {
    }
}
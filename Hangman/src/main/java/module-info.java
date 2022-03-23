module genspark.john_manuel.hangman {
    requires javafx.controls;
    requires javafx.fxml;


    opens genspark.john_manuel.hangman to javafx.fxml;
    exports genspark.john_manuel.hangman;
}
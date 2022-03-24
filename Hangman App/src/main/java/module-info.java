module genspark.john_manuel.hangman_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires random.word.generator;

    opens genspark.john_manuel.hangman_app to javafx.fxml;
    exports genspark.john_manuel.hangman_app;
}
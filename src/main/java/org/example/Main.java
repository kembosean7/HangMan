package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Words words = new Words();
    GameLogic gameLogic = new GameLogic();
    String guessWord = gameLogic.getWord(words.wordsList());
    GameLogic.play(guessWord);

    }
}
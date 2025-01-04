package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Words words = new Words();
    GameLogic game = new GameLogic();
//    List<String> data = words.wordsList();
//    String randomString = game.getWord(data);
//    System.out.println(randomString);
        System.out.println(game.displayHangMan(5));
    }
}
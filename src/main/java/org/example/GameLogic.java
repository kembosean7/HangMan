package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    public String getWord(List<String> list){

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void play(String word){
        int tries = 6;
        boolean guessed = false;
        List<Character> guessedLetters = new ArrayList<>();
        List<String> guessedWords = new ArrayList<>();
        StringBuilder wordCompletion = new StringBuilder("_".repeat(word.length()));

        GameLogic gameLogic = new GameLogic();
        System.out.println("Let's play Hangman!");
        System.out.println(gameLogic.displayHangMan(tries));
        System.out.println("\n");

        Scanner myObj = new Scanner(System.in);

        while(!guessed  && tries > 0){
            System.out.println("Please guess a letter or word: ");
            String guess = myObj .nextLine().toUpperCase();


            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
                char guessedLetter = guess.charAt(0);
                if (guessedLetters.contains(guessedLetter)){
                    System.out.println("You already guessed the letter " + guessedLetter);

                }
                else if (!word.toUpperCase().contains(String.valueOf(guessedLetter))) {
                    System.out.println("Letter not in word");
                    tries--;
                    guessedLetters.add(guessedLetter);
                }
                else {
                    System.out.println("Good job, " + guessedLetter + " is in the word");
                    guessedLetters.add(guessedLetter);

                    for (int i = 0; i < word.length(); i++) {
                        if (Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(guessedLetter)) {
                            wordCompletion.setCharAt(i, word.charAt(i));
                        }
                    }
                    System.out.println(wordCompletion);

                    if(!wordCompletion.toString().contains("_")){
                        guessed = true;
                    }

                }
            }
            else if (guess.length() == word.length() && Character.isAlphabetic(guess.charAt(0))) {
                if (guessedWords.contains(guess)) {
                    System.out.println("You already guessed the word");

                } else if (!guess.equals(word)) {
                    System.out.println(guess + " is not the word");
                    tries--;
                    guessedWords.add(guess);
                } else {
                    guessed = true;
                    guessedWords.add(guess);
                }
            }

            else{
                System.out.println("Not a valid guess");
                }

            System.out.println(gameLogic.displayHangMan(tries));
            System.out.println(wordCompletion);
            System.out.println("\n");

            }

        if(guessed){
            System.out.println("Congrats, you guessed the word, you win!");
        }
        else{
            System.out.println("Sorry you ran out of tries. The word was: "+ word);
        }





    }

    private String displayHangMan(Integer tries){
        List<String> stages = Arrays.asList(// final state: head, torso, both arms, and both legs
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / \\ 
                   - 
                """,
                //head, torso, both arms, and one leg
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / 
                   - 
                """,
                // head, torso, and both arms
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |      
                   - 
                """,
                //head, torso, and one arm
                """
                   --------
                   |      |
                   |      O
                   |     \\| 
                   |      |
                   |     
                   - 
                """,
                // head and torso
                """
                   --------
                   |      |
                   |      O
                   |      |
                   |      |
                   |     
                   - 
                """,
                // head

                """
                   --------
                   |      |
                   |      O
                   |    
                   |      
                   |     
                   - 
                """,

                // initial empty state
                """
                   --------
                   |      |
                   |      
                   |    
                   |      
                   |     
                   - 
                   """
                );
        return stages.get(tries);
    }

}


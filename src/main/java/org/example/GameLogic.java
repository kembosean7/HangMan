package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameLogic {
    public String getWord(List<String> list){

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
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


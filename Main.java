import java.util.Scanner;

   
class WordGuessGame {
    private final String secretWord;  
    private String guessedWord;          

      
    public WordGuessGame(String word) {
        this.secretWord = word.toLowerCase();

        guessedWord = "_".repeat(secretWord.length());
    }

          
    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        StringBuilder newGuessed = new StringBuilder(guessedWord);

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                newGuessed.setCharAt(i, letter);
            }
        }
        guessedWord = newGuessed.toString();
    }

       
    public String getGuessedWord() {
        return guessedWord;
    }

    
    public boolean isWin() {
        return guessedWord.equals(secretWord);
    }
}


public class Main {
    public static void main(String[] args) {
       
        try (Scanner scanner = new Scanner(System.in)) {

               
            WordGuessGame game = new WordGuessGame("Ali");

            System.out.println("-Bazi Hatse Kalame-");
            System.out.println("Kalame :" + game.getGuessedWord());

            int attempts = 0;

            while (!game.isWin()) {
                System.out.print("Ye Harf Hatse Bezan:");
                char letter = scanner.next().charAt(0);
                game.guessLetter(letter);
                attempts++;
                System.out.println("Vaziate :" + game.getGuessedWord());
            }

            System.out.println("Barande Shodi :" + game.getGuessedWord());
            System.out.println("Tedad Talash :" + attempts);

        }     
    }
}




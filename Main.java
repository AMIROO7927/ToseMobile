import java.util.Scanner;

// کلاس اصلی بازی
class WordGuessGame {
    private final String secretWord; // کلمه مخفی
    private String guessedWord;       // وضعیت فعلی حدس‌ها

    // سازنده کلاس
    public WordGuessGame(String word) {
        this.secretWord = word.toLowerCase();
        // جایگزین کردن همه حروف با "_"
        guessedWord = "_".repeat(secretWord.length());
    }

    // متد برای حدس زدن یک حرف
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

    // نمایش وضعیت فعلی
    public String getGuessedWord() {
        return guessedWord;
    }

    // بررسی برد
    public boolean isWin() {
        return guessedWord.equals(secretWord);
    }
}

// کلاس اجرای بازی
public class Main {
    public static void main(String[] args) {
        // استفاده از try-with-resources تا Scanner بعد از کار بسته شود
        try (Scanner scanner = new Scanner(System.in)) {

            // تعریف کلمه مخفی
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

        } // Scanner خودکار بسته می‌شود
    }
}




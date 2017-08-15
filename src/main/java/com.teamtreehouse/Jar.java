import java.util.Random;

public class Jar {
  private static int tries = 1;
  static int number;
  
  public static void Random() {
    Random random = new Random();
    int maxItemsAllowed = Prompter.number;
    number = random.nextInt(maxItemsAllowed - 1 + 1) + 1;
  }
  public static void fill() {
    if(ifEmpty()){
      number = Prompter.number;
    }
    else if (!isNumber(number)) {
    	System.out.println("Please enter a number.");
    }
  }
  
  public static boolean isNumber(Integer number) {
	  if(number instanceof Integer) {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public static boolean ifEmpty() {
    if(number == 0) {
    	return true;
    } else {
    	return false;
    }
  }
  
  public static boolean guessIsCorrect() {
    if(number == Prompter.guess)
      return true;
    else 
      return false;
  }
  
  public static int promptForGuess() {
    if(!guessIsCorrect()) {
      System.out.println("Guess was incorrect, please try again.");
      ++tries;
      Prompter.askForGuess();
    }
    return tries;
  }
  
  public static boolean gameIsWon() {
    return guessIsCorrect() != false;
  }
  
}

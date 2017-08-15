import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompter {
  private Jar jar;
  private static Scanner scan;
  static int number;
  static int guess;
  static String items;
  
  public Prompter(Jar jar) {
    this.jar = jar;
  }
  
  public static String askForItem() {
    scan = new Scanner(System.in);
    try {
    	System.out.println("Please enter item name:");
    	items = scan.nextLine();
    } catch (InputMismatchException e) {
    	System.out.println(e.getMessage());
    }
    return items;
  }
  

  public static int askForNumber() {
	  scan = new Scanner(System.in);
	  int item = 0;
	  try {
		  System.out.println("Please enter maximum number of " + items + ":");
	    	item = scan.nextInt();
	  } catch (InputMismatchException e) {
	    	System.out.println(e.getMessage());
	  }
	  number = item;
	  return number;
   }
  

  public static void fillJar() {
	  Jar.fill();
	  Jar.Random();
	  System.out.println("PLAYER");
	  System.out.println("=====================");
	  System.out.println("Your goal is to guess how many " + items + " are in the jar.");
  }
  
  public static int askForGuess() {
	  scan = new Scanner(System.in);
	  int item = 0;
	  try {		  
		  System.out.printf("Please enter your guess, which should be between 1 and " + number + "\n");
		  item = scan.nextInt();
	  } catch (InputMismatchException e) {
	    	System.out.println(e.getMessage());
	  }
	  guess = item;
	  return guess;
  }
  
  public static void administrator() {
	System.out.println("ADMINISTRATOR");
    System.out.println("=====================");
    System.out.println("Welcome to the game.");
    if(Jar.ifEmpty()) {
      System.out.println("Jar is empty, game will start now.");
    }
  }
    
  public void displayOutcome() {
	  while(!Jar.gameIsWon()) {
		  Jar.promptForGuess();
	  }
	  if(Jar.gameIsWon()) {
		  System.out.println("Congratulation, you guessed it correctly. There were " + Jar.number +  " of " + items + " in the jar.");
	      System.out.printf("It took you %d guess(es). %n",
	                       Jar.promptForGuess());
	  }   
  }
}
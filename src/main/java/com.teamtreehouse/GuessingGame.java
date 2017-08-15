public class GuessingGame {
  
	public static void main(String[] args) {
	      Prompter prompter = new Prompter(null);
	      prompter.administrator();
	      prompter.askForItem();
	      prompter.askForNumber();
	      prompter.fillJar();
	      prompter.askForGuess();
	      prompter.displayOutcome();
	      
	}
}
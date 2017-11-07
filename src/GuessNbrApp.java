
public class GuessNbrApp {

	public static void main(String[] args) {
		
		Console.printToConsole("Welcome to the Guess the Number Game");
		Console.printToConsole("++++++++++++++++++++++++++++++++++++");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			Console.printToConsole(Game.welcomeToGameMsg);
			// 1) start a new game
			// 2) reset the guess count
			// 3) generate the correct (random) number
			Game thisGame = new Game();  

			while (!thisGame.isCorrectGuess()) {
				int guess = Console.getInt("Enter number:  ", Game.MIN, Game.MAX);
				String message = thisGame.evaluateGuessAndReturnMessage(guess);
				Console.printToConsole(message);
			}
			choice = Console.getString("Try again? (y/n?:");
		}
		
		Console.printToConsole("Bye!");
	}
}

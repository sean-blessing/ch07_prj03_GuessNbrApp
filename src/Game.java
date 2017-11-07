
/*
 * display messages and handle user guesses to that class
 * use instance variables of the Game class to keep track of numbers, guesses, and so on
 * no static methods
 */
public class Game {
	private int nbrGuesses;
	private int correctNumber; // randomly generated # at the beginning of the game
	public static final int MIN=1;
	public static final int MAX=100;
	public static final String welcomeToGameMsg = "I'm thinking of a number from 1 to 100.\n"+
													"Try to guess it.";
	private boolean correctGuess;
	
	public Game() {
		setNbrGuesses(0);
		setCorrectNumber(generateRandomNumber());
		setCorrectGuess(false);
	}
	
	public int getNbrGuesses() {
		return nbrGuesses;
	}
	public void setNbrGuesses(int nbrGuesses) {
		this.nbrGuesses = nbrGuesses;
	}
	public int getCorrectNumber() {
		return correctNumber;
	}
	public void setCorrectNumber(int correctNumber) {
		this.correctNumber = correctNumber;
	}
	
	public boolean isCorrectGuess() {
		return correctGuess;
	}

	public void setCorrectGuess(boolean correctGuess) {
		this.correctGuess = correctGuess;
	}

	public int generateRandomNumber() {
		return (int)(Math.random()*MAX)+1;
	}
	
	public void incrementGuessCount() {
		nbrGuesses++;
	}
	
	public String evaluateGuessAndReturnMessage(int guess) {
		String msg = "";
		incrementGuessCount();
		int diff = guess - correctNumber;
		if (diff > 10) {
			// way too high
			msg = "Way too high!!!";
		}
		else if (diff < -10) {
			// way too low
			msg = "Way too low!!!";
		}
		else if (diff > 0) {
			// too high
			msg = "Too high!!!";
		}
		else if (diff < 0) {
			// too low
			msg = "Too low!!!";
		}
		else {
			// correct guess
			msg = "You got it in "+nbrGuesses+" tries.\n";
			if (nbrGuesses<=3)
				msg+="Great work you are a mathematical wizard!!!";
			else if (nbrGuesses<=7) 
				msg+="Not too bad! You've got some potential.";
			else 
				msg+="What took you so long? Maybe you should take some lessons.";
			correctGuess=true;
		}
		return msg;
	}
}

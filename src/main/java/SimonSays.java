import java.util.NoSuchElementException;
import java.util.Scanner;


public class SimonSays {

	private static final String SIMON_SAYS = "Simon says";
	
	private static boolean didSimonSay(String phrase) {
		return phrase.startsWith(SIMON_SAYS);
	}
	
	private static String getAction(String phrase) {
		return phrase.replaceFirst(SIMON_SAYS, "");
	}
	
	public static void main(String[] args) {
			
		try (Scanner scan = new Scanner(System.in)){
			int amount = Integer.valueOf(scan.nextLine());
			
			for (int i = 0; i < amount; ++i) {
				String phrase = scan.nextLine();
				
				if (didSimonSay(phrase)) System.out.println(getAction(phrase));
			}
			
		} catch (NumberFormatException e) {
			System.err.println("Was expecting an integer");
		} catch (NoSuchElementException e) {
			System.err.println("Number of line inputs was less than expected");
		}

	}

}

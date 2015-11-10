import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class QuickBrownFox {

	@SuppressWarnings("rawtypes")
	private static final SortedSet alpha = new TreeSet();

	static {
		for (char aCar : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			alpha.add(aCar);
		}
	}

	/**
	 * If is a pangram, returns "", else returns missing characters.
	 * 
	 * @param phrase
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private static String isPangram(String phrase) {
		char[] toChar = phrase.toLowerCase().toCharArray();
		Set hasChars = new HashSet();

		for (char aChar : toChar) {
			hasChars.add(aChar);
		}

		StringBuilder result = new StringBuilder("");
		for (Object aChar : alpha) {
			if (!hasChars.contains(aChar)) {
				result.append(aChar);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {

		try (Scanner SC = new Scanner(System.in)){
			int amount = Integer.valueOf(SC.nextLine());

			for (int i = 0; i < amount; ++i) {
				String phrase = SC.nextLine();
				String result = isPangram(phrase);

				System.out.println(result.equals("") ? "pangram" : "missing " + result);
			}

		} catch (NumberFormatException e) {
			System.err.println("Was expecting an integer");
		} catch (NoSuchElementException e) {
			System.out.println("Number of line inputs does not match expected");
		}

	}

}

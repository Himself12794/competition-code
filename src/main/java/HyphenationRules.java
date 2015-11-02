import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

public class HyphenationRules {
	
	private static final String VOWELS = "([aeiouy])";
	private static final String CONSONANTS = "(qu|tr|br|str|st|sl|bl|cr|ph|ch|[bcdfghjklmnpqrstvwxz])";

	private static final Pattern RULE_ONE_REGEX = Pattern.compile(VOWELS + CONSONANTS + CONSONANTS + VOWELS, Pattern.CASE_INSENSITIVE);
	private static final Function<String, String> RULE_ONE = t -> t.replaceAll(RULE_ONE_REGEX.pattern(), "$1$2-$3$4");

	private static final Pattern RULE_TWO_REGEX = Pattern.compile(VOWELS + CONSONANTS + VOWELS, Pattern.CASE_INSENSITIVE);
	private static final Function<String, String> RULE_TWO = t -> t.replaceAll(RULE_TWO_REGEX.pattern(), "$1-$2$3");

	private static final Pattern E_FIX_REGEX = Pattern.compile("(-)" + CONSONANTS + "(e$)", Pattern.CASE_INSENSITIVE);
	private static final Function<String, String> E_FIX = t -> t.replaceAll(E_FIX_REGEX.pattern(), "$2$3");

	private static final Function<String, String> PROCEDURE = RULE_TWO.andThen(RULE_ONE).andThen(RULE_TWO).andThen(E_FIX).andThen(RULE_ONE);

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			StringBuilder input = new StringBuilder();
			String line = sc.nextLine();

			while (!line.equals("===")) {
				input.append(line);
				input.append(' ');
				line = sc.nextLine();
			}

			String[] words = input.toString().split(" ");

			for (String word : words) {
				System.out.println(PROCEDURE.apply(word));
			}

		}

	}

}
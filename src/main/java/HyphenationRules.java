import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyphenationRules {
	private static final String VOWELS = "([aeiouy])";
	private static final String CONSONANTS = "(qu|tr|br|str|st|sl|bl|cr|ph|ch|[bcdfghjklmnpqrstvwxz])";

	private static final Pattern RULE_ONE = Pattern.compile(VOWELS + CONSONANTS + CONSONANTS + VOWELS,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern RULE_TWO = Pattern.compile(VOWELS + CONSONANTS + VOWELS, Pattern.CASE_INSENSITIVE);
	private static final Pattern E_FIX = Pattern.compile("(-)" + CONSONANTS + "(e$)", Pattern.CASE_INSENSITIVE); 

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			StringBuilder input = new StringBuilder();
			String line = sc.nextLine();
			
			while (!line.equals("===")) {
				input.append(line);
				line = sc.nextLine();
			}
			
			String[] words = input.toString().split(" ");
			
			for (String word : words) {
				String s1 = word.replaceAll(RULE_TWO.pattern(), "$1-$2$3");
				String s2 = s1.replaceAll(RULE_ONE.pattern(), "$1$2-$3$4");
				s2 = s2.replaceAll(RULE_TWO.pattern(), "$1-$2$3").replaceAll(E_FIX.pattern(), "$2$3");
				s2 = s2.replaceAll(RULE_ONE.pattern(), "$1$2-$3$4");
				System.out.println(s2);
			}
			
		}

	}

}
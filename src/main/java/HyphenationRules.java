import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyphenationRules {
	private static final String VOWELS = "[aeiouy]";
	private static final String CONSONANTS = "(qu|tr|br|str|st|sl|bl|cr|ph|ch|[bcdfghjklmnpqrstvwxz])";

	
	private static final Pattern END_WORD_E = Pattern.compile("e$", Pattern.CASE_INSENSITIVE);

	//private static final Pattern EXCLUSION = Pattern.compile("[", Pattern.CASE_INSENSITIVE);
	private static final Pattern RULE_ONE = Pattern.compile(VOWELS + CONSONANTS + CONSONANTS + VOWELS,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern RULE_TWO = Pattern.compile(VOWELS + CONSONANTS + VOWELS + "&^e$", Pattern.CASE_INSENSITIVE);

	public static void main(String[] args) {
		
		String text = "Word processors often split a word across lines using hyphenation, a technique requiring some knowledge of where the syllables in the word are divided. The rules given in this problem are a bit crude. But they represent a good starting point.";
		
		Matcher matches = RULE_ONE.matcher(text);
		
		while (matches.find()) {
			System.out.println(matches.group());
		}
		
		//for (String match : RULE_ONE.split(text)) {
		//	System.out.println(match);
		//}

	}

}

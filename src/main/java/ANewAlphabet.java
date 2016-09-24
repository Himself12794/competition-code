import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ANewAlphabet {

	private static final Map<Character, String> MAPPING = new HashMap<>();
	
	static {
		MAPPING.put('a', "@");
		MAPPING.put('n', "[]\\[]");
		MAPPING.put('b', "8");
		MAPPING.put('o', "0");
		MAPPING.put('c', "(");
		MAPPING.put('p', "|D");
		MAPPING.put('d', "|)");
		MAPPING.put('q', "(,)");
		MAPPING.put('e', "3");
		MAPPING.put('r', "|Z");
		MAPPING.put('f', "#");
		MAPPING.put('s', "$");
		MAPPING.put('g', "6");
		MAPPING.put('t', "']['");
		MAPPING.put('h', "[-]");
		MAPPING.put('u', "|_|");
		MAPPING.put('i', "|");
		MAPPING.put('v', "\\/");
		MAPPING.put('j', "_|");
		MAPPING.put('w', "\\/\\/");
		MAPPING.put('k', "|<");
		MAPPING.put('x', "}{");
		MAPPING.put('l', "1");
		MAPPING.put('y', "`/");
		MAPPING.put('m', "[]\\/[]");
		MAPPING.put('z', "2");
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
	}
	
	public static void solve(Scanner sc) {
		String input = sc.nextLine();
		StringBuilder output = new StringBuilder();
		for (char c : input.toLowerCase().toCharArray()) {
			if (MAPPING.containsKey(c)) output.append(MAPPING.get(c));
			else output.append(c);
		}
		System.out.println(output.toString());
	}
}

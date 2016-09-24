import java.util.Scanner;


public class Brackets {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
		
	}
	
	public static void solve(Scanner sc) {
		
		String brackets = sc.nextLine();
		if (isValid(brackets)) System.out.println("possible");
		else {
			
			boolean possible = false;
			
			for (int i=0;i<brackets.length();i++) {
				char c = brackets.charAt(i);
				
				char[] chars = brackets.toCharArray();
				chars[i] = c == '(' ? ')' : '(';
				
				if (isValid(new String(chars))) {
					possible = true;
					break;
				}
				
			}
			
			if (possible)
				System.out.println("possible");
			else
				System.out.println("impossible");
			
		}
		
	}
	
	public static boolean isValid(String brackets) {
		int depth = 0;
		
		for (char c : brackets.toCharArray()) {
			
			if (depth < 0) return false;
			else if (c == '(') depth++;
			else if (c == ')') depth--;
			
		}
		
		return depth == 0;
	}
	
}

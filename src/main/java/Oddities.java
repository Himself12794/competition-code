import java.util.Scanner;

public class Oddities {

	public static void main(String[] args) {
		try (Scanner SC = new Scanner(System.in)) {
			int count = Integer.valueOf(SC.nextLine().replace("\n", "").replace("\r", ""));
			for (int i = 0; i < count; i++) {
				int current = SC.nextInt();
				System.out.println(current + (current % 2 == 0 ? " is even" : " is odd"));

			}
		}

	}

}

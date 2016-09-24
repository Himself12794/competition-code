import java.util.Scanner;


public class QuickEstimate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
	}
	
	public static void solve(Scanner sc) {
		int n = sc.nextInt();
		for (int i = 0; i < n; ++i) {
			System.out.println(sc.next().length());
		}
	}
	
}

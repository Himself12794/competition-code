import java.math.BigInteger;
import java.util.Scanner;


public class InverseFactorial {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
	}
	
	public static void solve(Scanner sc) {
		BigInteger bigInt = new BigInteger(sc.nextLine());
		System.out.println(estimate(bigInt));
	}
	
	public static int estimate(BigInteger bigInt) {
		
		int n = 1;
		BigInteger start = new BigInteger("1");
		
		while (!start.equals(bigInt)) {
			start = start.multiply(BigInteger.valueOf(n + 1));
			n++;
		}
		
		return n;
	}
	
}

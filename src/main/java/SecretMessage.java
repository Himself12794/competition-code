import java.util.NoSuchElementException;
import java.util.Scanner;


public class SecretMessage {
	
	private static int getNextPerfectSquare(int num) {
		double sqr = Math.sqrt(num);
		return sqr % 1 == 0 ? num : (int) Math.pow(Math.ceil(sqr), 2); 
	}
	
	private static String encode(String phrase) {
		
		int square = getNextPerfectSquare(phrase.length());
		int root = (int) Math.floor(Math.sqrt(square));
		
		char[] phraseChar = phrase.toCharArray();
		char[] encoded = new char[square--];
		

		for (int curr = square; curr >= 0; curr--) {
			encoded[(curr / root) + (root * (root - (curr % root) - 1))] = square - curr < phrase.length() ? phraseChar[square - curr] : ' ';
		}
		
		return String.valueOf(encoded).replace(" ", "");
	}
	
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)){
			int amount = Integer.valueOf(scan.nextLine());
			
			for (int i = 0; i < amount; ++i) {
				System.out.println(encode(scan.nextLine().replace("\n", "").replace("\r", "")));
			}
			
		} catch (NumberFormatException e) {
			System.err.println("Was expecting an integer");
		} catch (NoSuchElementException e) {
			System.err.println("Number of line inputs does not match expected");
		}

	}

}

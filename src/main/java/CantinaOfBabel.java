import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;


public class CantinaOfBabel {

	private static class Speaker {

		private String name;
		private String speaks;
		private final Set<String> understands = new HashSet<String>();

		private Speaker(String info) {

			int curr = 0;
			for (String thing : info.replace("\n", "").replace("\r", "").split(" ")) {
				if (curr == 0) this.name = thing;
				else if (curr == 1) this.speaks = thing;
				else understands.add(thing);
			}

		}
		
		public String getName() {
			return name;
		}
		
		public String getSpeaks() {
			return speaks;
		}
		
		public Set<String> getSpokenLanguages() {
			return understands;
		}
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)){
			int amount = Integer.valueOf(scan.nextLine());

			List<Speaker> speakers = new ArrayList<Speaker>();

			for (int i = 0; i < amount; ++i) {
				String phrase = scan.nextLine();

				speakers.add(new Speaker(phrase));

			}

		} catch (NumberFormatException e) {
			System.err.println("Was expecting an integer");
		} catch (NoSuchElementException e) {
			System.out.println("Number of line inputs does not match expected");
		}

	}

}

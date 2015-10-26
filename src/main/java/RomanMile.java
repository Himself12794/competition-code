import java.util.Scanner;

public class RomanMile {

	private static final Scanner sc = new Scanner(System.in);

	private static final float ROMAN_TO_MILE = 4850.0F / 5280.0F;

	private static final int PACES = 1000;

	public static void main(String[] args) {

		double miles = sc.nextDouble();

		RomanMile conv = new RomanMile(miles);

		System.out.println(conv);

	}

	private final double initial;

	private final double value;

	public RomanMile(double miles) {

		this.initial = miles;

		this.value = miles  * ROMAN_TO_MILE;

	}

	public int getPaces() {

		return (int) (value * PACES);
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {

		return String.format("%.2f Miles is %.2f Roman Miles, or %d paces.", initial, value, getPaces());

	}


}

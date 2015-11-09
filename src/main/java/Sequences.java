import java.util.Scanner;

public class Sequences {

	public static int[] getValues(Scanner sc, int x) {
		
		if (x < 0) return new int[0];
		
		int[] values = new int[x];
		
		for (int i = 0; i < x; i++) values[i] = sc.nextInt();
			
		return values;
	}
	
	public static int getMissingIndex(int[] values) {
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -1) return i;
		}
		
		return -1;		
	}
	
	public static boolean isArithSequence(int...values) {
		
		if (values.length < 3) return true;
		else {
			for (int i = 0; i < values.length - 2; i++) {
				
				int curr = values[i];
				int next = values[i + 1];
				int after = values[i + 2];
				
				if (after - next != next - curr) return false;
				else if (curr > 1000000 || next > 1000000 || after > 1000000) return false;
				else if (curr <= 0) return false;
				
			}
			return true;
		}
		
	}
	
	public static boolean isGeomSequence(int...values) {
		
		if (values.length < 3) return true;
		else {
			for (int i = 0; i < values.length - 2; i++) {
				
				int curr = values[i];
				int next = values[i + 1];
				int after = values[i + 2];
				
				if ((float)after / next != (float)next / curr) return false;
				else if (curr > 1000000 || next > 1000000 || after > 1000000) return false;
				else if (curr <= 0) return false;
				
			}
			return true;
		}
		
	}
	
	public static int analyzeAsGeom(int[] values, int index) {
		
		int missingVal = -1;
		boolean isValid = false;
		
		if (index < 2) {
			
			int diff = values[3] / values[2];
			
			if (index == 0) {
				missingVal = values[1] / diff;
				isValid = isArithSequence(missingVal, values[1], values[2], values[3]);
			} else {
				missingVal = values[0] * diff;
				isValid = isArithSequence(values[0], missingVal, values[2], values[3]);
			}
			
		} else {
			
			int diff = values[1] / values[0];
			
			if (index == 2) {
				missingVal = values[1] * diff;
				isValid = isArithSequence(values[0], values[1], missingVal, values[3]);
			} else {
				missingVal = values[2] * diff;
				isValid = isArithSequence(values[0], values[1], values[2], missingVal);
			}
			
		}
		
		if (isValid) return missingVal;
		else return -1;
		
	}
	
	public static int analyzeAsArith(int[] values, int index) {
		
		int missingVal = -1;
		boolean isValid = false;
		
		if (index < 2) {
			
			int diff = values[3] - values[2];
			
			if (index == 0) {
				missingVal = values[1] - diff;
				isValid = isArithSequence(missingVal, values[1], values[2], values[3]);
			} else {
				missingVal = values[0] + diff;
				isValid = isArithSequence(values[0], missingVal, values[2], values[3]);
			}
			
		} else {
			
			int diff = values[1] - values[0];
			
			if (index == 2) {
				missingVal = values[1] + diff;
				isValid = isArithSequence(values[0], values[1], missingVal, values[3]);
			} else {
				missingVal = values[2] + diff;
				isValid = isArithSequence(values[0], values[1], values[2], missingVal);
			}
			
		}
		
		if (isValid) return missingVal;
		else return -1;
		
	}
	
	public static void analyze(int[] values) {
		
		int missingIndex = getMissingIndex(values);
		int response = analyzeAsArith(values, missingIndex);
		
		if (response == -1) response = analyzeAsGeom(values, missingIndex);
		
		System.out.println(response);
	}
	
	public static boolean isEnd(int[] vals) {
		
		for (int val : vals) {
			if (val != -1) return false;
		}
		
		return true;		
	}
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			int[] vals = getValues(sc, 4);
			
			while (!isEnd(vals)) {
				analyze(vals);
			}
			
		}
		
	}
	
}

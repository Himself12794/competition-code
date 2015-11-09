import java.util.Scanner;

public class Kinfolk {

	public static final String KIN = "kin";
	
	public static final String[] ORDINAL = {"1st", "2nd", "3rd"};
	
	public static final String[] TIMES = {"once", "twice", "thrice"};
	
	public static final int[] ranges = new int[16];
	
	static {
		
		ranges[0] = 0;
		
		for (int i = 1; i < ranges.length; i++) {
			
			int prev = ranges[i - 1];
			
			ranges[i] = prev + (int)Math.pow(2, i);
		}
		
	}
	
	public static int getLevel(int node) {
		
		if (node == 0) return 0;
		
		for (int i = 1; i < ranges.length; i++) {
			int prev = ranges[i - 1];
			int curr = ranges[i];
			
			if (node <= curr && node > prev) return i;
		}
		
		return -1;
	}
	
	public static int findVerticalDifference(int node1, int node2) {
		
		if (node1 < 0 || node2 < 0) return -1;
		
		return Math.abs(getLevel(node2) - getLevel(node1));
	}
	
	public static int findHorizontalDifference(int node1, int node2) {
		
		int l1 = getLevel(node1);
		int l2 = getLevel(node2);
		
		int testNode1 = node1;
		int testNode2 = node2;
		
		if (l1 == -1 || l2 == -1) return -1;
		
		if (l1 < l2) testNode2 = findNthAncestor(node2, l2 - l1);
		else if (l1 > l2) testNode1 = findNthAncestor(node1, l1 - l2);
		
		return testNode1 > testNode2 ? (testNode1 - testNode2) / 2 : (testNode2 - testNode1) / 2;
	}
	
	public static int findNthAncestor(int node, int n) {
		
		if (n == 0) return node;
		if (n < 0) return -1;
		
		int level = getLevel(node);
		int rightValue = ranges[level];
		
		if (level - n < 0) return -1;
		
		int parentNode = node % 2 == 0 ? (node - 2) / 2 : (node - 1) / 2;
		
		return findNthAncestor(parentNode, n - 1);
	}
	
	public static String process(int node1, int node2, boolean gender) {
		
		if (node1 == node2) return "self";
		
		int hDist = findHorizontalDifference(node1, node2);
		int vDist = findVerticalDifference(node1, node2);
		int l1 = getLevel(node1);
		int l2 = getLevel(node2);
		
		//System.out.println("H: " + hDist + ", V: " + vDist + ", L1: " + l1 + ", L2: " + l2);
		//System.out.println("Node1: " + node1 + ", Node2: " + node2);
		
		if (hDist == 0) {
			//System.out.println(l1 < l2 ? findNthAncestor(node2, hDist) : findNthAncestor(node1, hDist));
			
			boolean directAncestorFlag = l2 > l1 ? findNthAncestor(node2, vDist) == node1 : findNthAncestor(node1, vDist) == node2;
			String relation;
			
			if (directAncestorFlag) {
				
				relation = l1 < l2 ? "child" : "parent";
					
			} else {
				relation = l1 > l2 ? (gender ? "uncle" : "aunt") : (gender ? "nephew" : "niece");
			}
			

			
			if (vDist < 5) {
				
				if (vDist > 1) {
					
					if (vDist >= 2) relation = "grand" + relation;
					
					if (vDist > 2){
						
						StringBuilder greats = new StringBuilder();
						for (int i = 0; i < vDist - 2; i++) {
							greats.append("great-");
						}
						
						relation = greats.toString() + relation;
					}
					
				}
				
			} else {
				return KIN;
			}
			
			return relation;
		} else {
			
			if (hDist > 3 || vDist > 3) return KIN;
			
			return ORDINAL[vDist - 1] + " cousin " + TIMES[hDist - 1] + " removed";
		}
		
		//return KIN;
	}
	
	public static int[] getData(Scanner sc) {
		
		int[] data = new int[3];
		
		data[0] = sc.nextInt();
		data[1] = sc.nextInt();
		data[2] = sc.next().equals("M") ? 1 : 0;
		
		return data;
	}
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			int[] data = getData(sc);
			
			while (data[0] != -1) {
				
				System.out.println(process(data[0], data[1], data[2] == 1));
				data = getData(sc);
			}
			
		}
		
		//System.out.println(process(1, 5, true));
		//System.out.println(process(1, 11, false));
		//System.out.println(process(0, 8, false));
		//System.out.println(process(5, 7, true));
		//System.out.println(process(0, 32767, false));
		
	}
	
}

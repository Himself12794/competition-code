import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;


public class NinePacks {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
		
	}
	
	public static void solve(Scanner sc) {
		
		Map<Integer, Integer> hCounts = new HashMap<>();
		Map<Integer, Integer> bCounts = new HashMap<>();
		
		int hC = sc.nextInt();
		for (int i=0;i<hC;++i) iOrIn(hCounts, sc.nextInt());
		
		int bC = sc.nextInt();
		for (int i=0;i<bC;++i) iOrIn(bCounts, sc.nextInt());
		
		
		
	}
	
	public static void iOrIn(Map<Integer, Integer> map, int value) {
		
		if (map.containsKey(value)) map.put(value, map.get(value)+1);
		else map.put(value, 1);
		
	}
	
	public static int minKey(Map<Integer, Integer> map) {
		return map.keySet().stream().reduce(0, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer c, Integer v) {
				return c>v?c:v;
			}
			
		});
	}
	
}

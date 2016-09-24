import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BigTruck {

	public static class Graph {
		
		public final Node[] nodes;
		public final Set<Edge> edges = new HashSet<>();
		
		public Graph(int size) {
			nodes = new Node[size];
		}
		
		public void addNode(Node node) {
			nodes[node.id] = node;
			edges.addAll(node.edges);
		}
		
		public Node getNode(int node) {
			return nodes[node];
		}
		
	}
	
	public static class Node {
		public final int id;
		public final int items;
		public final Set<Edge> edges = new HashSet<>();
		
		public Node(int id, int items) {
			this.id = id;
			this.items = items;
		}
		
		public int hashCode() {
			return id;
		}
		
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
	}
	
	public static class Edge {
		
		public final Node start;
		public final Node end;
		public final int length;
		public Edge(Node start, Node end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
			start.edges.add(this);
			end.edges.add(this);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((end == null) ? 0 : end.hashCode());
			result = prime * result + length;
			result = prime * result + ((start == null) ? 0 : start.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
		
	}

	public static class Item {
		public static final Item HIGHEST = new Item(Double.POSITIVE_INFINITY, 0);
		public final double length;
		public final int items;
		public Item() {
			this(0,0);
		}
		public Item(double l, int i) {
			length = l;
			items = i;
		}
		public Item add(Item other) {
			return new Item(this.length+other.length,this.items+other.items);
		}
		public String toString() {
			return String.format("%d %d", length, items);
		}
	}
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			solve(sc);
		}
	}
	
	public static void solve(Scanner sc) {
		Graph graph = parseInput(sc);
		
		int n = graph.nodes.length;
		Item[][] distances = new Item[n][n];
		
		for (int i=0;i<n;++i) {
			for (int k=0;k<n;++k) {
				distances[i][k] = Item.HIGHEST;
			}
		}
		
		for (int i=0;i<n;++i) {
			distances[i][i] = new Item();
		}
		
		for (Edge edge : graph.edges) {
			distances[edge.start.id][edge.end.id] = new Item(edge.length, edge.end.items);
		}
		
		for (int k=0;k<n;++k) {
			for (int i=0;i<n;++i) {
				for (int j=0;j<n;++j) {
					
					Item total = distances[i][k].add(distances[k][j]);
					
					if (distances[i][j].length == total.length && distances[i][j].items < total.items) 
						distances[i][j] = total;
					else if (distances[i][j].length > total.length) distances[i][j] = total;
					
				}
			}
		}
		Item solution = distances[0][n-1];
		if (solution.length == Double.POSITIVE_INFINITY)
			System.out.println("impossible");
		else
			System.out.println(String.format("%.0f %d", solution.length, graph.getNode(0).items+solution.items));
	}

	public static Graph parseInput(Scanner sc) {
		
		int locationsC = sc.nextInt();
		Graph graph = new Graph(locationsC);
		
		for (int i=0;i<locationsC;++i) {
			int items = sc.nextInt();
			Node node = new Node(i, items);
			graph.addNode(node);
		}
		
		int r,d;
		Node a,b;
		
		r = sc.nextInt();
		for (int i=0;i<r;++i) {
			a = graph.getNode(sc.nextInt()-1);
			b = graph.getNode(sc.nextInt()-1);
			d = sc.nextInt();
			
			graph.edges.add(new Edge(a, b, d));
			
		}
		
		
		return graph;
	}
	
}

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class DijkstraTree {

	ArrayList<nodeList> nodeList = new ArrayList<nodeList>();
    //atributo
	public DijkstraTree(nodeList[] nodes) {
		for (nodeList v : nodes) {
			nodeList.add(v);}
	}
    
    //class arista
	class Edge {
		public final nodeList finish;
		public final double weight;

		public Edge(Node2 finish, double weight) {
			finish = this.finish;
			weight = this.weight;
		}
	}
    
    //class lista de vertices
	class nodeList implements Comparable<nodeList> {

		public final String value;
                public nodeList parent;
		public Arista[] adj;

		public nodeList(String val) {
			value = val;
		}

		public String toString() {
			return value;
		}
        
		public int compareTo(nodeList comp) {
			return Double.compare(distance.get(this), distance.get(comp));
		}
	}
    
	HashMap<nodeList, Double> distance = new HashMap<nodeList, Double>();

	public HashMap<nodeList, Double> computePaths(nodeList source) {

		for (nodeList v : nodeList) {
			distance.put(v, Double.POSITIVE_INFINITY);}

		distance.put(source, 0.0);
		PriorityQueue<nodeList> queue = new PriorityQueue<nodeList>();
		queue.add(source);

		while (!queue.isEmpty()) {
			nodeList a = queue.poll();
			for (Edge edges : a.adj) {
				nodeList v = edges.finish;
				double weight = edges.weight;
				double dist = distance.get(a) + weight;
				if (dist < distance.get(v)) {
					queue.remove(v);
					distance.put(v, dist);
					v.parent = a;
					queue.add(v);
				}
			}
		}
		return distance;
	}
}

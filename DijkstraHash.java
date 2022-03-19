import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class DijkstraHash {
	ArrayList<nodeList> nodeList = new ArrayList<nodeList>();
    //atributos
	public DijkstraHash (nodeList[] nodes) {
		for (nodeList v : nodes) {
			nodeList.add(v);}
	}
	static HashMap<nodeList, Double> distance = new HashMap<nodeList, Double>();

	public HashMap<nodeList, Double> Dijkstra(nodeList source) {
		for (nodeList node2 : nodeList) {
			distance.put(node2, Double.POSITIVE_INFINITY);}
		distance.put(source, 0.0);
		PriorityQueue<nodeList> queue = new PriorityQueue<nodeList>();
		queue.add(source);
		while (!queue.isEmpty()) {
			nodeList a = queue.poll();
			for (Edge e : a.adj) {
				nodeList v = e.finish;
				double weight = e.weight;
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
//class arista
class Edge {
	public final nodeList finish;
	public final double weight;

	public Edge(nodeList finish, double weight) {
		finish = this.finish;
		weight = this.weight;
	}
	public Edge(nodeList node, int weight){
		finish = this.node;
		weight = this.weight;
	}
}
    
//class lista de vertices
class nodeList implements Comparable<nodeList> {

	public final String value;
        public nodeList parent;
	public Edge[] adj;

	public nodeList(String val) {
		value = val;
	}

	public String toString() {
		return value;
	}
        
	public int compareTo(nodeList comp) {
		return Double.compare(DijkstraHash.distance.get(this), DijkstraHash.distance.get(comp));
	}
}

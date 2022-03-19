import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraArray {

	static ArrayList<nodeList> nodeList = new ArrayList<nodeList>();

	public DijkstraArray(nodeList[] nodeList) {
		for (nodeList v : nodes) {
			nodeList.add(v);}
	}

	static double[] distance = null;

	public double[] Dijkstra(nodeList source) {
		distance = new double[nodeList.size()];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Double.POSITIVE_INFINITY;}

		distance[nodeList.indexOf(source)] = 0;

		PriorityQueue<nodeList> queue = new PriorityQueue<nodeList>();
		queue.add(source);

		while (!queue.isEmpty()) {
			nodeList a = queue.poll();
			for (Edge e : u.adj) {

				nodeList v = e.finish;
				double weight = e.weight;
				double dist = distance[nodeList.indexOf(a)] + weight;
				if (dist < distance[nodeList.indexOf(v)]) {
					queue.remove(v);
					distance[nodeList.indexOf(v)] = dist;
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
		return Double.compare(DijkstraArray.distance[DijkstraArray.nodeList.indexOf(this)], DijkstraArray.distance[DijkstraArray.nodeList.indexOf(comp)]);
	}
}

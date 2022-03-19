import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class DijkstraHash {
	ArrayList<Node> nodeList = new ArrayList<Node>();
    //atributos
	public DijkstraHash (Node[] nodes) {
		for (Node v : nodes) {
			listNodes.add(v);}
	}
}
//class arista
class Edge {
	public final nodeList finish;
	public final double weight;

	public Edge(Node2 finish, double weight) {
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

	

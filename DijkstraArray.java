
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

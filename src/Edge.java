
public class Edge {

	public int weight;
	public cityNode node;
	public int h1; // aerial distance
	public int h2; // walking distance

	// constructors
	public Edge() {

	}

	public Edge(int weight, cityNode node, int h1, int h2) {
		this.weight = weight;
		this.node = node;
		this.h1 = h1;
		this.h2 = h2;
	}

	@Override
	public String toString() {
		return "Edge [h1=" + h1 + ", h2=" + h2 + ", node=" + node + ", weight=" + weight + "]";
	}
}

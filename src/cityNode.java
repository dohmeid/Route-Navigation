import java.util.*;

public class cityNode implements Comparable<cityNode> {

	// each city has these attributes
	private int cityId;
	private String cityName;
	private boolean visited;
	private List<Edge> neighbours = new ArrayList<>(); // cities connected with (neighbours)
	public cityNode parent = null; // ?
	public int f = Integer.MAX_VALUE; // Evaluation function
	public int g = Integer.MAX_VALUE; // Car Distance

	// empty constructor
	public cityNode() {
		this.visited = false;
	}

	// constructor
	public cityNode(String cityName, int cityId, boolean visited, List<Edge> neighbours) {
		this.cityName = cityName;
		this.cityId = cityId;
		this.visited = visited;
		this.neighbours = neighbours;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getA_neighbours() {
		return neighbours;
	}

	public void setA_neighbours(List<Edge> a_neighbours) {
		this.neighbours = a_neighbours;
	}

	public void addBranch(int weight, int h1, int h2, cityNode node) {
		Edge newEdge = new Edge(weight, node, h1, h2);
		neighbours.add(newEdge);
	}

	@Override
	public int compareTo(cityNode n) {
		return Integer.compare(this.f, n.f);
	}

	@Override
	public String toString() {
		return "cityId=" + cityId + ", cityName=" + cityName + ", visited=" + "cityNode [a_neighbours="
				+ neighbours.toString() + visited + "]";
	}

}

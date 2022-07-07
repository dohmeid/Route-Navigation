import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

public class Main {
	public static PriorityQueue<cityNode> closedList = new PriorityQueue<>();
	public static List<cityNode> cities = new ArrayList<>();
	public static ArrayList<Integer> visited_nodes = new ArrayList<Integer>();
	public static ArrayList<Integer> path = new ArrayList<Integer>();
	public static int path_cost;
	public static int expanded_nodes_counter;
	public static ArrayList<Integer> walk_as_h = new ArrayList<Integer>();

	public static void main(String arg[]) {

		readFile();
		System.out.println("Reading the file has been done Successfully");
		System.out.println("*******************************************************");

		// for (int i = 0; i < cities.size(); i++)
		// System.out.println("city" + i + " " + cities.get(i).getCityName() + ": " +
		// cities.get(i).toString());

		System.out.print("Enter goal node: ");
		Scanner input = new Scanner(System.in);
		String goal = input.nextLine();
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getCityName().compareTo(goal) == 0) { // System.out.println("city" + i + ": " +
																	// cities.get(i).getCityName());
				// cityNode res = aStar(cities.get(0), cities.get(i),1);
				cityNode res = aStar1(cities.get(0), cities.get(i));
				printPath(res, 1, 0);
				System.out.println(" number of expanded nodes:" + expanded_nodes_counter);
				break;
			}
		}
		System.out.println("*******************************************************");
		/*
		 * // for visited nodes
		 * System.out.println("*******************************************************")
		 * ; System.out.println("Visited nodes by indices: "); for (int i = 0; i <
		 * visited_nodes.size(); i++) System.out.print(visited_nodes.get(i) + "-->");
		 * 
		 * System.out.println("\nVisited nodes by names: "); for (int i = 0; i <
		 * visited_nodes.size(); i++) { int id = visited_nodes.get(i);
		 * System.out.print(cities.get(id - 1).getCityName() + "-->"); }
		 * 
		 * // for path System.out.println("********************");
		 * System.out.println("Path by indices: "); for (int i = 0; i < path.size();
		 * i++) System.out.print(path.get(i) + "-->");
		 * 
		 * System.out.println("\nPath by names: "); for (int i = 0; i < path.size();
		 * i++) { int id = path.get(i); System.out.print(cities.get(id -
		 * 1).getCityName() + "-->"); }
		 */
		input.close();
	}

	Main() {
		this.path_cost = 0;
		this.expanded_nodes_counter = 0;
		this.visited_nodes.clear();
		this.path.clear();
		this.cities.clear();
		this.closedList.clear();
		this.walk_as_h.clear();
	}

	// reading the data from a file called 'cities.txt'
	public static void readFile() {
		try {
			int counter = 0;
			File myfile = new File("cities.txt");
			Scanner myReader = new Scanner(myfile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine(); // System.out.println(data);
				counter++;
				prepareData(counter, data);
			}
			myReader.close();
		} catch (FileNotFoundException e) { // catch an exception if the file not found
			System.out.println("An ERROR occurred");
			e.printStackTrace();
		}
	}

	// to fill in each city in a cityNode in a static ArrayList called 'cities'
	public static void prepareData(int counter, String line) {
		cityNode city = new cityNode();
		String[] cityInfo = line.split(":");
		city.setCityName(cityInfo[0]);
		city.setCityId(counter);
		String[] adjacent = cityInfo[1].split(",");
		for (int i = 0; i < adjacent.length; i++) {
			cityNode adjcity = new cityNode();
			adjcity.setCityId(i + 1);
			String[] cityAttributes = adjacent[i].split("-");
			int carDist = Integer.parseInt(cityAttributes[0]);
			int aerial = Integer.parseInt(cityAttributes[1]);
			int walkingDist;
			if (carDist != 0)
				walkingDist = (carDist + aerial) / 2;
			else
				walkingDist = 0;
			city.addBranch(carDist, aerial, walkingDist, adjcity);
		}
		cities.add(city);
	}

	public static cityNode DFS(cityNode start, cityNode goal) {

		// System.out.println("Goal is: " + goal.getCityName() +", Goal ID is: "+
		// goal.getCityId());
		Stack<cityNode> stack = new Stack<cityNode>();
		stack.add(start);
		System.out.println("Visited nodes: ");
		while (!stack.isEmpty()) {
			int element = stack.pop().getCityId();

			// if goal node = start node
			if (cities.get(element - 1).getCityId() == goal.getCityId()) {
				System.out.println("goal is " + goal.getCityName() + " found");
				return cities.get(element - 1);
			}

			if (!cities.get(element - 1).isVisited()) {
				System.out.print(cities.get(element - 1).getCityId() + "-->");
				System.out.print(cities.get(element - 1).getCityName() + "-->");
				visited_nodes.add(cities.get(element - 1).getCityId());
				cities.get(element - 1).setVisited(true);
			}

			List<cityNode> neighbours = new ArrayList<>();
			for (int i = 0; i < cities.get(element - 1).getA_neighbours().size(); i++) {
				if (cities.get(element - 1).getA_neighbours().get(i).weight != 0) {
					neighbours.add(cities.get(element - 1).getA_neighbours().get(i).node);
				}
			}

			for (int i = 0; i < neighbours.size(); i++) {
				int index = 0;
				cityNode n = neighbours.get(i);
				if (cities.get(n.getCityId() - 1) != null && !cities.get(n.getCityId() - 1).isVisited()) {
					index = n.getCityId() - 1;
					cities.get(n.getCityId() - 1).parent = cities.get(element - 1);
					stack.add(cities.get(index));
				}
			}
		}
		return null;
	}

	public static cityNode BFS(cityNode start, cityNode goal) {

		Queue<cityNode> q = new LinkedList<cityNode>();
		start.parent = null;
		q.add(start);
		start.setVisited(true);
		System.out.println("Visited nodes: ");
		while (!q.isEmpty()) {
			int current = q.poll().getCityId(); // pull out the first vertex in the queue
			System.out.print(cities.get(current - 1).getCityName() + " -->");

			// if the vertex pulled is the goal, break loop
			if (cities.get(current - 1).getCityId() == goal.getCityId()) {
				System.out.println("goal found");
				return cities.get(current - 1);
			} else {
				visited_nodes.add(cities.get(current - 1).getCityId());

			}
			List<cityNode> neighbours = new ArrayList<>();
			for (int i = 0; i < cities.get(current - 1).getA_neighbours().size(); i++) {
				if (cities.get(current - 1).getA_neighbours().get(i).weight != 0)
					neighbours.add(cities.get(current - 1).getA_neighbours().get(i).node);
			}

			for (int i = 0; i < neighbours.size(); i++) {
				cityNode n = neighbours.get(i);
				if (!cities.get(n.getCityId() - 1).isVisited()) { // if neighbour hasn't been visited
					// System.out.println("neighbours: " + n.getCityName());
					cities.get(n.getCityId() - 1).setVisited(true);
					q.add(cities.get(n.getCityId() - 1)); // add to the queue
					cities.get(n.getCityId() - 1).parent = cities.get(current - 1);
				}
			}
		}
		return null;
	}

	public static cityNode aStar1(cityNode start, cityNode target) {
		expanded_nodes_counter = 0;
		PriorityQueue<cityNode> openList = new PriorityQueue<>();
		start.g = 0;
		start.f = start.g + start.getA_neighbours().get(target.getCityId() - 1).h1;
		openList.add(start);
		// System.out.println("Visited nodes");
		while (!openList.isEmpty()) {
			cityNode expanded_node = openList.peek();
			expanded_nodes_counter++;
			int element = expanded_node.getCityId();
			// System.out.print(expanded_node.getCityId()+"-->"+expanded_node.getCityName());
			if (expanded_node.getCityId() == target.getCityId()) {
				// System.out.print("goal found\n");
				return expanded_node;
			}

			List<Edge> neighbours = new ArrayList<>();
			for (int i = 0; i < cities.get(element - 1).getA_neighbours().size(); i++) {// to get neighbours of the
																						// expanded node
				if (cities.get(element - 1).getA_neighbours().get(i).weight != 0)
					neighbours.add(cities.get(element - 1).getA_neighbours().get(i));
			}

			for (int i = 0; i < neighbours.size(); i++) {
				cityNode neighbour_node = neighbours.get(i).node;
				int h = 0;
				int totalWeight = 0; // totalWeight = expanded_node.g + neighbours.get(i).weight;
				// if flag=1 then do A* using h1 (geth1 function is used) //h1=aerial distance
				// and cost=walking distance
				h = geth1(neighbour_node, target);
				totalWeight = expanded_node.g + neighbours.get(i).h2; // h2 is the walking distance
				// expanded_node.g
				// neighbours.get(i).h2
				// System.out.println(expanded_node.getCityId()+"ggg"+ neighbours.get(i).h2);
				// System.out.println("\nh2 "+ neighbours.get(i).h2 +"weight" +
				// neighbours.get(i).weight);
				// System.out.println("g "+ expanded_node.g );

				if (!openList.contains(neighbour_node) && !closedList.contains(neighbour_node)) {
					neighbour_node.parent = expanded_node;
					neighbour_node.g = totalWeight;
					neighbour_node.f = neighbour_node.g + h;
					openList.add(neighbour_node);
				} else {
					if (totalWeight < neighbour_node.g) {
						neighbour_node.parent = expanded_node;
						neighbour_node.g = totalWeight;
						neighbour_node.f = neighbour_node.g + h;
						if (closedList.contains(neighbour_node)) {
							closedList.remove(neighbour_node);
							openList.add(neighbour_node);
						}
					}
				}

			}

			openList.remove(expanded_node);
			closedList.add(expanded_node);
		}
		return null;
	}

	public static cityNode aStar2(cityNode start, cityNode target) {

		// ArrayList<Integer> walk_as_h = new ArrayList<Integer>();
		PriorityQueue<cityNode> openL = new PriorityQueue<>();
		PriorityQueue<cityNode> closedL = new PriorityQueue<>();
		for (int i = 0; i < cities.size(); i++) {
			cityNode res = aStar1(cities.get(i), target);
			printPath(res, 0, 0);
			walk_as_h.add(path_cost);
		}
		expanded_nodes_counter = 0;
		start.g = 0;
		start.f = start.g + walk_as_h.get(0);
		openL.add(start);
		// System.out.println("Visited nodes");
		while (!openL.isEmpty()) {
			cityNode expanded_node = openL.peek();
			expanded_nodes_counter++;
			int element = expanded_node.getCityId();
			// System.out.print(expanded_node.getCityId()+"-->"+expanded_node.getCityName());
			if (expanded_node.getCityId() == target.getCityId()) {
				// System.out.print("goal found\n");
				return expanded_node;
			}

			List<Edge> neighbours = new ArrayList<>();
			for (int i = 0; i < cities.get(element - 1).getA_neighbours().size(); i++) {// to get neighbours of the
																						// expanded node
				if (cities.get(element - 1).getA_neighbours().get(i).weight != 0)
					neighbours.add(cities.get(element - 1).getA_neighbours().get(i));
			}
			for (int i = 0; i < neighbours.size(); i++) {
				cityNode neighbour_node = neighbours.get(i).node;
				int h = 0;
				int totalWeight = 0;// totalWeight = expanded_node.g + neighbours.get(i).weight;
				// do A* using h2 (geth2 function is used) //h2=aerial distance and cost=walking
				// distance

				h = geth2(neighbour_node, target);
				// System.out.println(h);
				totalWeight = expanded_node.g + neighbours.get(i).weight; // h2 is the walking distance

				if (!openL.contains(neighbour_node) && !closedList.contains(neighbour_node)) {
					neighbour_node.parent = expanded_node;
					neighbour_node.g = totalWeight;
					neighbour_node.f = neighbour_node.g + h;
					openL.add(neighbour_node);
				} else {
					if (totalWeight < neighbour_node.g) {
						neighbour_node.parent = expanded_node;
						neighbour_node.g = totalWeight;
						neighbour_node.f = neighbour_node.g + h;
						if (closedList.contains(neighbour_node)) {
							closedList.remove(neighbour_node);
							openL.add(neighbour_node);
						}
					}
				}
			}
			openL.remove(expanded_node);
			closedList.add(expanded_node);
		}
		return null;
	}

	public static int geth1(cityNode node, cityNode target) {
		int h1 = 0;
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getCityId() == node.getCityId()) {
				for (int j = 0; j < cities.get(i).getA_neighbours().size(); j++) {
					if (cities.get(i).getA_neighbours().get(j).node.getCityId() == target.getCityId())
						h1 = cities.get(i).getA_neighbours().get(j).h1;
				}
			}
		}
		return h1;
	}

	public static int geth2(cityNode node, cityNode target) {
		int h2 = 0;
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getCityId() == node.getCityId()) {
				for (int j = 0; j < cities.get(i).getA_neighbours().size(); j++) {
					if (cities.get(i).getA_neighbours().get(j).node.getCityId() == target.getCityId())
						h2 = walk_as_h.get(cities.get(i).getCityId() - 1); // h2 =
																			// cities.get(i).getA_neighbours().get(j).h2;

				}
			}
		}
		return h2;
	}

	public static void printPath(cityNode target, int costflag, int pathflag) {

		cityNode n = target;
		if (n == null)
			return;
		List<Integer> ids = new ArrayList<>();
		while (n.parent != null) {
			ids.add(n.getCityId());
			n = n.parent;
		}
		ids.add(n.getCityId());
		Collections.reverse(ids);
		if (pathflag == 1) { // pathflag=1 for DFS,BFS,A*1 and pathflag=anything for A*2
			System.out.println("Path:");
			for (int id : ids) {
				System.out.print(id + "-->");
				path.add(id);
				System.out.print(cities.get(id - 1).getCityName() + "-->");
			}
			System.out.println("");
		}

		getCost(ids, costflag, pathflag); // costflag=1 for DFS,BFS,A*2 and costflag=anything for A*1

	}

	public static void getCost(List<Integer> ids, int flag, int f) {
		List<Edge> neighbours = new ArrayList<>();
		int cost = 0;
		for (int i = 0; i < ids.size(); i++) {
			for (int j = 0; j < cities.get(ids.get(i) - 1).getA_neighbours().size(); j++) {
				if (cities.get(ids.get(i) - 1).getA_neighbours().get(j).weight != 0)
					neighbours.add(cities.get(ids.get(i) - 1).getA_neighbours().get(j));
			}
			if (flag == 1) { // for DFS,BFS,A*2
				for (int k = 0; k < neighbours.size(); k++) {
					if (ids.contains(neighbours.get(k).node.getCityId()))
						cost = cost + neighbours.get(k).weight;
				}
			} else { // for A*1
				for (int k = 0; k < neighbours.size(); k++) {
					if (ids.contains(neighbours.get(k).node.getCityId()))
						cost = cost + neighbours.get(k).h2;
				}
			}
			neighbours.clear();
		}
		if (f != 0)
			System.out.println("Total Cost: " + cost / 2);
		path_cost = cost / 2;
	}

}
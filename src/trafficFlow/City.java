package trafficFlow;

import dataStructuresGenerics.Matrix;
import dataStructuresGenerics.Graph;
import dataStructuresGenerics.LinkedList;
import dataStructuresGenerics.StackLl;

/*
 * Antonin Jousson
 * 
 * Class that represents a city. 
 * A city is composed of crossroads that are stored in a matrix data structure.
 * A city also has a graph in order to be able to calculate the shortest path between two crossroads.
 */

public class City {

	private Matrix Crossroads;
	private Graph CityGraph;
	private String name;

	/*
	 * City Constructor : All the crossroads share the same configuration. The
	 * matrix datastructure holds all the crossroads. The CityGraph is a graph
	 * with the crossroads names as nodes and the streets as edges. The weights
	 * are the street traveling times between two nodes (i.e between two
	 * crossroads)
	 * 
	 */
	public City(String cityname, int city_width, int city_height) {

		this.name = cityname;
		this.Crossroads = new Matrix(city_height, city_width);
		this.CityGraph = new Graph();
	}

	// Method to set up the nodes of the city graph
	public void setupNodes() {
		for (int i = 0; i < Crossroads.rows_size(); i++) {
			for (int j = 0; j < Crossroads.columns_size(); j++) {
				CrossRoad currentCrossRoad = (CrossRoad) Crossroads.get(i, j);
				CityGraph.addNode(currentCrossRoad.getName());
			}
		}
	}

	// Method to set up the edges between nodes of the city graph
	public void setupEdges() {
		for (int i = 0; i < Crossroads.rows_size(); i++) {
			for (int j = 0; j < Crossroads.columns_size(); j++) {
				CrossRoad currentCrossRoad = (CrossRoad) Crossroads.get(i, j);

				// add edge to East crossroad if it exists
				if (j + 1 < Crossroads.columns_size()) {
					CrossRoad EastCrossRoad = (CrossRoad) Crossroads.get(i, j + 1);
					int weight = currentCrossRoad.getStreet("East").getTravelingTime();
					CityGraph.addEdge(currentCrossRoad.getName(), EastCrossRoad.getName(), weight, "East");
				}

				// add edge to West crossroad if it exists
				if (j - 1 >= 0) {
					CrossRoad WestCrossRoad = (CrossRoad) Crossroads.get(i, j - 1);
					int weight = currentCrossRoad.getStreet("West").getTravelingTime();
					CityGraph.addEdge(currentCrossRoad.getName(), WestCrossRoad.getName(), weight, "West");
				}

				// add edge to South crossroad if it exists
				if (i + 1 < Crossroads.rows_size()) {
					CrossRoad SouthCrossRoad = (CrossRoad) Crossroads.get(i + 1, j);
					int weight = currentCrossRoad.getStreet("South").getTravelingTime();
					CityGraph.addEdge(currentCrossRoad.getName(), SouthCrossRoad.getName(), weight, "South");
				}

				// add edge to North crossroad if it exists
				if (i - 1 >= 0) {
					CrossRoad NorthCrossRoad = (CrossRoad) Crossroads.get(i - 1, j);
					int weight = currentCrossRoad.getStreet("North").getTravelingTime();
					CityGraph.addEdge(currentCrossRoad.getName(), NorthCrossRoad.getName(), weight, "North");
				}
			}
		}
	}

	// Set up the city graph
	public void setupCityGraph() {
		this.setupNodes();
		this.setupEdges();
	}

	// Set up a new crossroad
	public void setupCrossroad(int i, int j, String crossRoadName, int trafficlightFlowNorth, int trafficlightFlowSouth,
			int trafficlightFlowWest, int trafficlightFlowEast, int trafficlightCapacityNorth,
			int trafficlightCapacitySouth, int trafficlightCapacityWest, int trafficlightCapacityEast,
			int streetCapacityNorth, int streetCapacitySouth, int streetCapacityWest, int streetCapacityEast,
			int streetTravelingTimeNorth, int streetTravelingTimeSouth, int streetTravelingTimeWest,
			int streetTravelingTimeEast) {

		// Create a new crossroad
		CrossRoad aCrossRoad = new CrossRoad(crossRoadName, trafficlightFlowNorth, trafficlightFlowSouth,
				trafficlightFlowWest, trafficlightFlowEast, trafficlightCapacityNorth, trafficlightCapacitySouth,
				trafficlightCapacityWest, trafficlightCapacityEast, streetCapacityNorth, streetCapacitySouth,
				streetCapacityWest, streetCapacityEast, streetTravelingTimeNorth, streetTravelingTimeSouth,
				streetTravelingTimeWest, streetTravelingTimeEast);

		// Add the crossroad to the crossroad matrix
		Crossroads.set(i, j, aCrossRoad);
	}

	// Method that returns the name of the city
	public String getName() {
		return this.name;
	}

	/*
	 * Method that returns the size of the city (i.e the crossroads matrix size)
	 */
	public int size() {
		return this.Crossroads.size();
	}

	// Method to add a vehicle to a given side of a given crossroad
	public void addVehicle(String crossroadname, String side, Vehicle vehicle) {
		for (int i = 0; i < Crossroads.rows_size(); i++) {
			for (int j = 0; j < Crossroads.columns_size(); j++) {
				CrossRoad currentCrossRoad = (CrossRoad) Crossroads.get(i, j);
				if (currentCrossRoad.getName().equals(crossroadname)) {
					currentCrossRoad.addVehicle(side, vehicle);
					vehicle.addLocationToRoute(crossroadname);
				}
			}
		}
	}

	// Method to iterate over all crossroads of the city
	public void iterate() {
		for (int i = 0; i < Crossroads.rows_size(); i++) {
			for (int j = 0; j < Crossroads.columns_size(); j++) {

				CrossRoad currentCrossRoad = (CrossRoad) Crossroads.get(i, j);

				/*
				 * Move vehicles that reached the end of the East street to East
				 * crossroad if it exists
				 * 
				 */
				if (j + 1 < this.Crossroads.columns_size()
						&& currentCrossRoad.getStreet("East").getvehicles().size() != 0) {

					/*
					 * Get the time remaining in the street for the first
					 * vehicle in the street
					 */
					int remainingTimeEast = currentCrossRoad.getStreet("East").getvehicles().getLast().getTime();

					/*
					 * If the time remaining is 0, remove it from the street and
					 * add it to the next crossroad, then repeat the process for
					 * the next vehicle in the street until there is no more
					 * vehicle that reached the end of the street ( i.e that
					 * have a remaining time in the street equals to 0)
					 */
					while (remainingTimeEast == 0) {
						Vehicle temp_car_east = currentCrossRoad.getStreet("East").getvehicles().getLast().getCar();
						CrossRoad eastCrossRoad = (CrossRoad) Crossroads.get(i, j + 1);

						if (eastCrossRoad.getTrafficlight("West").size() < eastCrossRoad.getTrafficlight("West")
								.getcapacity()) {
							eastCrossRoad.addVehicle("West", temp_car_east);
							temp_car_east.addLocationToRoute(eastCrossRoad.getName());
							currentCrossRoad.getStreet("East").getvehicles().removeLast();

							if (currentCrossRoad.getStreet("East").getvehicles().size() != 0) {
								remainingTimeEast = currentCrossRoad.getStreet("East").getvehicles().getLast()
										.getTime();
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}

				/*
				 * Move vehicles that reached the end of the West street to West
				 * crossroad if it exists
				 */
				else if (j - 1 >= 0 && currentCrossRoad.getStreet("West").getvehicles().size() != 0) {

					int remainingTimeWest = currentCrossRoad.getStreet("West").getvehicles().getLast().getTime();

					while (remainingTimeWest == 0) {

						Vehicle temp_car_west = currentCrossRoad.getStreet("West").getvehicles().getLast().getCar();
						CrossRoad westCrossRoad = (CrossRoad) Crossroads.get(i, j - 1);

						if (westCrossRoad.getTrafficlight("East").size() < westCrossRoad.getTrafficlight("East")
								.getcapacity()) {
							westCrossRoad.addVehicle("East", temp_car_west);
							temp_car_west.addLocationToRoute(westCrossRoad.getName());
							currentCrossRoad.getStreet("West").getvehicles().removeLast();

							if (currentCrossRoad.getStreet("West").getvehicles().size() != 0) {
								remainingTimeWest = currentCrossRoad.getStreet("West").getvehicles().getLast()
										.getTime();
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}

				/*
				 * Move vehicles that reached the end of the South street to
				 * South crossroad if it exists
				 */
				else if (i + 1 < this.Crossroads.rows_size()
						&& currentCrossRoad.getStreet("South").getvehicles().size() != 0) {

					int remainingTimeSouth = currentCrossRoad.getStreet("South").getvehicles().getLast().getTime();

					while (remainingTimeSouth == 0) {
						Vehicle temp_car_south = currentCrossRoad.getStreet("South").getvehicles().getLast().getCar();
						CrossRoad southCrossRoad = (CrossRoad) Crossroads.get(i + 1, j);
						if (southCrossRoad.getTrafficlight("North").size() < southCrossRoad.getTrafficlight("North")
								.getcapacity()) {
							southCrossRoad.addVehicle("North", temp_car_south);
							temp_car_south.addLocationToRoute(southCrossRoad.getName());
							currentCrossRoad.getStreet("South").getvehicles().removeLast();

							if (currentCrossRoad.getStreet("South").getvehicles().size() != 0) {
								remainingTimeSouth = currentCrossRoad.getStreet("South").getvehicles().getLast()
										.getTime();
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}

				/*
				 * Move vehicles that reached the end of the Nort street to
				 * North crossroad if it exists
				 */
				else if (i - 1 >= 0 && currentCrossRoad.getStreet("North").getvehicles().size() != 0) {

					int remainingTimeNorth = currentCrossRoad.getStreet("North").getvehicles().getLast().getTime();

					while (remainingTimeNorth == 0) {
						Vehicle temp_car_north = currentCrossRoad.getStreet("North").getvehicles().getLast().getCar();
						CrossRoad northCrossRoad = (CrossRoad) Crossroads.get(i - 1, j);
						if (northCrossRoad.getTrafficlight("South").size() < northCrossRoad.getTrafficlight("South")
								.getcapacity()) {
							northCrossRoad.addVehicle("South", temp_car_north);
							temp_car_north.addLocationToRoute(northCrossRoad.getName());
							currentCrossRoad.getStreet("North").getvehicles().removeLast();

							if (currentCrossRoad.getStreet("North").getvehicles().size() != 0) {
								remainingTimeNorth = currentCrossRoad.getStreet("North").getvehicles().getLast()
										.getTime();
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}

				// We call the iterate loop on this crossroad
				currentCrossRoad.iterate();
			}
		}

	}

	// Method that returns the shortest path in terms of nodes (i.e crossroad
	// names)
	public LinkedList<String>[] shortestPath(String label) {
		LinkedList<String>[] nodepaths = this.CityGraph.shortestPath(label);
		return nodepaths;
	}

	// Method that returns the shortest path in terms of edges (i.e street
	// names)
	public StackLl<String>[] getEdgePath(LinkedList<String>[] nodepaths) {
		return this.CityGraph.getEdgePath(nodepaths);
	}

	/*
	 * Method to print a city to standard output (by printing the graph string
	 * representation)
	 */
	public String toString() {
		return this.CityGraph.toString();
	}

	/*
	 * Method to print a city (by printing the matrix string representation)
	 * This should be used for debugging purposes as it gives more detailed
	 * information about the crossroads, trafficlights and streets states
	 */
	public void print() {
		System.out.println(Crossroads.toString());
	}
}

package simulation;

import trafficFlow.Vehicle;
import trafficFlow.City;
import trafficFlow.VehicleRegister;

/*
 * Antonin Jousson
 * 
 * Class that represents a simulation. It allows for easy set up of the city and the vehicles.
 * It is also responsible for running the simulation.
 */

public class TrafficFlowSimulation {

	private City myCity;
	private VehicleRegister myRegister;

	// Simulation constructor
	public TrafficFlowSimulation() {
		// Instanciation of the vehicle register
		this.myRegister = new VehicleRegister();
	}

	/*
	 * Method to set up the city by parsing the configuration file. This is also
	 * where we set up the city graph that will be used to calculate the
	 * shortest paths
	 * 
	 */
	public void setupCity(String fileName) {
		SimulationReader sr = new SimulationReader(this);
		sr.readCity(fileName);
		myCity.setupCityGraph();
	}

	// Method to set up the vehicles by parsing the configuration file
	public void addVehicles(String fileName) {
		SimulationReader sr = new SimulationReader(this);
		sr.readVehicles(fileName);
	}

	/*
	 * Method to add a vehicle to the city and to the vehicle register. This is
	 * also where we calculate the static shortest path for each vehicle
	 * beforehand
	 */
	public void addVehicle(String start, String side, Vehicle v) {

		// Add the car to the city
		myCity.addVehicle(start, side, v);

		// Add the car to the register
		myRegister.addCar(v);

		// Calculte the shortest path for the vehicle
		v.calculateShortestPath(myCity, start);

		// System.out.println(v + " starts at " + start + ".");

	}

	// Method to create the city (create the actual instance of the city class)
	public void initiateCity(String cityName, int horizontalSize, int verticalSize) {

		// Instanciation of the city
		myCity = new City(cityName, horizontalSize, verticalSize);

		System.out.println(
				"Initiate city named " + cityName + " of size " + horizontalSize + " by " + verticalSize + ".");
	}

	// Method to add a road work to the simulation : not implemented
	public void addRoadWork(String from, String to) {
		System.out.println("Roadwork added from " + from + " to " + to + ".");
	}

	// Method to add a crossroad to the city ( create the actual instance of the
	// crossroad)
	public void setUpCrossroad(int row, int column, String crossName, int trafficlightFlowNorth,
			int trafficlightFlowSouth, int trafficlightFlowWest, int trafficlightFlowEast,
			int trafficlightCapacityNorth, int trafficlightCapacitySouth, int trafficlightCapacityWest,
			int trafficlightCapacityEast, int streetCapacityNorth, int streetCapacitySouth, int streetCapacityWest,
			int streetCapacityEast, int streetTravelingTimeNorth, int streetTravelingTimeSouth,
			int streetTravelingTimeWest, int streetTravelingTimeEast) {

		myCity.setupCrossroad(row, column, crossName, trafficlightFlowNorth, trafficlightFlowSouth,
				trafficlightFlowWest, trafficlightFlowEast, trafficlightCapacityNorth, trafficlightCapacitySouth,
				trafficlightCapacityWest, trafficlightCapacityEast, streetCapacityNorth, streetCapacitySouth,
				streetCapacityWest, streetCapacityEast, streetTravelingTimeNorth, streetTravelingTimeSouth,
				streetTravelingTimeWest, streetTravelingTimeEast);

		// System.out.println("Set up crossroad at position " + column + ", " +
		// row + " with name " + crossName + ".");

	}

	// Start the simulation
	public void start(int loops) {
		if (loops == 0) {
			// run complete simulation
		} else {
			// run "loops" number of loops
			for (int i = 0; i < loops; i++) {
				// int j = i + 1;
				// System.out.println("Iteration: " + j);
				// System.out.println();
				myCity.iterate();
				// myCity.print();
				// System.out.println();
			}
		}
	}

	// Print the city graph (for debugging purposes)
	public void printGraph() {
		System.out.println(myCity);
	}

	// Returns total travel time 
	public int totalTravelTime() {
		return myRegister.totalTravelTime();
	}

	// Returns average travel time
	public float averageTravelTime() {
		return myRegister.averageTravelTime();
	}

	// Print the traveltime for a given vehicle
	public void travelTimeForVehicle(String vehicleName) {
		System.out.println(myRegister.travelTimeForVehicle(vehicleName));
	}

	// Print the route for a given vehicle
	public void printRouteForVehicle(String vehicleName) {
		myRegister.printRouteForVehicle(vehicleName);
	}

	// Print the shortest path of a vehicle in terms of edges (for debugging
	// purposes)
	public void printEdgePathForVehicle(String vehicleName) {
		myRegister.printEdgePathForVehicle(vehicleName);
	}

	// Print the shortest path of a vehicle in terms of nodes (for debugging
	// purposes)
	public void printNodePathForVehicle(String vehicleName) {
		myRegister.printNodePathForVehicle(vehicleName);
	}

	public void printVehicle(String vehicleName) {
		myRegister.printVehicle(vehicleName);
	}

	/*
	 * Returns the size of the register. This is useful to be able to loop over
	 * the vehicles in the main simulation class
	 */
	public int size() {
		return this.myRegister.size();
	}

}

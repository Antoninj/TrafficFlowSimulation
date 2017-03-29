package trafficFlow;

import dataStructuresGenerics.Dictionary;

/*
 * Antonin Jousson
 * 
 * Class that represents a vehicle Register in order to keep track
 *  and request information about any vehicle in a simulation.
 */
public class VehicleRegister {

	private Dictionary<String, Vehicle> register;

	// Constructor
	public VehicleRegister() {
		this.register = new Dictionary<String, Vehicle>();
	}

	// Add a vehicle to the dictionary register
	public void addCar(Vehicle v) {
		this.register.add(v.getName(), v);
	}

	// Print a vehicle from the register
	public void printVehicle(String vehicleName) {
		Vehicle v = this.register.find(vehicleName);
		System.out.println(v);
	}

	// Print the route followed by a vehicle
	public void printRouteForVehicle(String vehicleName) {
		Vehicle v = this.register.find(vehicleName);
		v.printRoute();
	}

	// Print the shortest path of a vehicle in terms of edges (for debugging
	// purposes)
	public void printEdgePathForVehicle(String vehicleName) {
		Vehicle v = this.register.find(vehicleName);
		v.printEdgePath();
	}

	// Print the shortest path of a vehicle in terms of nodes (for debugging
	// purposes)
	public void printNodePathForVehicle(String vehicleName) {
		Vehicle v = this.register.find(vehicleName);
		v.printNodePath();
	}

	// Print the traveltime for a given vehicle
	public int travelTimeForVehicle(String vehicleName) {
		Vehicle v = this.register.find(vehicleName);
		return v.getTraveltime();
	}

	// Returns total travel time
	public int totalTravelTime() {
		int sum = 0;
		for (int i = 0; i < register.size(); i++) {
			Vehicle v = this.register.find(i);
			sum += v.getTraveltime();
		}
		return sum;
	}

	// Returns average travel time
	public int averageTravelTime() {
		int sum = this.totalTravelTime();
		return sum / (register.size());
	}

	/*
	 * Returns the size of the register. This is useful to be able to loop over
	 * the vehicles in the main simulation class
	 */
	public int size() {
		return this.register.size();
	}
}

package trafficFlow;

import dataStructuresGenerics.LinkedList;
import dataStructuresGenerics.StackLl;

/*
 * Antonin Jousson
 * 
 * Class that represents a vehicle
 */

public class Vehicle implements Comparable<Vehicle> {

	private boolean priority;
	private String name;
	private String destination;
	private LinkedList<String> route;
	private int travelTime;
	private StackLl<String> edgepath;
	private LinkedList<String> nodepath;

	// Main constructor
	public Vehicle(String name, String destination) {
		this.name = name;
		this.destination = destination;
		this.route = new LinkedList<String>();
		this.priority = false;
	}

	// Constructor for priority vehicles
	public Vehicle(String name, String destination, boolean priority) {
		this.name = name;
		this.destination = destination;
		this.priority = priority;
		this.route = new LinkedList<String>();
	}

	// Method that returns the destination of the vehicle
	public String getDestination() {
		return this.destination;
	}

	// Method that returns the traveltime of the vehicle
	public int getTraveltime() {
		return this.travelTime;
	}

	// Method that returns the name of the vehicle
	public String getName() {
		return this.name;
	}

	// Method that returns the path to be followed by the car
	public StackLl<String> getPath() {
		return this.edgepath;
	}

	// Method that sets the destination of the vehicle
	public void setDestination(String destination) {
		this.destination = destination;
	}

	// Method that checks whether a vehicle is a priority vehicle or not
	public boolean isPriorityVehicle() {
		return priority;
	}

	// Method that adds a reference location to the route of the vehicle
	public void addLocationToRoute(String location) {
		this.route.addLast(location);
	}

	/*
	 * Method that increments the travelTime attribute of a vehicle with a given
	 * amount of minutes
	 */
	public void incrementTravelTime(int minutes) {
		this.travelTime = this.travelTime + minutes;
	}

	// Method that resets the travelTime attribute of a vehicle
	public void resetTravelTime() {
		this.travelTime = 0;
	}

	// Method that prints the route followed by a vehicle
	public void printRoute() {
		System.out.println(this.route);
	}

	/*
	 * Method that prints the shortest path calculated by the algorithm in terms
	 * of edges (street names)
	 */
	public void printEdgePath() {
		System.out.println(this.edgepath);
	}

	/*
	 * Method that prints the shortest path calculated by the algorithm in terms
	 * of nodes (crossroad names)
	 */
	public void printNodePath() {
		System.out.println(this.nodepath);
	}

	// Method that prints the travelTime attribute of a vehicle
	public void printTravelTime() {
		System.out.println(this.travelTime);

	}

	// Method to print a vehicle to standard output in an understandable way
	public String toString() {

		String s = "";
		if (this.priority) {
			s = "A priority vehicle with destination:" + this.destination;
		} else {
			s = "A vehicle with destination:" + this.destination;
		}
		return s;
	}

	/*
	 * Method to compare vehicles : two vehicles are the same if they have the
	 * same name
	 */
	public int compareTo(Vehicle o) {
		return this.getName().compareTo(o.getName());
	}

	// Method to calculte the shortest path to the vehicle destination
	public void calculateShortestPath(City myCity, String start) {

		LinkedList<String>[] nodepaths = myCity.shortestPath(start);
		StackLl<String>[] edgepaths = myCity.getEdgePath(nodepaths);

		for (int i = 0; i < nodepaths.length; i++) {
			if (nodepaths[i].getLast().compareTo(this.destination) == 0) {
				this.edgepath = edgepaths[i];
				this.nodepath = nodepaths[i];
			}
		}
	}

}

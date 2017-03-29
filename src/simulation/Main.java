package simulation;

import trafficFlow.Vehicle;
import trafficFlow.TrafficLight;
import trafficFlow.CrossRoad;
import trafficFlow.City;

/*
 * Antonin Jousson
 * 
 * Main class to run the traffic flow simulation for each part separately .
 * 
 */

public class Main {

	public static void part1() {

		// ********************* PART 1 *********************

		/*
		 * Instantiation of 3 vehicles. The last instance of the vehicle is
		 * being created using the special constructor for priority vehicles.
		 */

		Vehicle vehicle1 = new Vehicle("bmw", "destination1");
		Vehicle vehicle2 = new Vehicle("mercedes", "destination2");
		Vehicle vehicle3 = new Vehicle("ambulance", "destination3", true);

		System.out.println(" ********************** PART 1 TESTS ********************** ");
		System.out.println();

		System.out.println("1. Vehicle tests");
		System.out.println();

		// Tests for the toString method
		System.out.println(vehicle1);
		System.out.println(vehicle2);
		System.out.println(vehicle3);
		System.out.println();

		// Test for the addLocation method
		vehicle1.addLocationToRoute("location1");
		vehicle1.addLocationToRoute("location2");
		vehicle1.addLocationToRoute("location3");

		// Tests for the printRoute method()
		vehicle1.printRoute();
		vehicle3.printRoute();

	}

	public static void part2() {

		// ********************* PART 2 *********************

		/*
		 * Instantiation of 16 vehicles, 2 of them being priority vehicles.
		 */

		Vehicle Car1 = new Vehicle("vehicle1", "destination1");
		Vehicle Car2 = new Vehicle("vehicle2", "destination2");
		Vehicle Car3 = new Vehicle("vehicle3", "destination3");
		Vehicle Car4 = new Vehicle("vehicle4", "destination4", true);
		Vehicle Car5 = new Vehicle("vehicle5", "destination5");
		Vehicle Car6 = new Vehicle("vehicle6", "destination6");
		Vehicle Car7 = new Vehicle("vehicle7", "destination7");
		Vehicle Car8 = new Vehicle("vehicle8", "destination8");
		Vehicle Car9 = new Vehicle("vehicle9", "destination9", true);
		Vehicle Car10 = new Vehicle("vehicle10", "destination10");
		Vehicle Car11 = new Vehicle("vehicle11", "destination11");
		Vehicle Car12 = new Vehicle("vehicle12", "destination12");
		Vehicle Car13 = new Vehicle("vehicle13", "destination13");
		Vehicle Car14 = new Vehicle("vehicle14", "destination14");
		Vehicle Car15 = new Vehicle("vehicle15", "destination15");
		Vehicle Car16 = new Vehicle("vehicle16", "destination16");

		/*
		 * Instanciation of a new crossroad (same parameters for every
		 * trafficlight and street because we are just testing)
		 */
		int trafficlightFlow = 2;
		int trafficlightCapacity = 5;
		int streetCapacity = 5;
		int streetTravelingTime = 2;

		CrossRoad CR1 = new CrossRoad("MyCrossRoad1", trafficlightFlow, trafficlightFlow, trafficlightFlow,
				trafficlightFlow, trafficlightCapacity, trafficlightCapacity, trafficlightCapacity,
				trafficlightCapacity, streetCapacity, streetCapacity, streetCapacity, streetCapacity,
				streetTravelingTime, streetTravelingTime, streetTravelingTime, streetTravelingTime);

		// We add some vehicles to each trafficlight at the crossroad.
		CR1.addVehicle("North", Car1);
		CR1.addVehicle("North", Car2);
		CR1.addVehicle("North", Car3);
		CR1.addVehicle("North", Car4);

		CR1.addVehicle("South", Car5);
		CR1.addVehicle("South", Car6);
		CR1.addVehicle("South", Car7);
		CR1.addVehicle("South", Car8);

		CR1.addVehicle("West", Car9);
		CR1.addVehicle("West", Car10);
		CR1.addVehicle("West", Car11);
		CR1.addVehicle("West", Car12);

		CR1.addVehicle("East", Car13);
		CR1.addVehicle("East", Car14);
		CR1.addVehicle("East", Car15);
		CR1.addVehicle("East", Car16);

		System.out.println();
		System.out.println(" ********************** PART 2 TESTS ********************** ");
		System.out.println();

		System.out.println("1. Trafficlight tests");
		System.out.println();

		int flow = 1;
		int capacity = 5;
		TrafficLight myTL = new TrafficLight(true, flow, capacity);

		System.out.println("Initial state:");
		System.out.println("Traffic light time : " + myTL.getTime());
		System.out.println(myTL);
		System.out.println();

		// Test of the trafficlight iterate function
		for (int i = 1; i < 15; i++) {
			System.out.println("Iteration: " + i);
			myTL.iterate();
			System.out.println("Traffic light time : " + myTL.getTime());
			System.out.println(myTL);
			System.out.println();
		}

		System.out.println();
		System.out.println("2. CrossRoad tests");
		System.out.println();

		System.out.println("Initial state:");
		System.out.println();
		System.out.println(CR1);
		System.out.println();

		// /*
		// * Test of the Crossroad iterate function ( broken since the shortest
		// * path algorithm is now implemented so we need a city to be able to
		// * iterate the crossroad )
		// */
		// for (int i = 1; i < 2; i++) {
		// System.out.println("Iteration: " + i);
		// System.out.println();
		// CR1.iterate();
		// System.out.println(CR1);
		// System.out.println();
		// }

	}

	public static void part3() {

		// ********************* PART 3 *********************

		System.out.println();
		System.out.println(" ********************** PART 3 TESTS ********************** ");
		System.out.println();

		Vehicle Car1 = new Vehicle("vehicle1", "MyCrossroad3");
		Vehicle Car2 = new Vehicle("vehicle2", "MyCrossroad3");
		Vehicle Car3 = new Vehicle("vehicle3", "MyCrossroad3");
		Vehicle Car4 = new Vehicle("vehicle4", "MyCrossroad3", true);
		Vehicle Car5 = new Vehicle("vehicle5", "MyCrossroad6");
		Vehicle Car6 = new Vehicle("vehicle6", "MyCrossroad6");
		Vehicle Car7 = new Vehicle("vehicle7", "MyCrossroad6");
		Vehicle Car8 = new Vehicle("vehicle8", "MyCrossroad6");
		Vehicle Car9 = new Vehicle("vehicle9", "MyCrossroad4", true);
		Vehicle Car10 = new Vehicle("vehicle10", "MyCrossroad4");
		Vehicle Car11 = new Vehicle("vehicle11", "MyCrossroad4");
		Vehicle Car12 = new Vehicle("vehicle12", "MyCrossroad4");
		Vehicle Car13 = new Vehicle("vehicle13", "MyCrossroad1");
		Vehicle Car14 = new Vehicle("vehicle14", "MyCrossroad1");
		Vehicle Car15 = new Vehicle("vehicle15", "MyCrossroad1");
		Vehicle Car16 = new Vehicle("vehicle16", "MyCrossroad1");

		System.out.println("1. City tests");
		System.out.println();

		int city_width = 3;
		int city_height = 2;

		// Instanciation of a new city
		City myCity = new City("Manhattan", city_width, city_height);
		/*
		 * We set up some crossroads ( they all have the same parameters because
		 * we are just testing ... )
		 */
		int trafficlightFlow = 2;
		int trafficlightCapacity = 5;
		int streetCapacity = 5;
		int streetTravelingTime = 2;

		int counter = 1;
		for (int i = 0; i < city_height; i++) {
			for (int j = 0; j < city_width; j++) {
				String crossRoadName = "MyCrossroad" + counter;
				myCity.setupCrossroad(i, j, crossRoadName, trafficlightFlow, trafficlightFlow, trafficlightFlow,
						trafficlightFlow, trafficlightCapacity, trafficlightCapacity, trafficlightCapacity,
						trafficlightCapacity, streetCapacity, streetCapacity, streetCapacity, streetCapacity,
						streetTravelingTime, streetTravelingTime, streetTravelingTime, streetTravelingTime);
				counter++;
			}
		}

		myCity.setupCityGraph();

		// We add some vehicles to the city and calculate the shortest paths for
		// each vehicle

		myCity.addVehicle("MyCrossroad1", "North", Car1);
		myCity.addVehicle("MyCrossroad1", "North", Car2);
		myCity.addVehicle("MyCrossroad1", "North", Car3);
		myCity.addVehicle("MyCrossroad1", "North", Car4);
		Car1.calculateShortestPath(myCity, "MyCrossroad1");
		Car2.calculateShortestPath(myCity, "MyCrossroad1");
		Car3.calculateShortestPath(myCity, "MyCrossroad1");
		Car4.calculateShortestPath(myCity, "MyCrossroad1");

		myCity.addVehicle("MyCrossroad2", "East", Car5);
		myCity.addVehicle("MyCrossroad2", "East", Car6);
		myCity.addVehicle("MyCrossroad2", "East", Car7);
		myCity.addVehicle("MyCrossroad2", "East", Car8);
		Car5.calculateShortestPath(myCity, "MyCrossroad2");
		Car6.calculateShortestPath(myCity, "MyCrossroad2");
		Car7.calculateShortestPath(myCity, "MyCrossroad2");
		Car8.calculateShortestPath(myCity, "MyCrossroad2");

		myCity.addVehicle("MyCrossroad2", "West", Car9);
		myCity.addVehicle("MyCrossroad2", "West", Car10);
		myCity.addVehicle("MyCrossroad2", "West", Car11);
		myCity.addVehicle("MyCrossroad2", "West", Car12);
		Car9.calculateShortestPath(myCity, "MyCrossroad2");
		Car10.calculateShortestPath(myCity, "MyCrossroad2");
		Car11.calculateShortestPath(myCity, "MyCrossroad2");
		Car12.calculateShortestPath(myCity, "MyCrossroad2");

		myCity.addVehicle("MyCrossroad4", "North", Car13);
		myCity.addVehicle("MyCrossroad4", "North", Car14);
		myCity.addVehicle("MyCrossroad4", "North", Car15);
		myCity.addVehicle("MyCrossroad4", "North", Car16);
		Car13.calculateShortestPath(myCity, "MyCrossroad4");
		Car14.calculateShortestPath(myCity, "MyCrossroad4");
		Car15.calculateShortestPath(myCity, "MyCrossroad4");
		Car16.calculateShortestPath(myCity, "MyCrossroad4");

		System.out.println();

		// Test of the city iterate function
		for (int i = 0; i < 8; i++) {
			int j = i + 1;
			System.out.println("Iteration: " + j);
			System.out.println();
			myCity.iterate();
			myCity.print();
			System.out.println();
		}

		Car2.printRoute();
		Car2.printNodePath();

		Car2.printTravelTime();

		// print city graph
		// System.out.println(myCity);

	}

	public static void part4() {

		// ********************* PART 4 : Simulation *********************

		TrafficFlowSimulation mySimulation = new TrafficFlowSimulation();

		mySimulation.setupCity("files/city2.txt");
		mySimulation.addVehicles("files/vehicles2.txt");

		/*
		 * We run the simulation for 150 minutes to make sure all cars reached
		 * their destination. They actually stop one crossroad before their
		 * destination, I could'nt solve this bug ...
		 */

		mySimulation.start(150);

		System.out.println();

		for (int i = 1; i <= mySimulation.size(); i++) {
			String vehiclename = "V" + i;
			System.out.println("Vehicle " + vehiclename + ": ");
			mySimulation.printVehicle(vehiclename);
			System.out.print("Route planned: ");
			mySimulation.printNodePathForVehicle(vehiclename);
			System.out.print("Route followed: ");
			mySimulation.printRouteForVehicle(vehiclename);
			System.out.print("Traveltime: ");
			mySimulation.travelTimeForVehicle(vehiclename);
			System.out.println();
		}

		System.out.println("Total travel time : " + mySimulation.totalTravelTime() + " minutes.");
		System.out.println("Average travel time : " + mySimulation.averageTravelTime() + " minutes.");

		// mySimulation.printGraph();

	}

	public static void main(String[] args) {

		// Uncomment the part you want to run.

		// part1();
		// part2();
		// part3();

		// This is the method to run the main simulation,
		part4();

	}
}

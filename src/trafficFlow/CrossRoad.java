package trafficFlow;

/*
 * Antonin Jousson
 * 
 * Class that represents a crossroad. 
 * A crossroad is composed of 4 traffic lights and 4 streets.
 */

public class CrossRoad implements Comparable<CrossRoad> {

	private String name;
	private TrafficLight NorthTL;
	private TrafficLight SouthTL;
	private TrafficLight WestTL;
	private TrafficLight EastTL;

	private Street NorthStreet;
	private Street SouthStreet;
	private Street WestStreet;
	private Street EastStreet;

	/*
	 * Crossroad constructor
	 */
	public CrossRoad(String name, int trafficlightFlowNorth, int trafficlightFlowSouth, int trafficlightFlowWest,
			int trafficlightFlowEast, int trafficlightCapacityNorth, int trafficlightCapacitySouth,
			int trafficlightCapacityWest, int trafficlightCapacityEast, int streetCapacityNorth,
			int streetCapacitySouth, int streetCapacityWest, int streetCapacityEast, int streetTravelingTimeNorth,
			int streetTravelingTimeSouth, int streetTravelingTimeWest, int streetTravelingTimeEast) {

		this.name = name;
		this.NorthTL = new TrafficLight(false, trafficlightFlowNorth, trafficlightCapacityNorth);
		this.SouthTL = new TrafficLight(false, trafficlightFlowSouth, trafficlightCapacitySouth);
		this.WestTL = new TrafficLight(true, trafficlightFlowWest, trafficlightCapacityWest);
		this.EastTL = new TrafficLight(true, trafficlightFlowEast, trafficlightCapacityEast);

		this.NorthStreet = new Street(streetCapacityNorth, streetTravelingTimeNorth);
		this.SouthStreet = new Street(streetCapacitySouth, streetTravelingTimeSouth);
		this.WestStreet = new Street(streetCapacityWest, streetTravelingTimeWest);
		this.EastStreet = new Street(streetCapacityEast, streetTravelingTimeEast);
	}

	// Method that returns the name of the crossroad
	public String getName() {
		return this.name;
	}

	// Method that returns one of the 4 streets of the crossroad
	public Street getStreet(String name) {
		if (name == "North") {
			return NorthStreet;
		} else if (name == "South") {
			return SouthStreet;
		} else if (name == "West") {
			return WestStreet;
		} else if (name == "East") {
			return EastStreet;
		}
		return null;
	}

	// Method that returns one of the 4 trafficlights of the crossroad
	public TrafficLight getTrafficlight(String name) {

		if (name == "North") {
			return NorthTL;
		} else if (name == "South") {
			return SouthTL;
		} else if (name == "West") {
			return WestTL;
		} else if (name == "East") {
			return EastTL;
		}
		return null;
	}

	/*
	 * Method that adds a vehicle to a particular side ( i.e trafficlight) of
	 * the crossraod
	 */
	public void addVehicle(String side, Vehicle car) {
		if (side == "North") {
			NorthTL.addVehicle(car);
		}
		if (side == "South") {
			SouthTL.addVehicle(car);
		}
		if (side == "West") {
			WestTL.addVehicle(car);
		}
		if (side == "East") {
			EastTL.addVehicle(car);
		}
	}

	/*
	 * Method to iterate one specific trafficlight in the crossroad : If the
	 * trafficlight is green we let n cars move from the trafficlight to the
	 * next street on their path ( where n is the flow of the trafficlight) and
	 * n/2 cars if it is yellow.
	 * 
	 */
	public void iterate_one(TrafficLight trafficlight) {

		if (trafficlight.getState().getColor().equals("Green") && trafficlight.size() > 0) {
			for (int i = 0; i < trafficlight.getflow(); i++) {
				if (trafficlight.size() > 0) {
					Vehicle top_car = trafficlight.topVehicle();
					Street street = this.getStreet(top_car.getPath().top());
					if (street.size() < street.getcapacity()) {
						Vehicle removed_car = trafficlight.removeVehicle();
						removed_car.getPath().pop();
						if (removed_car.getPath().size() != 0) {
							street.addCAr(removed_car);
						}
					}
				}
			}
		} else if (trafficlight.getState().getColor().equals("Yellow") && trafficlight.size() > 0) {
			for (int i = 0; i < Math.ceil(trafficlight.getflow() / 2); i++) {
				if (trafficlight.size() > 0) {
					Vehicle top_car = trafficlight.topVehicle();
					Street street = this.getStreet(top_car.getPath().top());
					if (street.size() < street.getcapacity()) {
						Vehicle removed_car = trafficlight.removeVehicle();
						removed_car.getPath().pop();
						if (removed_car.getPath().size() != 0) {
							street.addCAr(removed_car);
						}
					}
				}
			}
		}

		// We iterate the trafficlight
		trafficlight.iterate();
	}

	/*
	 * Method to iterate the crossroad : we iterate each trafficlight and street
	 * in the crossroad.
	 */
	public void iterate() {
		TrafficLight[] trafficlights = { NorthTL, SouthTL, WestTL, EastTL };
		Street[] all_streets = { NorthStreet, SouthStreet, WestStreet, EastStreet };

		for (int i = 0; i < 4; i++) {
			// iterate the traffilights
			iterate_one(trafficlights[i]);
			// iterate the streets
			all_streets[i].iterate();
		}
	}

	/*
	 * Method that prints a crossroad to standard output in an understandable
	 * way.
	 */
	public String toString() {
		String s = "The Crossroad " + this.getName() + " with the following trafficlights and streets :"
				+ System.lineSeparator() + System.lineSeparator() + " - North trafficlight, " + NorthTL.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - South trafficlight, " + SouthTL.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - West trafficlight, " + WestTL.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - East trafficlight, " + EastTL.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - North street, " + NorthStreet.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - South street, " + SouthStreet.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - West street, " + WestStreet.toString()
				+ System.lineSeparator() + System.lineSeparator() + " - East street, " + EastStreet.toString();

		return s;
	}

	/*
	 * Method to compare crossroads : two crossroads are the same if they have
	 * the same name
	 */
	public int compareTo(CrossRoad o) {
		return this.getName().compareTo(o.getName());
	}
}

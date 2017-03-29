package trafficFlow;

import dataStructuresGenerics.LinkedList;

/*
 * Antonin Jousson
 * 
 * Class that represents a street. A street is filled with vehicle pairs and has a fixed time duration( traveling time)
 * representing the time it takes to reach the next trafficlight. It also has a maximum vehicle capacity.
 */

public class Street {

	private int travelingTime;
	private LinkedList<VehiclePair> vehicles;
	private int capacity;

	/*
	 * The VehiclePair class represents a vehicle and its time remaining in the
	 * street.
	 * 
	 */
	class VehiclePair implements Comparable<VehiclePair> {
		private Vehicle car;
		private int time;

		// VehiclePair constructor
		public VehiclePair(Vehicle aCar, int someTime) {
			this.car = aCar;
			this.time = someTime;
		}

		// method to get the car
		public Vehicle getCar() {
			return this.car;
		}

		// method to get the time
		public int getTime() {
			return this.time;
		}

		// method to set the time
		public void setTime(int newTime) {
			this.time = newTime;
		}

		// method to output the vehiclePair to standart output
		public String toString() {
			String min = "";
			if (this.time > 1) {
				min = "minutes";
			} else {
				min = "minute";
			}
			String s = "{" + this.car.toString() + ", time remaining in the street:" + this.time + " " + min + "}";
			return s;
		}

		/*
		 * method to compare two vehicle pairs : they are the same if their car
		 * is the same car.
		 */
		public int compareTo(VehiclePair o) {
			return this.getCar().compareTo(o.getCar());
		}
	}

	// Street constructor
	public Street(int cap, int time) {
		this.capacity = cap;
		this.travelingTime = time;
		this.vehicles = new LinkedList<VehiclePair>();
	}

	// Method that returns the street size, which is the amount of vehicles in
	// the street.
	public int size() {
		return this.vehicles.size();
	}

	// Method that returns the street capacity
	public int getcapacity() {
		return this.capacity;
	}

	// Method that returns the street traveling time
	public int getTravelingTime() {
		return this.travelingTime;
	}

	// Method that returns the street vehicles.
	public LinkedList<VehiclePair> getvehicles() {
		return this.vehicles;
	}

	/*
	 * Method to add a car to a street : we first create a vehicle pair where
	 * the time remaining in the street is set to the street travelling time.
	 * 
	 */
	public void addCAr(Vehicle car) {
		if (this.size() < this.getcapacity()) {
			VehiclePair pair = new VehiclePair(car, this.travelingTime);
			this.vehicles.addFirst(pair);
		} else {
			System.out.println("The street has reached its maximum capacity");
		}
	}

	/*
	 * Method to iterate a street : we increase the travel time of each vehicle
	 * in the street by one minute.
	 */
	public void iterate() {
		for (int i = 0; i < this.vehicles.size(); i++) {
			VehiclePair currentVehicle = this.vehicles.get(i);
			if (currentVehicle.getTime() >= 1) {
				currentVehicle.setTime(currentVehicle.getTime() - 1);
				currentVehicle.getCar().incrementTravelTime(1);
			}
		}
	}

	// Method to print a street to standard output in an understandable way
	public String toString() {
		String s = "";
		if (this.getvehicles().size() > 0) {
			s = s + "A street with " + this.size() + " vehicles :" + System.lineSeparator() + getvehicles().toString();
		} else {
			s = s + "A street without any vehicles.";
		}
		return s;
	}
}

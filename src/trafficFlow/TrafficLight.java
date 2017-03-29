package trafficFlow;

import dataStructuresGenerics.PriorityQueue;

/*
 * Antonin Jousson
 * 
 * Class that represents a traffic light. A traffic light has a state( green, red or yellow) and has vehicles.It also
 * has a vehicle flow and a maximum vehicle capacity. Priority vehicles can pass all other vehicles in the waiting line.
 */

public class TrafficLight {

	enum State {
		RED("Red"), YELLOW("Yellow"), GREEN("Green");

		private String color;

		private State(String color) {
			this.color = color;
		}

		public String getColor() {
			return this.color;
		}
	}

	private State state;
	private PriorityQueue<Vehicle> vehicles;
	private int flow;
	private int capacity;
	private int time;

	/*
	 * Trafficlight constructor. A trafficlight can be initialized to the red or
	 * the green state
	 * 
	 */
	public TrafficLight(boolean green, int flow, int capacity) {
		if (green) {
			this.state = State.GREEN;
		} else {
			this.state = State.RED;
		}
		this.time = 0;
		this.flow = flow;
		this.capacity = capacity;
		this.vehicles = new PriorityQueue<Vehicle>();
	}

	/*
	 * method that returns the size of a traffilight : it is the size of the
	 * priority queue that contains the vehicles waiting at the trafficlight
	 * Method that resets the travelTime attribute of a vehicle
	 */
	public int size() {
		return this.vehicles.size();
	}

	// method that returns the time of the trafficlight
	public int getTime() {
		return this.time;
	}

	// method that sets the time of the trafficlight
	public void setTime(int newTime) {
		this.time = newTime;
	}

	// method that returns the state of the trafficlight
	public State getState() {
		return this.state;
	}

	// method that sets the state of the trafficlight
	public void setState(State state) {
		this.state = state;
	}

	// method that returns the vehicles priority queue
	public PriorityQueue<Vehicle> getvehicles() {
		return this.vehicles;
	}

	// method that returns the flow of the trafficlight
	public int getflow() {
		return this.flow;
	}

	// method that sets the flow of the trafficlight
	public void setflow(int flow) {
		this.flow = flow;
	}

	// method that returns the capacity of the trafficlight
	public int getcapacity() {
		return this.capacity;
	}

	/*
	 * method to add a vehicle to the trafficlight. If it is a priority vehicle,
	 * we push it with the highest priority, so in front
	 */
	public void addVehicle(Vehicle car) {
		if (this.size() < this.getcapacity()) {
			if (car.isPriorityVehicle()) {
				this.vehicles.push(car, 1);
			} else {
				this.vehicles.push(car, 0);
			}
		} else {
			// this is (was) for debugging purposes.
			System.out.println("The traffic light has reached its maximum capacity");
		}
	}

	/*
	 * method to remove a vehicle from the trafficlight : we just pop the next
	 * vehicle in the priority queue
	 */
	public Vehicle removeVehicle() {
		Vehicle removed_vehicle = this.vehicles.pop();
		return removed_vehicle;
	}

	public Vehicle topVehicle() {
		return this.vehicles.top();
	}

	/*
	 * Method to iterate the trafficlight : if we reach the maximum time allowed
	 * for a state, we change state, otherwise we increase the time of the
	 * trafficlight
	 */
	public void iterate() {
		if (this.getState() == State.RED && this.getTime() == 2) {
			this.setState(State.GREEN);
			setTime(0);
		} else if (this.getState() == State.GREEN && this.getTime() == 1) {
			this.setState(State.YELLOW);
			setTime(0);
		} else if (this.getState() == State.YELLOW && this.getTime() == 0) {
			this.setState(State.RED);
			setTime(0);
		} else {
			setTime(this.getTime() + 1);
		}
	}

	// Method to print a trafficlight to standard output in an understandable
	// way
	public String toString() {

		String s = "";
		if (this.getvehicles().size() > 0) {
			s = s + "A " + this.getState().getColor() + " traffic light with " + this.size() + " vehicles :"
					+ System.lineSeparator() + this.getvehicles().toString();
		} else {
			s = s + "A " + this.getState().getColor() + " traffic light without any vehicles waiting.";
		}
		return s;
	}
}

package com.example.learnjava;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class Flight {
    private int passengers;
    private int seats;

    public Flight() {
        passengers = 0;
        seats = 150;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void add1Passenger() {
        if( passengers<150 ) {
            passengers += 1;
        }
        else {
            handleToMany();
        }
    }

    private void handleToMany() {
        System.out.println("Too Many..!!");
    }

    public boolean hasRoom(Flight other) {
        int total = this.getPassengers() + other.getPassengers();
        return (total <= this.getSeats());
    }

    public Flight createNewWithBoth(Flight other) {
        Flight newFlight = new Flight();

        newFlight.setPassengers(this.getPassengers() + other.getPassengers());
        newFlight.setSeats(this.getSeats());

        return newFlight;
    }

    public static void main(String[] args) {
        Flight flight1 = new Flight();
        flight1.add1Passenger();
        System.out.println(flight1.getPassengers());

        Flight flight2 = new Flight();
        flight2.add1Passenger();
        System.out.println(flight2.getPassengers());

        flight2 = flight1;
        flight1.add1Passenger();
        flight1.add1Passenger();
        System.out.println(flight2.getPassengers());

    }
}

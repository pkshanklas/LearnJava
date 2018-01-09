package com.example.learnjava;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class Flight {
    private int passengers;
    private int seats;
    private int flightNumber;
    private int totalBags;
    private int totalCarryOns;
    private int maxCarryOns = seats * 2;
    private boolean[] isSeatAvailable;
    static int allPassengers;

    {
        isSeatAvailable = new boolean[seats];

        for(int i=0; i<seats; i++) {
            isSeatAvailable[i] = true;
        }
    }

    public Flight() {
        passengers = 0;
        seats = 150;
    }



    static int getAllPassengers() {
        return allPassengers;
    }

    static void resetAllPassengers() {
        allPassengers = 0;
    }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
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

    private boolean hasSeat() {
        return this.passengers+1 < this.seats;
    }

    private boolean hashSeat(int count) {
        return passengers + count < seats;
    }

    private boolean hashCarryOnSpace(int carryOns) {
        return (totalCarryOns + carryOns) <= maxCarryOns;
    }

    public void add1Passenger() {
        if( hasSeat() ) {
            setPassengers( getPassengers() + 1 );
            allPassengers += 1;
        }
        else {
            handleToMany();
        }
    }

    public void add1Passenger(int bags) {
        if( hasSeat() ) {
            add1Passenger();
            this.totalBags += bags;
        }
    }

    public void add1Passenger(Passenger p) {
        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(int bags, int carryOns) {
        if( hasSeat() && hashCarryOnSpace(carryOns) ) {
            add1Passenger(bags);
            totalCarryOns += carryOns;
        }
    }

    public void add1Passenger(Passenger p, int carryOns) {
        add1Passenger(p.getCheckedBags(), carryOns);
    }

    public void add1Passenger(Passenger... list) {
        if( hashSeat(list.length) ) {
            for(Passenger p: list) {
                totalBags += p.getCheckedBags();
            }
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

    @Override
    public boolean equals(Object obj) {
        if( super.equals(obj) ) return true;

        if ( !(obj instanceof Flight) ) return false;

        return flightNumber == ((Flight)obj).flightNumber;
    }

    @Override
    public String toString() {
        return "Flight #" + this.flightNumber;
    }

    public static void main(String[] args) {

        Integer a = Integer.valueOf(100);
        int b = a.intValue();
        Integer c = Integer.valueOf(b);

    }
}

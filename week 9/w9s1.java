import java.util.*;

class Vehicle {
    String number;

    Vehicle(String number) {
        this.number = number;
    }
}

class Driver {
    String name;
    Vehicle vehicle;

    Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

abstract class Trip {
    Rider rider;
    Driver driver;
    double distance;

    Trip(Rider rider, Driver driver, double distance) {
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
    }

    abstract double calculateFare();
}

class BikeTrip extends Trip {
    BikeTrip(Rider r, Driver d, double distance) {
        super(r, d, distance);
    }

    double calculateFare() {
        return distance * 5;
    }
}

class AutoTrip extends Trip {
    AutoTrip(Rider r, Driver d, double distance) {
        super(r, d, distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

class CabTrip extends Trip {
    CabTrip(Rider r, Driver d, double distance) {
        super(r, d, distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

public class w9s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Rider rider = new Rider("Rider");
        Driver driver = new Driver("Driver", new Vehicle("V1"));

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Trip trip;

                if (distance <= 0) {
                    throw new IllegalArgumentException("Invalid booking");
                }

                if (type.equals("Bike")) {
                    trip = new BikeTrip(rider, driver, distance);
                } else if (type.equals("Auto")) {
                    trip = new AutoTrip(rider, driver, distance);
                } else if (type.equals("Cab")) {
                    trip = new CabTrip(rider, driver, distance);
                } else {
                    throw new IllegalArgumentException("Invalid booking");
                }

                System.out.println((int) trip.calculateFare());
            } catch (Exception e) {
                System.out.println("Invalid booking");
            }
        }
    }
}
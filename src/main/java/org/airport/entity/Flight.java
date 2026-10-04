package org.airport.entity;

public class Flight extends AbstractEntity {

    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;

    public Flight(String flightNumber, String origin, String destination,
                  String departureTime, int capacity) {
        validate(flightNumber, origin, destination, departureTime, capacity);
        this.flightNumber = flightNumber.trim();
        this.origin = origin.trim();
        this.destination = destination.trim();
        this.departureTime = departureTime.trim();
        this.capacity = capacity;
    }

    public Flight(Long id, String flightNumber, String origin, String destination,
                  String departureTime, int capacity) {
        super(id);
        validate(flightNumber, origin, destination, departureTime, capacity);
        this.flightNumber = flightNumber.trim();
        this.origin = origin.trim();
        this.destination = destination.trim();
        this.departureTime = departureTime.trim();
        this.capacity = capacity;
    }

    private static void validate(String flightNumber, String origin, String destination,
                                 String departureTime, int capacity) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер полёта");
        }
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Некорректное место отправки");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Некорректное место прибытия");
        }
        if (departureTime == null || departureTime.isBlank()) {
            throw new IllegalArgumentException("Некорректное время вылета");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Это число должно быть положительны");
        }
    }

    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public int getCapacity() { return capacity; }

    public void setFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер полёта");
        }
        this.flightNumber = flightNumber.trim();
    }

    public void setOrigin(String origin) {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Некорректное место отправки");
        }
        this.origin = origin.trim();
    }

    public void setDestination(String destination) {
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Некорректное место прибытия");
        }
        this.destination = destination.trim();
    }

    public void setDepartureTime(String departureTime) {
        if (departureTime == null || departureTime.isBlank()) {
            throw new IllegalArgumentException("Некорректное время вылета");
        }
        this.departureTime = departureTime.trim();
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Это число должно быть положительным");
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Полёт #" + flightNumber + " (" + origin + " " + destination +
                ", " + departureTime + ", seats: " + capacity + ")";
    }
}
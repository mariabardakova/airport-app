package org.airport.entity;

public class Ticket extends AbstractEntity {

    private Long flightId;
    private Long passengerId;
    private String seatNumber;

    public Ticket(Long flightId, Long passengerId, String seatNumber) {

        validate(flightId, passengerId, seatNumber);
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber.trim();
    }

    public Ticket(Long id, Long flightId, Long passengerId, String seatNumber) {
        super(id);
        validate(flightId, passengerId, seatNumber);
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber.trim();
    }

    private static void validate(Long flightId, Long passengerId, String seatNumber) {
        if (flightId == null || flightId <= 0) {
            throw new IllegalArgumentException("Некорректный id рейса");
        }
        if (passengerId == null || passengerId <= 0) {
            throw new IllegalArgumentException("Некорректный id пассажира");
        }
        if (seatNumber == null || seatNumber.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер места");
        }
    }

    public Long getFlightId() {
        return flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Билет: " + " flightId=" + flightId +
                ", passengerId=" + passengerId + ", seat='" + seatNumber + "'}";
    }
}
package org.airport.service;

import org.airport.entity.Passenger;
import org.airport.repository.PassengerRepository;

import java.util.List;

public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger addPassenger(String fullName, String passportNumber) {
        if (passengerRepository.findByPassportNumber(passportNumber).isPresent()) {
            throw new IllegalArgumentException("Пассажир с паспортом " + passportNumber + " уже существует");
        }
        Passenger passenger = new Passenger(fullName, passportNumber);
        passengerRepository.save(passenger);
        return passenger;
    }

    public Passenger getPassenger(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пассажир с id " + id + " не найден"));
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
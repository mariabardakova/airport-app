package org.airport.repository;

import org.airport.entity.Passenger;

import java.util.Optional;

public interface PassengerRepository extends MyRepository<Passenger> {

    Optional<Passenger> findByPassportNumber(String passportNumber);
}
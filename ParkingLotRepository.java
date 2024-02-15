package com.te.car.repository;

import com.te.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<Car, Long> {
    Car.ParkingLot findBySlotNumber(int slotNumber);

    Car findByRegistrationNumber(String registrationNumber);

    List<String> findRegistrationNumbersByColor(String color);

    List<Integer> findSlotNumbersByColor(String color);

    void delete(Car.ParkingLot parkingLot);
    // custom query methods if needed
}
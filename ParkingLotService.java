package com.te.car.service;
import com.te.car.entity.Car;

import java.util.List;

public interface ParkingLotService {
    void createParkingLot(int capacity);
    int parkCar(String registrationNumber, String color);
    void leaveCar(int slotNumber);
    List<Car> getParkingLotStatus();
    List<String> getRegistrationNumbersForCarsWithColor(String color);
    int getSlotNumberForRegistrationNumber(String registrationNumber);
    List<Integer> getSlotNumbersForCarsWithColor(String color);
}
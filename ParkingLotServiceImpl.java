package com.te.car.service;

import com.te.car.entity.Car;
import com.te.car.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private int capacity;

    @Override
    public void createParkingLot(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int parkCar(String registrationNumber, String color) {
        Car parkingLot = new Car();
        parkingLot.setRegistrationNumber(registrationNumber);
        parkingLot.setColor(color);

        return parkingLotRepository.save(parkingLot).getSlotNumber();
    }

    @Override
    public void leaveCar(int slotNumber) {
        Car.ParkingLot parkingLot = parkingLotRepository.findBySlotNumber(slotNumber);

        if (parkingLot != null) {
            parkingLotRepository.delete(parkingLot);
        }
    }

    @Override
    public List<Car> getParkingLotStatus() {
        return parkingLotRepository.findAll();
    }

    @Override
    public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        return parkingLotRepository.findRegistrationNumbersByColor(color);
    }

    @Override
    public int getSlotNumberForRegistrationNumber(String registrationNumber) {
        Car parkingLot = parkingLotRepository.findByRegistrationNumber(registrationNumber);

        if (parkingLot != null) {
            return parkingLot.getSlotNumber();
        }

        return -1;
    }

    @Override
    public List<Integer> getSlotNumbersForCarsWithColor(String color) {
        return parkingLotRepository.findSlotNumbersByColor(color);
    }
}

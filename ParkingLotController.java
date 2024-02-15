package com.te.car.controller;

import com.te.car.entity.Car;
import com.te.car.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping
    public void createParkingLot(@RequestParam int capacity) {
        parkingLotService.createParkingLot(capacity);
    }

    @PostMapping("/cars")
    public void parkCar(@RequestParam String registrationNumber, @RequestParam String color) {
        int slotNumber = parkingLotService.parkCar(registrationNumber, color);
        System.out.println("Allocated slot number: " + slotNumber);
    }

    @DeleteMapping("/cars/{slotNumber}")
    public void leaveCar(@PathVariable int slotNumber) {
        parkingLotService.leaveCar(slotNumber);
        System.out.println("Slot number " + slotNumber + " is free");
    }

    @GetMapping("/status")
    public List<Car> getParkingLotStatus() {
        return parkingLotService.getParkingLotStatus();
    }

    @GetMapping("/cars")
    public List<String> getRegistrationNumbersForCarsWithColor(@RequestParam String color) {
        return parkingLotService.getRegistrationNumbersForCarsWithColor(color);
    }

    @GetMapping("/cars/{registrationNumber}")
    public int getSlotNumberForRegistrationNumber(@PathVariable String registrationNumber) {
        return parkingLotService.getSlotNumberForRegistrationNumber(registrationNumber);
    }

    @GetMapping("/slots")
    public List<Integer> getSlotNumbersForCarsWithColor(@RequestParam String color) {
        return parkingLotService.getSlotNumbersForCarsWithColor(color);
    }
}
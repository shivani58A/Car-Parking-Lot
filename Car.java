package com.te.car.entity;
import jakarta.persistence.*;
public class Car {

    public String setRegistrationNumber(String registrationNumber) {
        return registrationNumber;
    }

    public int getSlotNumber() {
        return getSlotNumber();
    }

    public String setColor(String color) {
        return color;
    }

    @Entity
    @Table(name = "parking_lot")
    public class ParkingLot {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "slot_number")
        private int slotNumber;

        @Column(name = "registration_number")
        private String registrationNumber;

        private String color;

        // constructors, getters, and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getSlotNumber() {
            return slotNumber;
        }

        public void setSlotNumber(int slotNumber) {
            this.slotNumber = slotNumber;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
interface SmartVehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery percentage: 85%");
    }
}

class ElectricVehicle implements SmartVehicle {
    public void displaySpeed() {
        System.out.println("Speed: 100 km/h");
    }
}

class RegularVehicle implements SmartVehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
}
package lv.accenture.bootcamp.abs;

public class VehicleLauncher {

    public static void main(String[] args) {
        WaterTransport boat = new Boat();
        System.out.println("vehicle.getCategory() = " + boat.getCategory());
        boat.drown();
    }

}

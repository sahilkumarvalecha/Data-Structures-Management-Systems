public class Main {
    public static void main(String[] args) {
        Parking p = new Parking();

        p.addCar(new Car("ABC 928", "Raja"));
        p.addCar(new Car("BRO 178", "Chai Wala"));
        p.addCar(new Car("ASAP 12", "Canteen Wala"));

        p.removeCar();
        p.displayAllCars();
    }
}
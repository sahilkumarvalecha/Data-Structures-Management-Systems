public class Parking {
    int top;
    Car[] stack;

    public Parking() {
        this.stack = new Car[1];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void addCar(Car car){
        if(top == stack.length-1){
            Car temp[] = new Car[stack.length+1];
            for(int i=0; i<=top;i++){
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[++top] = car;
        System.out.println(car.LicensePlate + " Added to Parking Lot");
    }

    public Car removeCar(){
        if(!isEmpty()){
            Car oldCar = stack[top--];
            Car temp[] = new Car[stack.length-1];
            for(int i=0; i<=top;i++){
                temp[i] = stack[i];
            }
            stack = temp;
            return oldCar;
        }
        else {
            return null;
        }
    }

    public void displayAllCars(){
        for(int i=0;i<=top;i++){
            System.out.println( "-> " +stack[i].ownerName + "-> "+stack[i].LicensePlate );
        }
    }
}

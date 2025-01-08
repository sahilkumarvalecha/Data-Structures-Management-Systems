public class Main {
    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue();
        pq.addPatient(new Patient("Umer", 3,"Eyes"));
        pq.addPatient(new Patient("Sahil", 5,"Knee Pain"));
        pq.addPatient(new Patient("Sagar", 1,"Fever"));

        pq.displayPatients();
        System.out.println("Next Patient: "+ pq.nextPatient());
    }
}
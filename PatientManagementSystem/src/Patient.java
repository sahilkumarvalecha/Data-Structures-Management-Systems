public class Patient {
    String name;
    int severity;
    String Illness;


    public Patient(String name, int conditionSeverity, String illness) {
        this.name = name;
        this.severity = conditionSeverity;
        Illness = illness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", conditionSeverity=" + severity +
                ", Illness='" + Illness + '\'' +
                '}';
    }
}
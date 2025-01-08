public class Main {
    public static void main(String[] args) {
        GradeBook gb = new GradeBook();

        gb.addStudent(new Students("Sahil", "A+"));
        gb.addStudent(new Students("Sandesh", "B+"));
        gb.addStudent(new Students("Akshay", "F"));
        gb.addStudent(new Students("Chetan", "C"));

        gb.displayAllStudents();
        gb.searchStudent("Sahil");
    }
}
public class Students {
    String name;
    String Grade;

    public Students(String name, String grade) {
        this.name = name;
        Grade = grade;
    }
}
class GradeBook{
    Students[] student = new Students[2];
    int count =0;
    public boolean isEmpty(){
        return count == 0;
    }

    public void reSize(){
        if(count == student.length){
            Students[] temp = new Students[count*2];
            for(int i=0;i<count;i++){
                temp[i] = student[i];
            }
            student = temp;
        }
    }
    public void addStudent(Students Student){
        if(count == student.length){
            reSize();
        }
        student[count] = Student;
        count++;

        mergeSort(student,0,count-1);
    }
    public void mergeSort(Students[] student,int start,int end){
        if(start>= end){
            return;
        }
        int mid = start+(end-start)/2;
        mergeSort(student,start,mid);
        mergeSort(student,mid+1,end);
        merge(student,start,mid,end);
    }
    public void merge(Students[] student,int start,int mid, int end){
        int arr1_index = start;
        int arr2_index = mid+1;
        Students[] temp = new Students[end-start+1];
        int i=0;
        while(arr1_index<=mid && arr2_index<=end){
            if(compareStrings(student[arr1_index].name,(student[arr2_index].name)) <= 0) {
                temp[i++] = student[arr1_index++];
            }
            else{
                temp[i++] = student[arr2_index++];
            }
        }

        while(arr1_index<=mid){
            temp[i++] = student[arr1_index++];
        }
        while(arr2_index<=end){
            temp[i++] = student[arr2_index++];
        }
        for(i=0; i< temp.length;i++){
            student[start +i] = temp[i];
        }

    }
    public int compareStrings(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());

        for(int i=0;i<length;i++){
           char a = str1.charAt(i);
           char b = str2.charAt(i);

           if(a != b){
               return a-b;
            }
        }

        return str1.length()-str2.length();
    }

    public void searchStudent(String name){
        for(int i=0; i<count; i++){
            if(equalsIgnoreCase(student[i].name,name)){
                System.out.println("Student Found) Name: " +student[i].name + " Grade: " + student[i].Grade);
                return;
            }
        }
        System.out.println("No Student With Such Name");
    }
    public boolean equalsIgnoreCase(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        if(str1 == null ||  str2 == null){
            return false;
        }
        for(int i=0; i<str1.length();i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i);

            if(toLowerCase(a)!=toLowerCase(b)){
                return false;
            }
        }
        return true;
    }
    public char toLowerCase(char c){
        while(c>='A' && c<='Z'){
            return (char) (c+32);
        }
        return c;
    }
    public void displayAllStudents(){
        for(int i =0; i<count;i++){
            System.out.println("Student Name: "+ student[i].name + " Garde: "+ student[i].Grade);
        }
    }

}

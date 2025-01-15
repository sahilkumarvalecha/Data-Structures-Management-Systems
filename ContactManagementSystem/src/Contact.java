public class Contact {
    String name;
    int phoneNumber;
    String email;

    public Contact(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
class ContactBook{
    Contact[] contact = new Contact[2];
    int count = 0;

    public boolean isFull(){
        return count == contact.length;
    }

    public void resize(){
        Contact[] temp = new Contact[contact.length*2];
        for(int i = 0; i<contact.length;i++){
            temp[i] = contact[i];
        }
        contact = temp;
    }

    public void addContact(Contact newContact){
        if(isFull()){
            resize();
        }
        contact[count++] = newContact;

        mergeSort(contact,0,count-1);
    }
    public void mergeSort(Contact[] contacts, int start, int end){
        if(start>=end){
            return;
        }

        int mid = start+(end-start)/2;
        mergeSort(contacts,start,mid);
        mergeSort(contacts,mid+1,end);
        merge(contacts,start,mid,end);
    }
    public void merge(Contact[] contact,int start, int mid, int end ){
        int arr1_index = start;
        int arr2_index = mid+1;
        Contact[] temp = new Contact[end-start+1];
        int i = 0;

        while(arr1_index<= mid && arr2_index <=end){
            if(compareTo(contact[arr1_index].name, contact[arr2_index].name) <= 0){
                temp[i++] = contact[arr1_index++];
            }
            else{
                temp[i++] = contact[arr2_index++];
            }
        }

        while(arr1_index<=mid){
            temp[i++] = contact[arr1_index++];
        }
        while(arr2_index<=end){
            temp[i++] = contact[arr2_index++];
        }

        for(i=0; i< temp.length;i++){
            contact[start+i] = temp[i];
        }
    }

    public int compareTo(String str1, String str2){
        int length = Math.min(str1.length(),str2.length());

        for(int i=0;i<length;i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if(toLowerCase(a) != toLowerCase(b)){
                return a-b;
            }
        }

        return str1.length()-str2.length();
    }
    public char toLowerCase(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char) (c+32);
        }
        return c;
    }
    public boolean equals(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        if(str1 == null || str2 == null){
            return false;
        }
        for(int i=0;i<str2.length();i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if(toLowerCase(a) != toLowerCase(b)){
                return false;
            }
        }

        return true;
    }

    public void updateEmail(String name, String email){
        for(int i=0; i<count;i++){
            if(equals(contact[i].name,name)){
                contact[i].email = email;
                System.out.println("Email Updated");
            }
        }
    }
    public void updatePhone(String name, int phone){
        for(int i=0; i<count;i++){
            if(equals(contact[i].name,name)){
                contact[i].phoneNumber = phone;
                System.out.println("Phone Number Updated");
            }
        }
    }
    public void searchContact(String name){
        for(int i=0; i<count;i++){
            if(equals(contact[i].name,name)){
                System.out.println("Name: " +contact[i].name + " Email: " +contact[i].email + " Phone Number: " +contact[i].phoneNumber );
            }
        }
    }
    public void displayContacts(){
        for(int i=0; i<count;i++){
            System.out.println("Contact Name -> "+ contact[i].name + ", Email -> " + contact[i].email + ", Phone Number -> "+ contact[i].phoneNumber);
        }
    }
}



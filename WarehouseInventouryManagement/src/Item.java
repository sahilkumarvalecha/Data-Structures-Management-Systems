public class Item {
    String itemName;
    int stockQuantity;

    public Item(String itemName, int stockQuantity) {
        this.itemName = itemName;
        this.stockQuantity = stockQuantity;
    }
}
class Warehouse{
    Item[] item = new Item[2];
    int count;

    public boolean isFull(){
        return count == item.length;
    }
    public void resize(){
        if(count == item.length){
            Item[] temp = new Item[item.length*2];
            for(int i=0;i<count;i++){
               temp[i] = item[i];
            }
            item = temp;
        }
    }

    public void addItem(Item items){
        if(isFull()){
            resize();
        }
        item[count] = items;
        count++;

        mergeSort(item,0,count-1);
    }

    public void mergeSort(Item[] item, int start,int end){
        if(start>=end){
            return;
        }
        int mid = start+(end-start)/2;
        mergeSort(item,start,mid);
        mergeSort(item,mid+1,end);
        merge(item,start,mid,end);

    }

    public void merge(Item[] item,int start,int mid,int end){
        int arr1_index = start;
        int arr2_index = mid+1;
        Item[] temp = new Item[end-start+1];
        int i =0;

        while(arr1_index<=mid && arr2_index<= end){
            if(compareTo(item[arr1_index].itemName,item[arr2_index].itemName)<=0){
                temp[i++] = item[arr1_index++];
            }
            else {
                temp[i++] = item[arr2_index++];
            }
        }
        while (arr1_index<=mid){
            temp[i++] = item[arr1_index++];
        }
        while (arr2_index<=end){
            temp[i++] = item[arr2_index++];
        }

        for(i=0;i<temp.length;i++){
            item[start+i] = temp[i];
        }
    }

    public int compareTo(String str1, String str2){
        int length = Math.min(str1.length(),str2.length());
        for(int i=0; i<length;i++){
           char a = str1.charAt(i);
           char b = str2.charAt(i);

           if(a != b){
               return a-b;
           }
        }
        return str1.length()-str2.length();
    }
    public char toLowerCase(char c){
        if(c >= 'A' && c<= 'Z'){
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

        for(int i=0; i<str1.length();i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);

            if(toLowerCase(a) != toLowerCase(b)){
                return false;
            }
        }
        return true;
    }
    public void addStock(String title,int stock){
        for(int i=0;i<count;i++){
            if(equals(item[i].itemName,title)){
                System.out.println("Previous Stock: " + item[i].stockQuantity);
                item[i].stockQuantity += stock;
                System.out.println("Updated Stock: " + item[i].stockQuantity);
                return;
            }
        }
        System.out.println("No Item With Such Name");
    }
    public void DisplayStock(String title){
        for(int i=0;i<count;i++){
            if(equals(item[i].itemName,title)){
                System.out.println("Current Stock: " + item[i].stockQuantity + " Of " + item[i].itemName);
                return;
            }
        }
        System.out.println("No Item With Such Name");
    }
    public void displayItems(){
        for(int i =0; i<count;i++){
            System.out.println("Item Name: "+ item[i].itemName + " Stock Quantity: "+ item[i].stockQuantity);
        }
    }
}

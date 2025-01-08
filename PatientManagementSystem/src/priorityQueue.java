public class priorityQueue {
    private Patient[] queue;
    int size;
    priorityQueue(){
        queue = new Patient[2];
        size = 0;
    }
    public void resize(){
        Patient[] temp = new Patient[queue.length+2];
        for (int i=0; i< queue.length; i++){
            temp[i] = queue[i];
        }
        queue = temp;
    }
    public void addPatient(Patient newPatient) {
        if (size == queue.length) {
            resize();
        }
        queue[size++] = newPatient;

        // Apply merge sort on the queue array to sort by severity
        division(queue, 0, size - 1);
    }

    static void division(Patient[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        division(arr, start, mid);      // Sort the first half
        division(arr, mid + 1, end);   // Sort the second half
        Merge(arr, start, mid, end);   // Merge the two halves
    }

    static void Merge(Patient[] arr, int start, int mid, int end) {
        int array1_index = start;
        int array2_index = mid + 1;
        Patient[] merge = new Patient[end - start + 1];
        int i = 0;

        // Merge two sorted subarrays
        while (array1_index <= mid && array2_index <= end) {
            if (arr[array1_index].severity <= arr[array2_index].severity) {
                merge[i++] = arr[array1_index++];
            } else {
                merge[i++] = arr[array2_index++];
            }
        }

        // Copy remaining elements from the first subarray
        while (array1_index <= mid) {
            merge[i++] = arr[array1_index++];
        }

        // Copy remaining elements from the second subarray
        while (array2_index <= end) {
            merge[i++] = arr[array2_index++];
        }

        // Copy merged elements back to the original array
        for (int k = 0, j = start; k < merge.length; k++, j++) {
            arr[j] = merge[k];
        }
    }

    public Patient nextPatient(){
        return queue[0];
    }
    public Patient dequeue(){
        Patient nextPatient = queue[0];

        for (int i = 1; i<size-1; i++){
            queue[i-1] = queue[i];
        }
        size--;
        return nextPatient;
    }
    public void displayPatients(){
        for (int i=0; i< queue.length-1; i++){
            System.out.println(queue[i]+ " ");
        }
    }
}
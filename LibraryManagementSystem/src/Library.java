public class Library {
    private Book[] queue;
    int size;

    Library() {
        queue = new Book[5];
        size = 0;
    }

    public void resize() {
        Book[] b = new Book[queue.length + 2];
        for (int i = 0; i < queue.length; i++) {
            b[i] = queue[i];
        }
        queue = b;
    }

    public void addBook(Book newBook) {
        if (size == queue.length) {
            resize();
        }
        queue[size++] = newBook;

        mergeSort(queue, 0, size - 1);
    }

    public void mergeSort(Book[] book, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort(book, start, mid);
        mergeSort(book, mid + 1, end);
        merge(book, start, mid, end);
    }

    public void merge(Book[] book, int start, int mid, int end) {
        int arr1_index = start;
        int arr2_index = mid + 1;
        Book[] merge = new Book[end - start + 1];
        int i = 0;

        while (arr1_index <= mid && arr2_index <= end) {
            if (book[arr1_index].title.charAt(0) < book[arr2_index].title.charAt(0)) {
                merge[i++] = book[arr1_index++];
            } else {
                merge[i++] = book[arr2_index++];
            }
        }
        while (arr1_index <= mid) {
            merge[i++] = book[arr1_index++];
        }
        while (arr2_index <= end) {
            merge[i++] = book[arr2_index++];
        }

        for (int k = 0, j = start; k < merge.length; k++, j++) {
            book[j] = merge[k];
        }
    }

    public void displayBooks() {
        int k = 1;
        for (int i = 0; i < size; i++) {
            System.out.println(k + ") " + queue[i].title + " by " + queue[i].author + ", Copies: " + queue[i].availableCopies);
            k++;
        }
    }

    public Book searchBook(String title) {
        for (int i = 0; i < size ; i++) {
            if (queue[i].title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + queue[i].title + " by " + queue[i].author + ", Copies: " + queue[i].availableCopies);
                return queue[i];
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        for (int i = 0; i < size ; i++) {
            if (queue[i].title.equalsIgnoreCase(title) && queue[i].availableCopies > 0) {
                System.out.println("Book Borrowed: " + queue[i].title + " by " + queue[i].author + ", Copies: " + queue[i].availableCopies);
                queue[i].availableCopies--;
                return;
            } else {
                System.out.println("No Available Copies");
                return;
            }
        }
    }

    public void returnBook(String title) {

        for (int i = 0; i < size; i++) {
            if (queue[i].title == title) {
                System.out.println("Book Returned: " + queue[i].title + " by " + queue[i].author + ", Copies: " + queue[i].availableCopies);
                queue[i].availableCopies++;
                return;
            } else {
                System.out.println("No Available Copies");
                return;
            }
        }
    }
}

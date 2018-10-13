
import java.util.Scanner;
import java.util.ArrayList;

class Stock{
    String name;
    Double stock;
    Stock() {

    }
    Stock(String name, Double stock) {
        this.name = name;
        this.stock = stock;
    }
    String getName() {
        return name;
    }
    Double getStock() {
        return stock;
    }
    public int compareTo(Stock ll) {
        if (this.stock > ll.stock) {
            return 1;
        }
        if (this.stock < ll.stock) {
            return -1;
        }
        int compare = this.name.compareTo(ll.name);

        if (compare > 0) {
            return 1;
        } else if (compare < 0) {
            return -1;
        }
        return 0;
    }
}

class Storage {
    Stock[] stk;
    int size;
    Storage() {
        stk = new Stock[50];
        size = 0;
    }
    void addToList(Stock s) {
        stk[size++] = s;
    }
    int getsize() {
        return size;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += stk[i].name + " " + stk[i].stock + "\n";
        }
        return s;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(stk, j, min)) {
                    min = j;
                }
            }
            swap(stk, i, min);
        }

    }
    public void swap(Stock[] stk, int i, int j) {
        Stock ct = stk[j];
        stk[j] = stk[i];
        stk[i] = ct;
    }
    boolean less(Stock[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) > 0;
    }
}


class Solution {
    private Solution() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BinarysearchST<String, Integer> bst = new
        BinarysearchST<String, Integer>(2);
        int t1 = t;
        sc.nextLine();
        for (int i = 0; i<6; i++) {
            t = t1;
            if (i == 0) {
                Minpq<String> minpq = new Minpq<String>();
                Maxpq<String> maxpq = new Maxpq<String>();
                Storage sa = new Storage();

                while (t > 0) {
                    t--;
                    String[] line = sc.nextLine().split(",");
                    Stock st = new Stock(line[0], Double.parseDouble(line[1]));
                    sa.addToList(st);
                    minpq.insert(line[1]);
                    maxpq.insert(line[1]);
                }
                                // System.out.println("-------------------------------");

                sa.selectionSort();
                                // System.out.println("-------------------------------");

                for (int k = 0; k < 5; k++) {
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());
                }

                // System.out.println("-------------------------------");

                System.out.println();
                int arrsize = sa.getsize();
                                for (int k = arrsize - 1; k >= arrsize - 5; k--) {
    
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());

                }
                                // System.out.println("-------------------------------");

                System.out.println();

            } else {
                Storage sa = new Storage();
                Minpq<String> minpq1 = new Minpq<String>();
                Maxpq<String> maxpq1 = new Maxpq<String>();
                while (t > 0) {
                    t--;

                    String[] line = sc.nextLine().split(",");
                    Stock st = new Stock(line[0], Double.parseDouble(line[1]));
                    sa.addToList(st);

                    minpq1.insert(line[1]);
                    maxpq1.insert(line[1]);


                }
                                // System.out.println("-------------------------------");

                sa.selectionSort();
                                // System.out.println("-------------------------------");

                for (int k = 0; k < 5; k++) {
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());
                }
                System.out.println();
                int arrsize = sa.getsize();
                for (int k = arrsize - 1; k >= arrsize - 5; k--) {
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());
                }

                System.out.println();

            }
        }
        int query = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < query; i++) {
            String[] line = sc.nextLine().split(",");
        }
                        // System.out.println("-------------------------------");

    }

}
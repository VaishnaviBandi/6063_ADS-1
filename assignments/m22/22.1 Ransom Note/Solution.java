import java.util.Scanner;
class Node {
    private String data;
    private int count = 1;
    private Node next = null;
    Node(final String d) {
        data = d;
    }
    public String getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(final Node n) {
        next = n;
    }
    public int getCount() {
        return count;
    }
    public void setCount(final int count1) {
        count = count1;
    }
}
class Linkedlist {
    private Node head = null;
    public Node getHead() {
        return head;
    }
    public void insert(final String word) {
        Node newnode = new Node(word);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            boolean flag = false;
            while (temp != null) {
                if (temp.getData().equals(word)) {
                    flag = true;
                    temp.setCount(temp.getCount() + 1);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            if (!flag) {
                newnode.setNext(head);
                head = newnode;
            }
        }
    }
}
class Hashing {
    private Linkedlist[] hash;
    private int size;
    Hashing(final int size1) {
        size = size1;
        hash = new Linkedlist[size1];
    }
    public int key(final String value) {
        return Math.abs(value.hashCode() % size);
    }
    public void insert(final String word, final int pos) {
        if (hash[pos] == null) {
            Linkedlist l = new Linkedlist();
            l.insert(word);
            hash[pos] = l;
        } else {
            hash[pos].insert(word);
        }
    }
    public Linkedlist[] getHash() {
        return hash;
    }
}
class RansomNote {
    private int magazinesize;
    private int notesize;
    private String[] magazine;
    private String[] note;
    private Hashing h;
    RansomNote(final int msize, final int nsize, final String[] magazines,
               final String[] notes) {
        magazinesize = msize;
        notesize = nsize;
        magazine = magazines;
        note = notes;
        h = new Hashing(magazinesize);
    }
    public void creatingHashtable() {
        for (int i = 0; i < magazinesize; i++) {
            int pos = h.key(magazine[i]);
            h.insert(magazine[i], pos);
        }
    }
    public void checking() {
        Linkedlist[] hashtable = h.getHash();
        for (int i = 0; i < notesize; i++) {
            int pos = h.key(note[i]);
            int flag = 0;
            Node temp = hashtable[pos].getHead();
            while (temp != null) {
                if (temp.getData().equals(note[i])) {
                    if (temp.getCount() > 0) {
                        flag = 1;
                        temp.setCount(temp.getCount() - 1);
                        break;
                    } else {
                        System.out.println("No");
                        return;
                    }
                } else {
                    temp = temp.getNext();
                }
            } if (flag == 0) {
                System.out.println("No");
                return;
            }

        }
        System.out.println("Yes");
    }

}
final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int magazinesize = sc.nextInt();
        int notesize = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        RansomNote r = new RansomNote(magazinesize, notesize, magazine, note);
        r.creatingHashtable();
        r.checking();
    }
}
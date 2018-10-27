import java.util.Scanner;
import java.util.Iterator;
/**.
 * Class for solution.
 */
class Solution {
    /**.
     * Constructs the object.
     */
    Solution() {
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentData = sc.nextInt();
        //System.out.println(studentData);
        sc.nextLine();
        SeparateChainingHashST<Integer, Student> schain = new
        SeparateChainingHashST<>();
        Student s = new Student();
        int i = 0;
        while (i < studentData) {
            String strng = sc.nextLine();
            String darray[] = strng.split(",");
            s = new Student(darray[1], darray[2]);
            schain.put(Integer.parseInt(darray[0]), s);
            i++;
        }
        int j = sc.nextInt();
        sc.nextLine();
        int k = 0;
        while (k < j) {
            // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String karray[] = sc.nextLine().split(" ");
            if (karray[2].equals("1")) {
                // System.out.println("ifff");
                int key = Integer.parseInt(karray[1]);
                if (schain.contains(key)) {
                    System.out.println(schain.get(key).stuName);
                    // System.out.println("@@@@@@@@@@@@");
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            if (karray[2].equals("2")) {
                // System.out.println("nono@@@@@@@@@@@@");
                int key = Integer.parseInt(karray[1]);
                if (schain.contains(key)) {
                    System.out.println(schain.get(key).stuMarks);
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            k++;
        }
    }
}
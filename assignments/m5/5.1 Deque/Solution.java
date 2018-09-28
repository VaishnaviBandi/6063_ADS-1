import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque obj = new Deque();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "isEmpty":
                    System.out.println(obj.isEmpty());
                    break;
                case "size":
                    System.out.println(obj.size());
                    break;
                case "pushLeft":
                    obj.pushLeft(Integer.parseInt(
                        tokens[1]));
                    break;
                case "pushRight":
                    obj.pushRight(Integer.parseInt(
                        tokens[1]));
                    break;
                case "popLeft":
                    obj.popLeft();
                    break;
                case "popRight":
                    obj.popRight();
                    break;
                default : break;
            }

        }

    }
}
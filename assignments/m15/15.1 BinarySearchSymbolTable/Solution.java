import java.util.Scanner;
/**
 * { item_description }
 */
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @param args value
     * Time complexity is O(N)
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        Binarysearch bs = new Binarysearch();
        for (int i = 0; i < str.length; i++) {
            bs.put(str[i], i);
        }
        while (s.hasNextLine()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
                case "max":
                System.out.println(bs.max());
                        break;
                case "floor":
                System.out.println(bs.floor(tokens[1]));
                        break;
                case "rank":
                System.out.println(bs.rank(tokens[1]));
                        break;
                case "deleteMin":
                        bs.deleteMin();
                        break;
                case "contains":
                System.out.println(bs.contains(tokens[1]));
                        break;
                case "keys":
                System.out.println(bs.keys());
                        break;
                case "get":
                System.out.println(bs.get(tokens[1]));
                        break;
                default:
                        break;
            }
        }
    }
}

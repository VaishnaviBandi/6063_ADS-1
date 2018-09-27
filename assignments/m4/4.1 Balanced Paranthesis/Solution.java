/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * Class for linked stack of strings.
 */
class LinkedStackOfStrings {
    /**
     * { var_description }.
     */
    private Node first = null;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        char element;
        /**
         * { var_description }.
         */
        Node nextAddress;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public char top() {
        return first.element;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * { function_description }.
     *
     * @param      element  The element
     */
    public void push(char element) {
        Node old = first;
        first = new Node();
        first.element = element;
        first.nextAddress = old;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public char pop() {
        char element = first.element;
        first = first.nextAddress;
        return element;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String line = sc.next();
            if (checkParanthesis(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static boolean checkParanthesis(final String s) {
        LinkedStackOfStrings obj = new LinkedStackOfStrings();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                obj.push(ch);
            } else {
                if (obj.isEmpty()) {
                    return false;
                }
                if (ch == ')' && obj.top() == '(') {
                obj.pop();
            } else if (ch == '}' && obj.top() == '{') {
                obj.pop();
            } else if (ch == ']' && obj.top() == '[') {
                obj.pop();
            } else {
                return false;
            }
        }
    }
    return obj.isEmpty();
}
}
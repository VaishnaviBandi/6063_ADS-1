import java.util.Scanner;
/**.
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**.
     * Constructs the object.
     */
    private AddLargeNumbers() { }
    /**.
     * { function_description }
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList obj = new LinkedList();
        String[] digits = number.split("");
        for (int i = 0; i < digits.length; i++) {
            obj.addEnd(Integer.parseInt(digits[i]));
        }
        return obj;
    }
    /**.
     * { fun.ction_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.toString();
    }
    /**.
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
public static LinkedList addLargeNumbers(final LinkedList list1,
    final LinkedList list2) {
        LinkedList obj = new LinkedList();
        int size = 0;
        if (list1.getSize() > list2.getSize()) {
            size = list1.getSize();
        } else {
            size = list2.getSize();
        }
        int carry = 0, num = 0;
        final int ten = 10;
        for (int i = size; i > 0; i--) {
            num = list1.removeEnd() + list2.removeEnd();
            num = num + carry;
            carry = num / ten;
            num = num % ten;
            obj.addBeg(num);
        }
        if (carry > 0) {
            obj.addBeg(carry);
        }
        return obj;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
pDigits = AddLargeNumbers.numberToDigits(p);
qDigits = AddLargeNumbers.numberToDigits(q);
LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
            default:
            break;
        }
    }

}


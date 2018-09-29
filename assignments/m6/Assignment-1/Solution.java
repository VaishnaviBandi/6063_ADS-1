import java.util.Scanner;
class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList obj = new LinkedList();
		String[] digits = number.split("");
		for (int i = 0; i < digits.length; i++) {
			obj.addEnd(Integer.parseInt(digits[i]));
		}
		return obj;
	}
	public static String digitsToNumber(LinkedList list) {
		return list.toString();
	}

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		LinkedList obj = new LinkedList();
		int size = 0;
		if (list1.getSize()> list2.getSize()){
			size = list1.getSize();
		} else{
			size = list2.getSize();
		}
		int carry=0,num=0;
		for(int i = size; i >0;i--){
			num = list1.removeEnd()+ list2.removeEnd();
			num = num +carry;
			carry =num /10;
			num =num %10;
			obj.addBeg(num);
		}
		if(carry> 0){
			obj.addBeg(carry);
		}
		return obj;
	}
}

public class Solution {
	public static void main(String[] args) {
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
		}
	}

}

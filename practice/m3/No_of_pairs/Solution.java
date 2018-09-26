import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NoOfPairs pairs = new NoOfPairs();
		int input = Integer.parseInt(sc.nextLine());
		int[] array = new int[input];
		for (int i = 0; i < input; i++){
			array[i] = Integer.parseInt(sc.nextLine());
		}
		System.out.println(pairs.countofpairs(array));
	}
}

class NoOfPairs{
	NoOfPairs() { }
	public int countofpairs(int[] array){
		int count = 0;
		int temp = 0;
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		for(int i = 0; i< array.length; i++) {
			if(temp < array.length - 1){
				temp++;
			}
			if (array[i] == array[temp]) {
				count++;
			}
		}
		return count;
	}
}

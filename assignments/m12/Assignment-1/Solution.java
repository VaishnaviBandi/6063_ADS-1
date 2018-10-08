import java.util.Scanner;

class Student {
	String name;
	int[] dob;
	int marks1;
	int marks2;
	int marks3;
	int totalMarks;
	String category;
	Student(String name, int[] dob, int marks1, int marks2, int marks3, int totalMarks, String category) { 
		this.name = name;
        this.dob = dob;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.totalMarks = totalMarks;
        this.category = category;
	}
	public String getName() {
		return name;
	}
	public int[] getdob() {
		return dob;
	}
	public int getMarks1() {
		return marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public String getCategory() {
		return category;
	}


	public int compareTo(Student s) {
		if (this.totalMarks > s.totalMarks) {
			return 1;
		}
		if (this.totalMarks < s.totalMarks) {
			return -1;
		}
		if (this.marks3 > s.marks3) {
			return 1;
		}
		if (this.marks3 < s.marks3) {
			return -1;
		}
		if (this.marks2 < s.marks2) {
			return 1;
		}
		if (this.marks2 > s.marks2) {
			return -1;
		}
		if (this.dob[0] < s.dob[0]
		        && this.dob[1] < s.dob[1]
		        && this.dob[2] < s.dob[2]) {
			return 1;
		}
		if (this.dob[0] > s.dob[0]
		        && this.dob[1] > s.dob[1]
		        && this.dob[2] > s.dob[2]) {
			return -1;
		}
		return 0;

	}
}
// public void sorting() {
//         int max = 0;
//         int flag = 0;
//         for (int i = 0; i < list.size(); i++) {
//             max = i;
//             for (int j = i + 1; j < list.size(); j++) {
//                 flag = compareTo(list.get(max), list.get(j));
//                 if (flag == -1) {
//                     max = j;
//                 }
//             }
//             Collections.swap(list, i, max);
//         }
//     }



	public class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int jj = sc.nextInt();
			int num = sc.nextInt();
			int noVac = sc.nextInt();
			int catBC = sc.nextInt();
			int catSC = sc.nextInt();
			int catST = sc.nextInt();
			sc.nextLine();
			InfoList cr = new InfoList();
			while (jj > 0) {
				jj--;
				String[] line = sc.nextLine().split(",");
				String[] vari = line[1].split("-");
				int[] nt = new int[3];
				nt[0] = Integer.parseInt(vari[2]);
				nt[1] = Integer.parseInt(vari[2]);
				nt[2] = Integer.parseInt(vari[2]);
				Student s = new Student(line[0], nt,
				                        Integer.parseInt(line[2]),
				                        Integer.parseInt(line[3]),
				                        Integer.parseInt(line[4]),
				                        Integer.parseInt(line[5]),
				                        line[6]);
				cr.add(s);
			}
			System.out.println(cr);
			System.out.println();
			cr.Sort();
			System.out.println(cr);
		}
	}
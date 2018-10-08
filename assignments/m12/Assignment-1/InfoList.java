class InfoList {
	Student[] students;
	int size;
	InfoList() {
		size = 0;
		students = new Student[100];
	}
	void add(Student s) {
		students[size++] = s;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += students[i].name + "," + students[i].totalMarks + "," + students[i].category + "\n";
		}
		return s;
	}
	public void Sort() {
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (comp(students, j, min)) {
					min = j;
				}
			}
			swap(students, i, min);
		}
	}
	public void swap(Student[] people, int i, int j) {
		Student stu = students[j];
		students[j] = students[i];
		students[i] = stu;
	}
	boolean comp(Student[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
}
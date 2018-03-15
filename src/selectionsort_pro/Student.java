package selectionsort_pro;

public class Student implements Comparable<Student> {

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student o) {
		if (this.score < o.score) {
			return -1;
		} else if (this.score > o.score) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

}

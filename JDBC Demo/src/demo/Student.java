package demo;

public class Student {
	private int id;
	private String name;
	private String dept;
	private String year;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String dept, String year) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}

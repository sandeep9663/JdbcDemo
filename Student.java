package jdbc;

public class Student {

	
	int id;
	String name;
	
	public Student() {
		super();
		
	}
	
	public Student(int id,String name ) {
		
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		
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
	
	
	public static void main(String[] args) {
		Student s1= new Student();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}

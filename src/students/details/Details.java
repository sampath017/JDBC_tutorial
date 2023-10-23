package students.details;

public class Details {
	private int id=0;
	private String name;
	private int age;
	
	public Details(String name, int age) {
		this(-1, name, age);
	}
	
	public Details(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

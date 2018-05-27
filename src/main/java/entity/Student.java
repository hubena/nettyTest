package entity;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;  
	private Integer age;
	private List<String> friends;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the friends
	 */
	public List<String> getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", friends=" + friends + "]";
	}
	
	
	
}

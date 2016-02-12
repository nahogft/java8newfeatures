package org.learning.java8newfeatures.exercises.utils.templates;

import java.time.LocalDate;

public class Person {
	String name;
	private LocalDate birthday;

	public Person(String name, LocalDate birthday) {
		this.name = name;
		this.setBirthday(birthday);
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + getBirthday() + "]";
	}


}

package org.learning.java8newfeatures.exercise1.methodreferences.solutions;

import java.time.LocalDate;

public class Person {
	String name;
	private LocalDate birthday;

	public Person(String name, LocalDate birthday) {
		this.name = name;
		this.setBirthday(birthday);
	}

	public static int compareByAge(Person a, Person b) {
		return a.getBirthday().compareTo(b.getBirthday());
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

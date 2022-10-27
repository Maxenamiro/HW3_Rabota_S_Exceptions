package com.gmail.maxenamiro;

import java.util.Arrays;

public class Group {
	private String groupName;
	private final Student[] students = new Student[10];

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return;
			}
		}
		throw new GroupOverflowException("У цій группі немає місця для нового студента");
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName().equals(lastName)) {
					return students[i];
				}
			}
		}
		throw new StudentNotFoundException("Такого студента в цій группі немає");
	}

	public boolean removeStudentById(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}
}

package application;

import java.util.ArrayList;

public class StudentRegister {

	private ArrayList<Student> studentList = new ArrayList<Student>(); 

	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public Student findStudent(String studentID) {
		for(Student s : studentList) {
			if(s.getStudentID().equals(studentID)) {
				return s;
			}
		}
		return null;	
	}

	public Student removeStudent(String studentID) {
		Student s = this.findStudent(studentID);
		if (s != null) {
			studentList.remove(s);
			return s;
		}
		return null;		
	}
}


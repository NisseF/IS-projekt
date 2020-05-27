package application;

import java.util.ArrayList;

public class Student {

	private String studentID;
	private String name;
	private ArrayList<Result> resultStudent = new ArrayList<Result>();
	private static int iDNumber = 10000; 

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Result> getResultStudent() {
		return resultStudent;
	}

	public void setResultStudent(ArrayList<Result> resultStudent) {
		this.resultStudent = resultStudent;
	}

	public static int getiDNumber() {
		return iDNumber;
	}

	public static void setiDNumber(int iDNumber) {
		Student.iDNumber = iDNumber;
	}

	public Student(String name) {
		this.createStudentID();
		this.setName(name);
	}

	public void createStudentID() {
		if (iDNumber != 100000) {
			this.setStudentID("S" + String.valueOf(iDNumber++)); 
		}
	}

	public void addResultOnExam(Result r, WrittenExam w) {
		resultStudent.add(r);
		r.setWrittenExam(w);
	}

	public String getStudentsResultsForAllExams() {
		String s = (""); // This has to be initialized in order for multiple exams to be added to the String.
		for (Result r : this.getResultStudent()) {
			WrittenExam w = r.getWrittenExam();
			s += ("\nExam: " + w.getExamID() + " - Part of Course: " + w.getCourse().getName() + "\n\t Result: " + r.getResult() + "\n\t Grade: " + r.getLetterGrade());
		}
		return s;
	}

	public Result findStudentsResultOnExam(WrittenExam w) {
		for (Result r : w.getResultWrittenExam()) {
			if (r.getStudent().getStudentID().equals(this.getStudentID())) {
				return r;
			}
		}
		return null;
	}

	public boolean isStringOnlyAlphabet(String str) { 
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z Â‰ˆ≈ƒ÷]*$"))); 
	}
}

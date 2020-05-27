package application;

import java.util.ArrayList;

public class Course {

	private String courseCode;
	private String name;
	private double credits;
	private ArrayList<WrittenExam> examList = new ArrayList<WrittenExam>();
	private static int code = 10000;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public ArrayList<WrittenExam> getExamList() {
		return examList;
	}

	public void setExamList(ArrayList<WrittenExam> examList) {
		this.examList = examList;
	}

	public static int getCode() {
		return code;
	}
	public static void setCode(int code) {
		Course.code = code;
	}

	public Course(String name, double credits) {
		this.createCourseCode();
		this.setName(name);
		this.setCredits(credits);
	}

	public void createCourseCode() {
		if (code != 100000) {
			this.setCourseCode("C" + String.valueOf(code++)); 
		}
	}

	public void addWrittenExamToCourse(WrittenExam addWrittenExam) {
		examList.add(addWrittenExam);
	}

	public WrittenExam findWrittenExam(String examID) {
		for (WrittenExam a : examList) {
			if (a.getExamID().equals(examID)) {
				return a;
			}
		}
		return null;
	}

	public WrittenExam removeWrittenExamFromCourse(String examID) {
		for (WrittenExam w : examList) {
			if (w.getExamID().equals(examID)) {
				examList.remove(w);			
				return w;
			}
		}
		return null;
	}

	public String getAllWrittenExamsAndAllResults() {
		String s = ("");
		for (WrittenExam w : this.getExamList()) {
			s += ("\n\tExam: " + w.getExamID() + "\n\tResults: ");
			for (Result r : w.getResultWrittenExam()) {
				s += ("\n\t" + r.getResult() + " - Grade:  " +  r.getLetterGrade() + " - by student " + r.getStudent().getStudentID());
			}
		}
		return s;
	}
}

package application;

import java.util.ArrayList;

public class CourseRegister {

	private ArrayList<Course> courseList = new ArrayList<Course>();

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}

	public Course findCourse(String courseCode) {
		for (Course c : courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}

	public Course removeCourse(String courseCode) {
		Course tmp = this.findCourse(courseCode);
		if (tmp != null) {
			for (WrittenExam w : tmp.getExamList()) {
				tmp.removeWrittenExamFromCourse(w.getExamID()); //Removes exams from course according to assignment model. 
			}
			courseList.remove(tmp);
			return tmp;
		}
		return null;
	}

	public WrittenExam findWrittenExam(String examID) {
		for (Course c : courseList) {
			for (WrittenExam e : c.getExamList()) {
				if (e.getExamID().equals(examID)) {
					return e;
				}
			}
		}
		return null;
	}
}

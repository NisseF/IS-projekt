package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class WrittenExam {

	private String examID;
	private LocalDate date;
	private String location;
	private String time;
	private Course course;
	private ArrayList<Result> resultWrittenExam = new ArrayList<Result>();
	private static int iDNumber = 10000;
	private double maxPoints; // If you in the future want to change maxPoint. 
	private final double MAX_POINTS = 100; // MaxPoints is always 100 according to assignment. 

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ArrayList<Result> getResultWrittenExam() {
		return resultWrittenExam;
	}

	public void setResultWrittenExam(ArrayList<Result> resultWrittenExam) {
		this.resultWrittenExam = resultWrittenExam;
	}

	public static int getiDNumber() {
		return iDNumber;
	}

	public static void setiDNumber(int iDNumber) {
		WrittenExam.iDNumber = iDNumber;
	}

	public double getMaxPoints() { 
		return maxPoints;
	}

	public void setMaxPoints(double maxPoints) {
		this.maxPoints = maxPoints;
	}

	public double getMAX_POINTS() { // No setMethod for final variable.
		return MAX_POINTS;
	}

	public WrittenExam(LocalDate date, Course course, String time, String location) {
		for (WrittenExam tmp : course.getExamList()) {
			if (date.equals(tmp.getDate()) && location.equals(tmp.getLocation()) && time.equals(tmp.getTime())) {
				throw new IllegalArgumentException(); // Unique location, time, date.
			}
		}
		this.createExamID();
		this.setDate(date);
		this.setLocation(location);
		this.setTime(time);
		this.setMaxPoints(MAX_POINTS);
		this.setCourse(course);
	}

	public void createExamID() {
		if (iDNumber != 100000) {
			this.setExamID("E" + String.valueOf(iDNumber++)); // Increases with one for every new ID created 
		}
	}

	public void addResultToResultList(Result result) {
		this.getResultWrittenExam().add(result);
	}

	public String getAllResultsOnExam() {
		String s = (""); // This has to be initialized in order for multiple results to be added to the String.
		for (Result r : this.getResultWrittenExam()) {
			s += ("\nStudent: " + r.getStudent().getStudentID() + ", " + r.getStudent().getName() + ", Result: "
					+ r.getResult() + ",  Grade: " + r.getLetterGrade());
		}
		return s;
	}

	public double averageResult() {
		double sum = 0;
		for (Result r : resultWrittenExam) {
			sum += r.getResult();
		}
		double average = sum / resultWrittenExam.size();
		return average;
	}

	public int passedStudents() {
		int passed = 0;
		for (Result r : resultWrittenExam) {
			if (!r.getLetterGrade().equals("Fail")) {
				passed++;
			}
		}
		return passed;
	}

	public double medianResult() {
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		for(Result r : this.getResultWrittenExam()) {
			scoreList.add((int) r.getResult());
		}
		Collections.sort(scoreList);
		double middle = scoreList.size()/2;
		if (scoreList.size()%2 == 1) { // checks if median is even number or inbetween numbers.
			middle = scoreList.get((int)scoreList.size()/2);
		} else {
			double upperMiddle = (scoreList.get((int)scoreList.size()/2));
			double lowerMiddle = (scoreList.get((int)scoreList.size()/2 - 1));
			middle = (upperMiddle + lowerMiddle) / 2;
		}
		return middle;
	}
}

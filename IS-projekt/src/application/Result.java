package application;

public class Result {

	private double result;
	private String letterGrade;
	private WrittenExam writtenExam;
	private Student student;

	public void setResult(double result) {
		if (result > this.getWrittenExam().getMaxPoints()) {
			throw new IllegalArgumentException(); // Throws an exception which is catched in btnRegisterResultForStudent. 
		} else {
			this.result = result;
			this.transformResultToLetterGrade(result); 
		}
	}

	public double getResult() {
		return result;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public WrittenExam getWrittenExam() {
		return writtenExam;
	}

	public void setWrittenExam(WrittenExam writtenExam) {
		this.writtenExam = writtenExam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void transformResultToLetterGrade(double result) { 
		double percentage = result / writtenExam.getMaxPoints() * 100; // If the maxPoints would change in future. 

		if (percentage >= 85 && percentage <= 100) {
			this.setLetterGrade("A");
		}
		if (percentage >= 75 && percentage <= 84) {
			this.setLetterGrade("B");
		}
		if (percentage >= 65 && result <= 74) {
			this.setLetterGrade("C");
		}
		if (percentage >= 55 && percentage <= 64) {
			this.setLetterGrade("D");
		}
		if (percentage >= 50 && percentage <= 54) {
			this.setLetterGrade("E");
		}
		if (percentage >= 0 && percentage <= 49) {
			this.setLetterGrade("Fail");
		}
	}

	public Result(Student s, WrittenExam w, double result) { // The result is set for one student on one exam
		this.setStudent(s);
		this.setWrittenExam(w);
		this.setResult(result);
	}
}

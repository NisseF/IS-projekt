package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class Controller {

	StudentRegister studentReg = new StudentRegister();
	CourseRegister courseReg = new CourseRegister();

	//Lists for ComboBoxes
	ObservableList<String> studentIDs = FXCollections.observableArrayList(); 
	ObservableList<String> courseCodes = FXCollections.observableArrayList();
	ObservableList<String> examIDs = FXCollections.observableArrayList();
	ObservableList<String> timeHour = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
	ObservableList<String> timeMinute = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
			"43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
	ObservableList<String> locations = FXCollections.observableArrayList("Room A123", "Room A167", "Room B198",
			"Room B067");

	//Student
	@FXML
	private ComboBox<String> cBoxStudentIDsStudent;
	@FXML 
	private TextField txtStudentName;
	@FXML
	private TextArea txtStudentArea;

	//Course
	@FXML
	private ComboBox<String> cBoxCourseCodeCourse;
	@FXML
	private TextField txtCourseName;
	@FXML
	private TextField txtCredits;
	@FXML
	private TextArea txtCourseArea;

	//Written Exam
	@FXML
	private ComboBox<String> cBoxCourseCodeWrittenExam;
	@FXML
	private Label lblCourseName;
	@FXML
	private DatePicker datePickerDateWrittenExam;
	@FXML
	private ComboBox<String> cBoxLocation;
	@FXML
	private ComboBox<String> txtTimeHour;
	@FXML
	private ComboBox<String> txtTimeMinute;
	@FXML
	private TextField txtMaxPoints;
	@FXML
	private ComboBox<String> cBoxExamIDsWrittenExam;
	@FXML
	private TextArea txtWrittenExamArea;

	//Result
	@FXML
	private ComboBox<String> cBoxStudentIDsResult;
	@FXML
	private ComboBox<String> cBoxExamIDsResult;
	@FXML
	private TextField txtRegisterResultStudentName;
	@FXML
	private TextField txtExamResult;
	@FXML
	private TextArea txtRegisterResultArea;

	@FXML
	public void initialize() {

		//Connecting lists with comboBoxes
		cBoxStudentIDsStudent.setItems(studentIDs);
		cBoxStudentIDsResult.setItems(studentIDs);
		cBoxCourseCodeCourse.setItems(courseCodes);
		cBoxCourseCodeWrittenExam.setItems(courseCodes);
		cBoxLocation.setItems(locations);
		cBoxExamIDsWrittenExam.setItems(examIDs);
		cBoxExamIDsResult.setItems(examIDs);
		txtTimeHour.setItems(timeHour);
		txtTimeMinute.setItems(timeMinute);

		//Updates certain fields as comboBox is changed.
		cBoxStudentIDsStudent.setOnAction(e -> updateStudentName());
		cBoxCourseCodeCourse.setOnAction(e -> updateCourseFields());
		cBoxStudentIDsResult.setOnAction(e -> registerResultFindStudentName());
		cBoxCourseCodeWrittenExam.setOnAction(e -> findCourseName());

		//Testdata Student
		Student student1 = new Student ("Louise Carlsheimer");
		Student student2 = new Student ("Nils Folcker");
		Student student3 = new Student ("Cecilia Minder");
		Student student4 = new Student ("Irma Björkqvist");

		studentReg.addStudent(student1);
		studentReg.addStudent(student2);
		studentReg.addStudent(student3);
		studentReg.addStudent(student4);

		studentIDs.add(student1.getStudentID());
		studentIDs.add(student2.getStudentID());
		studentIDs.add(student3.getStudentID());
		studentIDs.add(student4.getStudentID());

		//Testdata Course
		Course course1 = new Course ("Information Systems", 30);
		Course course2 = new Course ("Programming", 10);
		Course course3 = new Course ("Economics", 15);
		Course course4 = new Course ("Business Law", 30);
		Course course5 = new Course ("Organisation", 45);

		courseReg.addCourse(course1);
		courseReg.addCourse(course2);
		courseReg.addCourse(course3);
		courseReg.addCourse(course4);
		courseReg.addCourse(course5);

		courseCodes.add(course1.getCourseCode());
		courseCodes.add(course2.getCourseCode());
		courseCodes.add(course3.getCourseCode());
		courseCodes.add(course4.getCourseCode());
		courseCodes.add(course5.getCourseCode());

		//Testdata WrittenExam
		WrittenExam exam1 = new WrittenExam(LocalDate.parse("2019-10-20"), course1, "08:00", "Room B198");
		WrittenExam exam2 = new WrittenExam(LocalDate.parse("2020-02-14"), course1, "13:30", "Room A123");
		WrittenExam exam3 = new WrittenExam(LocalDate.parse("2018-05-05"), course3, "10:00", "Room B198");
		WrittenExam exam4 = new WrittenExam(LocalDate.parse("2019-12-01"), course4, "09:15", "Room A167");
		WrittenExam exam5 = new WrittenExam(LocalDate.parse("2019-12-22"), course4, "15:00", "Room A167");
		WrittenExam exam6 = new WrittenExam(LocalDate.parse("2016-11-05"), course4, "11:00", "Room B067");
		WrittenExam exam7 = new WrittenExam(LocalDate.parse("2020-03-12"), course5, "12:00", "Room B067");

		course1.addWrittenExamToCourse(exam1);
		course1.addWrittenExamToCourse(exam2);
		course3.addWrittenExamToCourse(exam3);
		course4.addWrittenExamToCourse(exam4);
		course4.addWrittenExamToCourse(exam5);
		course4.addWrittenExamToCourse(exam6);
		course5.addWrittenExamToCourse(exam7);

		examIDs.add(exam1.getExamID());
		examIDs.add(exam2.getExamID());
		examIDs.add(exam3.getExamID());
		examIDs.add(exam4.getExamID());
		examIDs.add(exam5.getExamID());
		examIDs.add(exam6.getExamID());

		//Testdata Result 
		Result result1Student1 = new Result (student1, exam1, 87);
		Result result2Student1 = new Result (student1, exam3, 52);
		Result result3Student1 = new Result (student1, exam4, 92);
		Result result1Student2 = new Result (student2, exam1, 44);
		Result result2Student2 = new Result (student2, exam6, 44);
		Result result1Student3 = new Result (student3, exam4, 78);
		Result result2Student3 = new Result (student3, exam5, 64);
		Result result1Student4 = new Result (student4, exam6, 100);
		Result result2Student4 = new Result (student4, exam6, 100);

		exam1.addResultToResultList(result1Student1);
		exam1.addResultToResultList(result1Student2);
		exam1.addResultToResultList(result1Student4);
		exam3.addResultToResultList(result2Student1);
		exam4.addResultToResultList(result3Student1);
		exam4.addResultToResultList(result1Student3);
		exam5.addResultToResultList(result2Student3);
		exam6.addResultToResultList(result2Student2);
		exam6.addResultToResultList(result2Student4);

		student1.addResultOnExam(result1Student1, exam1);
		student1.addResultOnExam(result2Student1, exam3);
		student1.addResultOnExam(result3Student1, exam4);
		student2.addResultOnExam(result1Student2, exam1);
		student2.addResultOnExam(result2Student2, exam6);
		student3.addResultOnExam(result1Student3, exam4);
		student3.addResultOnExam(result2Student3, exam5);
		student4.addResultOnExam(result1Student4, exam6);
		student4.addResultOnExam(result2Student4, exam1);
	}

	@FXML
	private void updateStudentName() {
		String id = (String) cBoxStudentIDsStudent.getValue();
		Student s = studentReg.findStudent(id);
		if (s != null) {
			txtStudentName.setText(s.getName());
		}	
	}

	@FXML
	private void updateCourseFields() {
		String cCode = (String) cBoxCourseCodeCourse.getValue();
		Course c = courseReg.findCourse(cCode);
		if (c != null) {
			txtCourseName.setText(c.getName());
			txtCredits.setText(""+ c.getCredits()); 
		}		
	}

	@FXML
	private void registerResultFindStudentName() {
		String id = (String) cBoxStudentIDsResult.getValue();
		Student s = studentReg.findStudent(id);
		if (s != null) {
			txtRegisterResultStudentName.setText(s.getName());
		}
	}

	@FXML
	private void findCourseName() {	
		String cCode = (String) cBoxCourseCodeWrittenExam.getValue();
		Course c = courseReg.findCourse(cCode);
		if (c != null) {
			lblCourseName.setText(c.getName());	
		}
	}

	@FXML
	public void btnCreateStudent(ActionEvent event) {
		String name = txtStudentName.getText();
		Student s = new Student(name);
		if (s.getStudentID() != null) {
			if(s.isStringOnlyAlphabet(name) == true) {
				studentReg.addStudent(s);
				studentIDs.add(s.getStudentID()); // Adds the created studentID to the list in ComboBox
				txtStudentArea.setText(
						"New student " + s.getName() + " has been assigned student ID " + s.getStudentID());
				txtStudentName.setText(""); // Removes the text from Student name field, so that you cannot spam "add student". 
			} else {
				if(name.isEmpty()){  // Spaces is accepted (known bug), but this handles empty field.
					txtStudentArea.setText("The student name field is empty.");
				} else {
					txtStudentArea.setText(name + " is not a valid name, please only use letters, valid characters is a-ö, A-Ö.");
				}
			}
		} else {
			txtStudentArea.setText("The maximum number of students have been created."
					+ "\nPlease contact your awesome programmers. ");
		}
	}

	@FXML
	public void btnDeleteStudent(ActionEvent event) {
		String id = (String) cBoxStudentIDsStudent.getValue();
		Student s = studentReg.findStudent(id);
		String studentName = txtStudentName.getText(); // Saves old name here in order to inform the name of the student which has been deleted.
		if (s != null) {
			studentReg.removeStudent(id);
			cBoxStudentIDsStudent.setValue(null);
			txtStudentName.setText("");
			int i = studentIDs.indexOf(id);
			studentIDs.remove(i); // Removes the Student ID from list in ComboBox
			txtStudentArea.setText(studentName + " with ID " + s.getStudentID() + " has been deleted");

		} else {
			txtStudentArea.setText("Please pick a student ID.");
		}
	}

	@FXML
	public void btnUpdateStudent(ActionEvent event) {
		String id = (String) cBoxStudentIDsStudent.getValue();
		String name = txtStudentName.getText();
		Student s = studentReg.findStudent(id);
		if (s != null) {
			if(s.isStringOnlyAlphabet(name) == true) {
				studentReg.findStudent(id).setName(name);
				txtStudentArea.setText("The student with ID " + s.getStudentID() + " is now named " + studentReg.findStudent(id).getName());
			}
			else {
				txtStudentArea.setText(name + " is not a valid name, please only use letters, valid characters is a-Ã¶, A-Ã–");
			}
		} else {
			txtStudentArea.setText("Please pick a student ID.");
		}
	}

	@FXML
	public void btnShowDetailsStudent(ActionEvent event) {
		String id = (String) cBoxStudentIDsStudent.getValue();
		Student s = studentReg.findStudent(id);
		if (s != null) {
			txtStudentArea.setText("Student ID: " + s.getStudentID() + "\nName: " + s.getName() + "\nExam Results: "
					+ s.getStudentsResultsForAllExams()); //getStudentResultForAllExams is called even if there is no results for the student.
		} else {
			txtStudentArea.setText("Please pick a student ID.");
		}
	}

	@FXML
	public void btnCreateCourse(ActionEvent event) {
		String name = txtCourseName.getText();
		try {
			double credits = Double.parseDouble(txtCredits.getText());
			Course c = new Course(name, credits);
			if(!name.isEmpty()) {
				if (c.getCourseCode() != null) {
					courseReg.addCourse(c);
					courseCodes.add(c.getCourseCode());// Adds the created course code to the list in ComboBox
					txtCourseArea.setText("The following course has been created:" +
							"\nCourse name: " + c.getName() + "\nCourse code: " + c.getCourseCode()
							+ "\nCredits: " + c.getCredits());
					txtCourseName.setText(""); // Removes the text from Student name field, so that you cannot spam "add course".
					txtCredits.setText("");
				} else {
					txtStudentArea.setText("The maximum number of courses have been created."
							+ "\nPlease contact your awesome programmers. ");
				}
			} else {
				txtCourseArea.setText("Please fill in course name.");
			}
		} catch (NumberFormatException n) {
			txtCourseArea.setText("Please fill in a valid number of credits (only numbers are allowed, use . for decimals).");
		}
	}

	@FXML
	public void btnDeleteCourse(ActionEvent event) {
		String cCode = (String) cBoxCourseCodeCourse.getValue();
		Course c = courseReg.findCourse(cCode);
		if (c != null) {
			int i = courseCodes.indexOf(cCode);
			courseCodes.remove(i);
			courseReg.removeCourse(cCode);
			txtCourseArea.setText(c.getName() + " with course code " + c.getCourseCode() + " has been deleted");
			txtCourseName.setText("");
			txtCredits.setText("");
			// Possible to remove exam from comboBox, however if course is deleted it doesn't remove its exams as well. 		
		} else {
			txtCourseArea.setText("Please pick a course code.");
		}
	}

	@FXML
	public void btnUpdateCourse(ActionEvent event) { 
		String cCode = (String) cBoxCourseCodeCourse.getValue();
		String name = txtCourseName.getText();
		try {
			double credits = Double.parseDouble(txtCredits.getText());
			Course c = courseReg.findCourse(cCode);
			if (c != null ) {
				if(!name.isEmpty() && !cCode.isEmpty()) {
					c.setName(name);
					c.setCredits(credits);
					txtCourseArea.setText("The following course has been updated:" + "\nCourse code: " + c.getCourseCode() + "\nCourse name: "
							+ c.getName() + "\nCredits: " + c.getCredits());
				} else {
					txtCourseArea.setText("Please fill in mandatory fields.\nCredits field only accept numbers and (.) for decimal.");
				}
			} else {
				txtCourseArea.setText("Please pick a course code.");
			}
		} catch (NumberFormatException n) {
			txtCourseArea.setText("Please fill in mandatory fields.\nCredits field only accept numbers and (.) for decimal.");
		}
	}

	@FXML
	public void btnShowDetailsCourse(ActionEvent event) {
		String cCode = (String) cBoxCourseCodeCourse.getValue();
		Course c = courseReg.findCourse(cCode);
		if (c != null) {
			txtCourseArea.setText("Course code: " + c.getCourseCode() + "\nName: " + c.getName() + "\nCredits: "
					+ c.getCredits() + "\nWritten Exams: " + c.getAllWrittenExamsAndAllResults());
		} else {
			txtCourseArea.setText("Please pick a course code");
		}
	}

	@FXML
	public void btnCreateExam(ActionEvent event) {
		String cCode = (String) cBoxCourseCodeWrittenExam.getValue();
		try {
			if (courseReg.findCourse(cCode) != null) {
				Course c = courseReg.findCourse(cCode);
				if (datePickerDateWrittenExam.getValue() != null) {
					LocalDate date = datePickerDateWrittenExam.getValue();
					if (cBoxLocation.getValue() != null) {
						String location = cBoxLocation.getValue();
						if ((txtTimeHour.getValue() != null && txtTimeMinute.getValue() != null)) {
							String time = (txtTimeHour.getValue() + ":" + txtTimeMinute.getValue());
							WrittenExam w = new WrittenExam(date, c, time, location);
							if(w.getExamID() != null) { 
								c.addWrittenExamToCourse(w);
								examIDs.add(w.getExamID()); // Adds created examID to the list in comboBox
								txtWrittenExamArea.setText("The following written exam has been added: " + "\nCourse Code: " 
										+ w.getCourse().getCourseCode() + " - " + w.getCourse().getName() 										
										+ " \nexamID: "+ w.getExamID() + " \nDate: " + date + " \nLocation: " + location + " \nTime: "										
										+ time + " \nMax points: " + w.getMaxPoints());
								cBoxCourseCodeWrittenExam.setValue(null);
								lblCourseName.setText("");
								datePickerDateWrittenExam.setValue(null);
								cBoxLocation.setValue(null);
								txtTimeHour.setValue(null);
								txtTimeMinute.setValue(null);
							} else {
								txtStudentArea.setText("The maximum number of exams have been created."
										+ "\nPlease contact your awesome programmers. ");
							}
						} else {
							txtWrittenExamArea.setText("Please pick a time for the exam (both hour and minutes)");
						}
					} else {
						txtWrittenExamArea.setText("Please pick a location for the exam");
					}
				} else {
					txtWrittenExamArea.setText("Please pick a date for the exam");
				}
			} else {
				txtWrittenExamArea.setText("The exam must belong to a course, please pick a course code");
			}
		} catch (IllegalArgumentException e) {
			txtWrittenExamArea.setText("There is already an exam at this day, time and location. "
					+ "\nPlease pick a different day, time or location.");
		}
	}

	@FXML
	public void btnRemoveExamFromCourse(ActionEvent event) {
		String examID = (String) cBoxExamIDsWrittenExam.getValue();
		if (examID != null) {
			try {
				Course c = courseReg.findWrittenExam(examID).getCourse();
				c.removeWrittenExamFromCourse(examID);
				int i = examIDs.indexOf(examID);
				examIDs.remove(i); // Removes examID from combox list 
				txtWrittenExamArea.setText("The exam " + examID + " has been removed from the course " + c.getCourseCode());
			}
			catch(NullPointerException e){
				int i = examIDs.indexOf(examID);
				examIDs.remove(i);
				txtWrittenExamArea.setText(examID + " has been removed. ");
			}
		} else {
			txtWrittenExamArea.setText("Please pick a examID");
		}
	}

	@FXML
	public void btnShowResultForExam(ActionEvent event) {
		try {
			String examID = (String) cBoxExamIDsWrittenExam.getValue();
			WrittenExam w = courseReg.findWrittenExam(examID); // Causes NullPointerException if the course is deleted
			if (examID != null) {
				if(w.getResultWrittenExam().size() != 0) {
					txtWrittenExamArea.setText("ExamID: " + w.getExamID() + w.getAllResultsOnExam() + "\nAverage points: "
							+ w.averageResult() + "\n" + w.passedStudents() + " of " + w.getResultWrittenExam().size()
							+ " students passed this exam. " + "\nMedian is: " + w.medianResult());
				} else {
					txtWrittenExamArea.setText("There is no registered results for " + w.getExamID() + ".");
				}
			} else {
				txtWrittenExamArea.setText("Please pick a examID");
			}
		}
		catch(NullPointerException e) {
			txtWrittenExamArea.setText("The course for this exam has been deleted therefore the results as well.");
		}
	}

	@FXML
	public void btnRegisterResultForStudent(ActionEvent event) {
		String examID = (String) cBoxExamIDsResult.getValue();
		String id = (String) cBoxStudentIDsResult.getValue();
		try {
			if (examID != null) {
				WrittenExam w = courseReg.findWrittenExam(examID); // Causes NullPointerException if the course is deleted
				if (id != null) {
					Student s = studentReg.findStudent(id);
					if (s.findStudentsResultOnExam(w) == null) { // Can't create more than one result for one student on one exam 
						try {
							Double result = Double.parseDouble(txtExamResult.getText());
							Result r = new Result(s, w, result);
							w.addResultToResultList(r);
							s.addResultOnExam(r, w);
							txtRegisterResultArea.setText("The following result has been registered: \n" + "Student: " + s.getStudentID() + "\nCourse: "
									+ w.getCourse().getCourseCode() + " - " + w.getCourse().getName() + "\nExam: " + w.getExamID() + "\nResult: "
									+ r.getResult() + "\nGrade: " + r.getLetterGrade());
						} catch (NumberFormatException n) {
							txtRegisterResultArea.setText(
									"Please fill in a valid result (only numbers are allowed, use . for decimals).");
						} catch (IllegalArgumentException e) {
							txtRegisterResultArea.setText("The result can't be bigger than the maxpoint("
									+ courseReg.findWrittenExam(examID).getMaxPoints()
									+ ") for the exam.\nPlease fill in a valid result.");
						}
					} else {
						txtRegisterResultArea.setText("The student " + s.getStudentID() + " already has a registerd result ("
								+ s.findStudentsResultOnExam(w).getResult() + ") on this exam.");
					}
				} else {
					txtRegisterResultArea.setText("Please pick a studentID");
				}
			} else {
				txtRegisterResultArea.setText("Please pick an examID");
			}
		}
		catch(NullPointerException e) {
			txtRegisterResultArea.setText("The course for this exam has been deleted therefore you cannot register new results.");	
		}
	}
}

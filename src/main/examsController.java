package main;

public class examsController {
    private Exam[] exams;
    
    public examsController(Exam[] exams) {
        this.exams = exams;
    }
    
    public Exam[] getExams() {
        return exams;
    }
}
package ke.drift.exam.student.models;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.subject.models.Subject;

import javax.persistence.*;

@Entity
public class StudentSubjectResult {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private AcademicTerm term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private Double score;

    private Double subjectPoints;

    private String subjectGrade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicTerm getTerm() {
        return term;
    }

    public void setTerm(AcademicTerm term) {
        this.term = term;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getSubjectPoints() {
        return subjectPoints;
    }

    public void setSubjectPoints(Double subjectPoints) {
        this.subjectPoints = subjectPoints;
    }

    public String getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(String subjectGrade) {
        this.subjectGrade = subjectGrade;
    }
}
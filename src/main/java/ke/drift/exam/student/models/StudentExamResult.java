package ke.drift.exam.student.models;

import ke.drift.exam.exam.models.AcademicTerm;

import javax.persistence.*;

@Entity
public class StudentExamResult {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private AcademicTerm term;

    private Integer studentNumber;
    private Integer studentRank;
    private Double totalMarks;
    private Double totalPoints;
    private Double meanPoints;
    private String meanGrade;

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

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Double getMeanPoints() {
        return meanPoints;
    }

    public void setMeanPoints(Double meanPoints) {
        this.meanPoints = meanPoints;
    }

    public String getMeanGrade() {
        return meanGrade;
    }

    public void setMeanGrade(String meanGrade) {
        this.meanGrade = meanGrade;
    }
}
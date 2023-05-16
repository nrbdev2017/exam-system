package ke.drift.exam.exam.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class AcademicTerm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String termName;

    private Date termStart;

    private Date termEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_id")
    private AcademicYear year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Date getTermStart() {
        return termStart;
    }

    public void setTermStart(Date termStart) {
        this.termStart = termStart;
    }

    public Date getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(Date termEnd) {
        this.termEnd = termEnd;
    }

    public AcademicYear getYear() {
        return year;
    }

    public void setYear(AcademicYear year) {
        this.year = year;
    }
}
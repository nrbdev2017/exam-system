package ke.drift.exam.exam.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class AcademicYear {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String yearName;

    private Date yearStart;

    private Date yearEnd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public Date getYearStart() {
        return yearStart;
    }

    public void setYearStart(Date yearStart) {
        this.yearStart = yearStart;
    }

    public Date getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Date yearEnd) {
        this.yearEnd = yearEnd;
    }
}
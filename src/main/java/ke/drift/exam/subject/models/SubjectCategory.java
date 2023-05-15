package ke.drift.exam.subject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SubjectCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
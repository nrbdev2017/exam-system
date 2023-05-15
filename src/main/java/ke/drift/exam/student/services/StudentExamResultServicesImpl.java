package ke.drift.exam.student.services;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.exam.services.AcademicTermServicesImpl;
import ke.drift.exam.student.dto.ExamResultDTO;
import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.models.StudentExamResult;
import ke.drift.exam.student.models.StudentSubjectResult;
import ke.drift.exam.student.repositories.StudentExamResultRepository;
import ke.drift.exam.subject.models.Subject;
import ke.drift.exam.subject.services.SubjectServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentExamResultServicesImpl implements  StudentExamResultServices{

    private Double totalMarks;
    List<Double> scienceMarks;
    List<Double> sciencePoints;
    private Double totalPoints;
    private Double meanPoints;
    private AcademicTerm term;
    private Student student;
    private SubjectServicesImpl subjectServices;
    private AcademicTermServicesImpl termServices;
    private StudentServicesImpl studentServices;
    private StudentSubjectResultServicesImpl subjectResultServices;

    @Autowired
    private StudentExamResultRepository examResultRepository;

    StudentExamResultServicesImpl(){
        this.totalMarks = 0.0;
    }

    @Override
    public List<StudentExamResult> getTermExamResults(Long termId) {
        return examResultRepository.findByTermId(termId);
    }

    public void save(ExamResultDTO results){

        Set<StudentSubjectResult> subjectResults = this.createResultSet(results);

        subjectResults = this.validateSubjectsTaken(subjectResults);

        for (StudentSubjectResult result : subjectResults) {
            subjectResultServices.save(result);
        }

        StudentExamResult fullResult = new StudentExamResult();
        fullResult.setStudent(this.student);
        fullResult.setTerm(this.term);
        fullResult.setTotalMarks(this.getExamTotalMarks());
        fullResult.setTotalPoints(this.getExamTotalPoints());
        fullResult.setMeanPoints(this.getExamMeanPoints());
        fullResult.setMeanGrade(this.getExamMeanGrade(this.meanPoints));
        examResultRepository.save(fullResult);
    }

    public Set<StudentSubjectResult> createResultSet(ExamResultDTO results) {

        // Creating an empty Set
        Set<StudentSubjectResult> subjectResults = new HashSet<>();

        //Student
        this.student = studentServices.getById(results.getStudentId());

        //Term
        this.term = termServices.getById(results.getTermId());

        StudentSubjectResult subjectResult = new StudentSubjectResult();
        subjectResult.setStudent(student);
        subjectResult.setTerm(term);

        Double score = 0.0;

        // Math
        Subject sub = subjectServices.getById(results.getMathId());
        subjectResult.setSubject(sub);
        score = results.getMathScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // English
        sub = subjectServices.getById(results.getEngId());
        subjectResult.setSubject(sub);
        score = results.getEngScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // Kis
        sub = subjectServices.getById(results.getKisId());
        subjectResult.setSubject(sub);
        score = results.getKisScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // Physics
        sub = subjectServices.getById(results.getPhyId());
        subjectResult.setSubject(sub);
        score = results.getPhyScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.scienceMarks.add(score);
            this.sciencePoints.add(getPoints(score));
        }

        // Chemistry
        sub = subjectServices.getById(results.getCheId());
        subjectResult.setSubject(sub);
        score = results.getCheScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.scienceMarks.add(score);
            this.sciencePoints.add(getPoints(score));
        }

        // Biology
        sub = subjectServices.getById(results.getBioId());
        subjectResult.setSubject(sub);
        score = results.getBioScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.scienceMarks.add(score);
            this.sciencePoints.add(getPoints(score));
        }

        // Geography
        sub = subjectServices.getById(results.getGeoId());
        subjectResult.setSubject(sub);
        score = results.getGeoScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // History
        sub = subjectServices.getById(results.getHisId());
        subjectResult.setSubject(sub);
        score = results.getHisScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // CRE
        sub = subjectServices.getById(results.getCreId());
        subjectResult.setSubject(sub);
        score = results.getCreScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
        }

        // Agriculture
        sub = subjectServices.getById(results.getAgrId());
        subjectResult.setSubject(sub);
        score = results.getAgrScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // Computers
        sub = subjectServices.getById(results.getComId());
        subjectResult.setSubject(sub);
        score = results.getComScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        // Business
        sub = subjectServices.getById(results.getBedId());
        subjectResult.setSubject(sub);
        score = results.getBedScore();
        if (score != null) {
            subjectResult.setScore(score);
            subjectResult.setSubjectPoints(getPoints(score));
            subjectResult.setSubjectGrade(getGrade(score));
            subjectResults.add(subjectResult);
            this.totalMarks = this.totalMarks + score;
            this.totalPoints = this.totalPoints + getPoints(score);
        }

        return subjectResults;
    }

    public Set<StudentSubjectResult> validateSubjectsTaken(Set<StudentSubjectResult> results) {
        // check number of subjects
        if (results.size() < 8) {
            throw new RuntimeException(
                    "Student has to take exactly 8 subjects");
        }

        // check the number of each category
        int compulsory = 0;
        int sciences = 0;
        int other = 0;

        for (StudentSubjectResult result : results) {
            switch (result.getSubject().getCategory().getName()) {
                case "Compulsory":
                    compulsory++;
                    break;

                case "Sciences":
                    sciences++;
                    break;
            }
        }

        //check the number for compulsory
        if (compulsory < 3) {
            throw new RuntimeException(
                    "Student has to take all 3 compulsory subjects");
        }

        // check the number of sciences
        if (sciences < 2) {
            throw new RuntimeException(
                    "Student has to take at least 2 science subjects");
        }

        return results;
    }

    private Double getPoints(Double score){

        double points = 0.0;
        if (score>=95) {
            points = 12.0;
        } else if (score>=89) {
            points = 11.0;
        } else if (score>=83) {
            points = 10.0;
        } else if (score>=76) {
            points = 9.0;
        } else if (score>=69) {
            points = 8.0;
        } else if (score>=61) {
            points = 7.0;
        } else if (score>=53) {
            points = 6.0;
        } else if (score>=44) {
            points = 5.0;
        } else if (score>=36) {
            points = 4.0;
        } else if (score>=28) {
            points = 3.0;
        } else if (score>=21) {
            points = 2.0;
        } else {
            points = 1.0;
        }
        return points;
    }


    private String getGrade(Double score){

        String grade = "F";
        if (score>=95) {
            grade = "A";
        } else if (score>=89) {
            grade = "A-";
        } else if (score>=83) {
            grade = "B+";
        } else if (score>=76) {
            grade = "B";
        } else if (score>=69) {
            grade = "B-";
        } else if (score>=61) {
            grade = "C+";
        } else if (score>=53) {
            grade = "C";
        } else if (score>=44) {
            grade = "C-";
        } else if (score>=36) {
            grade = "D+";
        } else if (score>=28) {
            grade = "D";
        } else if (score>=21) {
            grade = "D-";
        } else {
            grade = "E";
        }
        return grade;
    }

    public String getExamMeanGrade(Double score) {

        String grade = "F";
        if (score>=11.5) {
            grade = "A";
        } else if (score>=10.5) {
            grade = "A-";
        } else if (score>=9.5) {
            grade = "B+";
        } else if (score>=8.5) {
            grade = "B";
        } else if (score>=7.5) {
            grade = "B-";
        } else if (score>=6.5) {
            grade = "C+";
        } else if (score>=5.5) {
            grade = "C";
        } else if (score>=4.5) {
            grade = "C-";
        } else if (score>=3.5) {
            grade = "D+";
        } else if (score>=2.5) {
            grade = "D";
        } else if (score>=1.5) {
            grade = "D-";
        } else {
            grade = "E";
        }
        return grade;
    }
    public Double getExamTotalMarks() {
        Collections.sort(this.scienceMarks);
        Collections.reverse(this.scienceMarks);
        Double topTwoSciMarks = this.scienceMarks.stream().mapToDouble(Double::doubleValue).limit(2)
                .sum();
        return this.totalMarks+topTwoSciMarks;
    }

    public Double getExamTotalPoints() {
        Collections.sort(this.sciencePoints);
        Collections.reverse(this.sciencePoints);
        double topTwoSciPoints = this.sciencePoints.stream().mapToDouble(Double::doubleValue).limit(2)
                .sum();
        this.totalPoints=this.totalPoints+topTwoSciPoints;
        return this.totalPoints;
    }

    public Double getExamMeanPoints() {
        this.meanPoints = this.totalPoints/7;
        return this.meanPoints;
    }


}
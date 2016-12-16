import java.util.ArrayList;
import java.util.ListIterator;

public class ReportCard {

    private String mStudentName;
    private ArrayList<Subject> mSubjectGrades;

    public ReportCard() {
        mStudentName = "N/A";
        mSubjectGrades = new ArrayList<Subject>();
    }

    public ReportCard(String studentName) {
        mStudentName = studentName;
        mSubjectGrades = new ArrayList<Subject>();
    }

    public String getStudentName() {
        return mStudentName;
    }

    public void setStudentName(String studentName) {
        mStudentName = studentName;
    }

    public void addSubjectGrade(String subjectName, String grade) {
        mSubjectGrades.add(new Subject(subjectName, grade));
    }

    public String getSubjectGrade(int subjectIndex) {

        if (subjectIndex >= mSubjectGrades.size()) {
            System.err.println("Inappropriate index number entered for Report Card.");
            return null;
        }

        return mSubjectGrades.get(subjectIndex).getGrade();
    }

    public String getSubjectGrade(String subject) {
        ListIterator<Subject> iterator = mSubjectGrades.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSubjectName().equalsIgnoreCase(subject)) {
                return iterator.previous().getGrade();
            }
        }
        System.err.println("Could not find " + subject + " in Report Card");
        return null;
    }

    public void setSubjectGrade(String subject, String grade) {
        ListIterator<Subject> iterator = mSubjectGrades.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSubjectName().equalsIgnoreCase(subject)) {
                iterator.previous().setGrade(grade);
                return;
            }
        }
        System.err.println("Could not find " + subject + "in Report Card");
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Grades for " + mStudentName + ":\n");

        for (Subject subject : mSubjectGrades) {
            String string = String.format("-%s: %s%n",
                    subject.getSubjectName(),
                    subject.getGrade());
            sb.append(string);
        }
        return sb.toString();
    }

    private class Subject {//------------------------------

        private String mSubjectName;
        private String mGrade;

        public Subject(String subjectName, String grade) {
            mSubjectName = subjectName;
            mGrade = grade;
        }

        public String getSubjectName() {
            return mSubjectName;
        }

        public void setSubjectName(String subjectName) {
            mSubjectName = subjectName;
        }

        public void setGrade(String grade) {
            mGrade = grade;
        }

        public String getGrade() {
            return mGrade;
        }
    }//Subject class---------------------------------------

}//ReportCard class


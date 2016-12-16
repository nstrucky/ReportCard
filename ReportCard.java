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

    public void addGrade(String subjectName, String grade) {
        mSubjectGrades.add(new Subject(subjectName, grade));
    }

    public String getGrade(int subjectIndex) {

        if (subjectIndex >= mSubjectGrades.size()) {
            System.err.println("Inappropriate index number entered for Report Card.");
            return null;
        }

        return mSubjectGrades.get(subjectIndex).getGrade();
    }

    public String getGrade(String subject) {
        ListIterator<Subject> iterator = mSubjectGrades.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSubjectName().equalsIgnoreCase(subject)) {
                return iterator.previous().getGrade();
            }
        }
        System.err.println("Could not find in Report Card");
        return null;
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

        public String getGrade() {
            return mGrade;
        }
    }//Subject class---------------------------------------

}//ReportCard class



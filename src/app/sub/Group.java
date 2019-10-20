package app.sub;

import java.util.List;

public class Group {
    private List<Student> studentList;

    public void add(Student student) {
        studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}

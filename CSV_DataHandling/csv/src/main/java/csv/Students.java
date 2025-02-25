package csv;

public class Students {
    private String id;
    private String name;
    private int age;
    private String marks;
    private String grade;

    public Students(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = "";
        this.grade = "";
    }

    public void setMarksAndGrade(String marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

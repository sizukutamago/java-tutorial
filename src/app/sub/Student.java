package app.sub;

public class Student implements Comparable {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        Student obj = (Student)o;
        return Integer.compare(obj.getScore(), score);
    }

    @Override
    public String toString() {
        return name + ":" + score;
    }
}

package app.sub;

public class Test {

    public String name;

    public Test(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Test)) {
            return false;
        }

        Test test = (Test) obj;

        return test.name == name;
    }
}
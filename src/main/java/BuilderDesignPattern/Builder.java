package BuilderDesignPattern;

public class Builder {
    int id;
    String name;
    String gender;
    int age;
    String course;

    Builder addAge(int age) {
        this.age = age;
        return this;
    }
    Builder addName(String name) {
        this.name = name;
        return this;
    }
    Builder addGender(String gender) {
        this.gender = gender;
        return this;
    }
    Builder addCourse(String course) {
        this.course = course;
        return this;
    }

    Student build() {
        Student student = new Student();
        student.id = id;
        student.name = name;
        student.gender = gender;
        student.age = age;
        student.course = course;
        return student;
    }

}

package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Student student = builder.addCourse("English").addName("Shaahsnak").build();

        System.out.println(student);

    }
}

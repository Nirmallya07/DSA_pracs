package ToString;

class Student {
    int id;
    String name;
    char section;

    Student(int id, String name, char section) {
        this.id = id;
        this.name = name;
        this.section = section;
    }
    @Override
    public String toString() {
        return " Student data: " + "name: " + name + " id: " + id + " section: " + section;
    }
}

public class toString_Example {
    public static void main(String[] args) {
        Student student1 = new Student(15, "Alice", 'A');
        System.out.println(student1);
        Student student2 = new Student(32, "Bob", 'B');
        System.out.println(student2);
    }
} 
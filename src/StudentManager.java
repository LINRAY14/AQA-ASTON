import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public boolean canBePromoted() {
        return getAverageGrade() >= 3;
    }

    public boolean isGraduated() {
        return course == 5;
    }

    public void promoteToNextCourse() {
        if (canBePromoted() && course < 5) {
            course++;
        }
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ", Средний балл: " + getAverageGrade() + ")";
    }
}

public class StudentManager {
    public static void removeFailingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(Set<Student> students) {
        students.forEach(Student::promoteToNextCourse);
        students.removeIf(Student::isGraduated);
    }

    public static void printStudents(Set<Student> students, int course) {
        if (course < 1 || course > 5) {
            System.out.println("Ошибка: курс должен быть от 1 до 5");
            return;
        }
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет студентов с заданными параметрами");
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Сергей Иванов", "10", 1, Arrays.asList(4, 4, 5)));
        students.add(new Student("Дима Смирнов", "20", 2, Arrays.asList(2, 2, 3)));
        students.add(new Student("Петр Сидоров", "30", 3, Arrays.asList(5, 3, 5)));
        students.add(new Student("Иван Прохоров", "40", 4, Arrays.asList(1, 1, 2)));
        students.add(new Student("Максим Орлов", "50", 5, Arrays.asList(4, 4, 4)));

        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);

        removeFailingStudents(students);
        System.out.println("\n После удаления студентов с низкими баллами:");
        students.forEach(System.out::println);

        promoteStudents(students);
        System.out.println("\n После перевода на следующий курс: ");
        students.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите номер курса для отображения студентов: ");
        int selectedCourse = scanner.nextInt();
        printStudents(students, selectedCourse);
    }
}

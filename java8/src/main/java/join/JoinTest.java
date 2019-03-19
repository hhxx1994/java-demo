package join;

import de.infonautika.streamjoin.Join;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class JoinTest {

    @Data
    @ToString
    public static class Student {
        private Integer id;
        private String name;

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Data
    @ToString
    public static class Grade {
        private Integer id;
        private Long goal;

        public Grade(Integer id, Long goal) {
            this.goal = goal;
            this.id = id;
        }
    }

    @Data
    @ToString
    public static class Total{
        private Integer id;
        private Long goal;
        private String name;
        public Total(Integer id,Long goal,String name){
            this.id = id;
            this.goal =  goal;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(123, "hhx"),new Student(123, "hhxa"), new Student(456, "qaz"));
        List<Grade> grades = Arrays.asList(new Grade(456, 45L), new Grade(234, 100L), new Grade(123, 34L));
        Join.join(students.stream())
                .withKey(Student::getId)
                .on(grades.stream())
                .withKey(Grade::getId)
                .combine((student,grade)->new Total(student.getId(),grade.getGoal(),student.getName()))
                .asStream().forEach(System.out::println);
    }
}

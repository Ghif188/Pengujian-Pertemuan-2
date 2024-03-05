import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest {
    public ArrayList<Student> A2;
    @BeforeAll
    public void initializeClass(){
        A2 = new ArrayList<>();
    }
    @BeforeEach
    public void initializeMethod(){
        Student student = new Student("Rambu", 21);
        A2.add(student);
    }
    @AfterEach
    public void cleanMethod(){
        A2.clear();
    }
    @AfterAll
    public void cleanClass(){
        A2.clear();
    }

    @Test
    public void testDataCreation(){
        Assertions.assertFalse(A2.isEmpty());
    }

    @Test
    public void testStudentEnrollment(){
        if (A2.size() != 0) {
            A2.get(0).enrollCourse("PPPL");
            List<String> course = new ArrayList<>();
            course.add("PPPL");
            Assertions.assertEquals(course, A2.get(0).getEnrolledCourses());
        }
    }

    @Test
    public void testStudentGrade(){
        if (A2.size() != 0) {
            A2.get(0).setGrade("PPPL", "90");
            Assertions.assertSame("90",A2.get(0).getGrade("PPPL"));
        }
    }
}

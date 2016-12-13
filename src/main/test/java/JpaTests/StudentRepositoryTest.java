package JpaTests;

import javaFX.App;
import javaFX.models.Device.Device;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLogin;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Tests of the entity class {@link javaFX.models.Student.Student}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        DbUnitTestExecutionListener.class})
@Transactional
public class StudentRepositoryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    StudentService studentService;

    @Autowired
    DeviceLoginService deviceLoginService;

    @Autowired
    DeviceService deviceService;

    @Before
    public void addValuesToOtherTablesThatStudentDependsOn() {

        deviceLoginService.save(new DeviceLogin("email1", "password"));
        deviceService.save(new Device("serialnumber1", "type"));

        deviceLoginService.save(new DeviceLogin("email2", "password"));
        deviceService.save(new Device("serialnumber2", "type"));

        deviceLoginService.save(new DeviceLogin("email3", "password"));
        deviceService.save(new Device("serialnumber3", "type"));

        deviceLoginService.save(new DeviceLogin("sql SELECT * FROM students;", "password"));
    }


    /**
     * Add 3 students to an empty DB
     * Expect 3 students in DB
     */
    @Test
    public void getAllStudentsTest() {
        studentService.save(new Student("email1", "firstname", "lastname", "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));
        studentService.save(new Student("email2", "firstname", "lastname", "2a", new DeviceLogin("email2", "password"), new Device("serialnumber2", "type")));
        studentService.save(new Student("email3", "firstname", "lastname", "2a", new DeviceLogin("email3", "password"), new Device("serialnumber3", "type")));
        Assert.assertEquals(studentService.findAllStudents().size(), 3);
    }


    /**
     * Allow input of special characters
     * Make sure that the characters are saved in the DB correctly and that we are able to get them without corruption
     */
    @Test
    public void edgeCaseStudent() {
        studentService.save(new Student("øæå@mail.com", "()'%&", "!´?½§`", "-=+,<>", new DeviceLogin("sql SELECT * FROM students;", "password"), new Device("serialnumber1", "type")));

        Student student = studentService.findAllStudents().get(0);
        Assert.assertEquals(student.getEmail(), "øæå@mail.com");
        Assert.assertEquals(student.getFirstName(), "()'%&");
        Assert.assertEquals(student.getLastName(), "!´?½§`");
        Assert.assertEquals(student.getSchoolClass(), "-=+,<>");
        Assert.assertEquals(student.getDeviceLogin().getEmail(), "sql SELECT * FROM students;");
    }

    /**
     * Emails must be unique in the DB.
     * If a new student with the same email is saved transactional will roll back and the student will not be added.
     * Therefore, only 1 student will be present in the database below
     * @throws Exception
     */
    @Test
    public void ensureThatNonUniqueEmailsFail() {
        studentService.save(new Student("same@email", "firstname", "lastname", "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));
        studentService.save(new Student("same@email", "firstname", "lastname", "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));

        Assert.assertEquals(studentService.findAllStudents().size(), 1);

    }



    /**
     * The values below can't be null
     * Every single save attempt should fail
     * @throws Exception
     */
    @Test
    public void failWithNullValues() {

        // It's possible to simply do this @Test(expected=JpaSystemException.class)
        // but rather than expecting the exception in the scope of the entire method we expect it before each DB call

        exception.expect(JpaSystemException.class);
        studentService.save(new Student(null, "firstname", "lastname", "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));

        exception.expect(JpaSystemException.class);
        studentService.save(new Student("same@email", null, "lastname", "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));

        exception.expect(JpaSystemException.class);
        studentService.save(new Student("same@email", "firstname", null, "2a", new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));

        exception.expect(JpaSystemException.class);
        studentService.save(new Student("same@email", "firstname", "lastname", null, new DeviceLogin("email1", "password"), new Device("serialnumber1", "type")));

        exception.expect(JpaSystemException.class);
        studentService.save(new Student("same@email", "firstname", "lastname", "2a", null, new Device("serialnumber1", "type")));

        exception.expect(JpaSystemException.class);
        studentService.save(new Student("same@email", "firstname", "lastname", "2a", new DeviceLogin("email1", "password"), null));

        Assert.assertEquals(studentService.findAllStudents().size(), 0);
    }




}

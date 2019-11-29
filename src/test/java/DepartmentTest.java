import models.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
public class DepartmentTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//helper
    public Department setUpDepartment(){
        return new Department("Animations");
    }

    @Test
    public void instanciatesCorrectly_true(){
        Department testDepartment=setUpDepartment();
        assertEquals(true,testDepartment instanceof Department);
    }

    @Test
    public void getName_instanciatesWithName_true(){
        Department testDepartment=setUpDepartment();
        assertEquals("Animations",testDepartment.getName());
    }
    @Test
    public void setName_setAName_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setName("Dundaing");
        assertEquals("Dundaing",testDepartment.getName());
    }
    @Test
    public void setId_setAnId_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setId(4);
        assertEquals(4,testDepartment.getId());
    }



}


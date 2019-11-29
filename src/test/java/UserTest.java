import models.Department;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //helper
    public User setUpUser(){
        return new User("Kevo",1);
    }
    public User setUpUser1(){
        return new User("Drakos",2);
    }

    @Test
    public void instanciatesCorrectly_true(){
        User testUser=setUpUser();
        assertEquals(true,testUser instanceof User);
    }

    @Test
    public void getName_instanciatesWithName_true(){
        User testUser=setUpUser();
        assertEquals("Kevo",testUser.getName());
    }
    @Test
    public void setName_setAName_true(){
        User testUser=setUpUser();
        testUser.setName("Doremy");
        assertEquals("Doremy",testUser.getName());
    }
    @Test
    public void setId_setAnId_true(){
        User testUser=setUpUser();
        testUser.setId(4);
        assertEquals(4,testUser.getId());
    }


    @Test
    public void getDepartmentId_instanciatesWithDepartmentId_true(){
        User testUser=setUpUser();
        assertEquals(1,testUser.getDepartmentid());
    }
    @Test
    public void setDepartmentId_true(){
        User testUser=setUpUser();
        testUser.setDepartmentid(4);
        assertEquals(4,testUser.getDepartmentid());
    }



}

package dao;

import models.User;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oUserDaoTest {
    private static Sql2oUserDao userDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception{
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        userDao=new Sql2oUserDao(DB.sql2o);
        conn = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        userDao.deleteAll();
    }

    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setupNewUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);
        assertNotEquals(originalUserId,testUser.getId());
    }
    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        User testUser = setupNewUser();
        User testUser1=setupNewUser1();
        userDao.add(testUser);
        userDao.add(testUser1);
        assertEquals(2, userDao.getAll().size());
    }
    @Test
    public void noFoodtypesReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        User user = setupNewUser();
        userDao.add(user);
        userDao.deleteById(user.getId());
        assertEquals(0, userDao.getAll().size());
    }
    @Test
    public void deleteAll() throws Exception{
        User testUser=setupNewUser();
        User testUser1=setupNewUser1();
        userDao.add(testUser);
        userDao.add(testUser1);
        userDao.deleteAll();
        assertEquals(0,userDao.getAll().size());
    }


//    @Test
//    public void update() throws Exception{
//        User testUser=setupNewUser();
//        userDao.add(testUser);
//        userDao.update(testUser.getId(),"Ghosts","Director","Direct",3);
//        User foundUser=userDao.findById(testUser.getId());
//        assertEquals("Ghosts",foundUser.getName());
//        assertEquals("Director",foundUser.getCompanyposition());
//        assertEquals("Direct",foundUser.getRole());
//        assertEquals(3,foundUser.getDepartmentid());
//    }

    //helpers
    public User setupNewUser(){
        return new User("Animations",1,"Manager","Rule everything");
    }
    public User setupNewUser1(){
        return new User("IT",2,"Employee","Work hard");
    }
}

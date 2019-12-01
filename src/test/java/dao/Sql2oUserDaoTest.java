package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oUserDaoTest {
    private Sql2oUserDao userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao=new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
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

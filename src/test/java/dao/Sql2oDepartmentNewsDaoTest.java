package dao;

import models.DepartmentNews;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentNewsDaoTest {
    private static Sql2oDepartmentNewsDao departmentNewsDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception{
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        departmentNewsDao=new Sql2oDepartmentNewsDao(DB.sql2o);
        conn = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentNewsDao.deleteAll();
    }
    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingDepartmentNewsSetsId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        int originalDepartmentNewsId = testDepartmentNews.getId();
        departmentNewsDao.add(testDepartmentNews);
        assertNotEquals(originalDepartmentNewsId,testDepartmentNews.getId());
    }
    @Test
    public void addingDepartmentNewsAddsDepartmentIdId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        departmentNewsDao.add(testDepartmentNews);
        assertEquals(2,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void addingDepartmentNewsCanSetDepartmentIdId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        testDepartmentNews.setDepartmentid(4);
        departmentNewsDao.add(testDepartmentNews);
        assertEquals(4,testDepartmentNews.getDepartmentid());
    }

    @Test
    public void addedDepartmentNewssAreReturnedFromGetAll() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        DepartmentNews testDepartmentNews1=setupNewDepartmentNews1();
        departmentNewsDao.add(testDepartmentNews);
        departmentNewsDao.add(testDepartmentNews1);
        assertEquals(2, departmentNewsDao.getAll().size());
    }
    @Test
    public void noFoodtypesReturnsEmptyList() throws Exception {
        assertEquals(0, departmentNewsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        DepartmentNews departmentNews = setupNewDepartmentNews();
//        DepartmentNews departmentNews1=setupNewDepartmentNews1();
        departmentNewsDao.add(departmentNews);
        departmentNewsDao.deleteById(departmentNews.getId());
        assertEquals(0, departmentNewsDao.getAll().size());
    }
    @Test
    public void deleteAll() throws Exception{
        DepartmentNews testDepartmentNews=setupNewDepartmentNews();
        DepartmentNews testDepartmentNews1=setupNewDepartmentNews1();
        departmentNewsDao.add(testDepartmentNews);
        departmentNewsDao.add(testDepartmentNews1);
        departmentNewsDao.deleteAll();
        assertEquals(0,departmentNewsDao.getAll().size());

    }


    //helpers
    public DepartmentNews setupNewDepartmentNews(){
        return new DepartmentNews("Animations",1,2);
    }
    public DepartmentNews setupNewDepartmentNews1(){
        return new DepartmentNews("IT",2,3);
    }
}

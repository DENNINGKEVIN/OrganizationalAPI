package dao;

import models.GeneralNews;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oGeneralNewsDaoTest {
    private static Sql2oGeneralNewsDao generalNewsDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception{
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        generalNewsDao=new Sql2oGeneralNewsDao(DB.sql2o);
        conn = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        generalNewsDao.deleteAll();
    }

    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingGeneralNewsSetsId() throws Exception {
        GeneralNews testGeneralNews = setupNewGeneralNews();
        int originalGeneralNewsId = testGeneralNews.getId();
        generalNewsDao.add(testGeneralNews);
        assertNotEquals(originalGeneralNewsId,testGeneralNews.getId());
    }
    @Test
    public void addedGeneralNewssAreReturnedFromGetAll() throws Exception {
        GeneralNews testGeneralNews = setupNewGeneralNews();
        GeneralNews testGeneralNews1=setupNewGeneralNews1();
        generalNewsDao.add(testGeneralNews);
        generalNewsDao.add(testGeneralNews1);
        assertEquals(2, generalNewsDao.getAll().size());
    }
    @Test
    public void noFoodtypesReturnsEmptyList() throws Exception {
        assertEquals(0, generalNewsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        GeneralNews generalNews = setupNewGeneralNews();
        GeneralNews generalNews1=setupNewGeneralNews1();
        generalNewsDao.add(generalNews);
        generalNewsDao.add(generalNews1);
        generalNewsDao.deleteById(generalNews.getId());
        assertEquals(1, generalNewsDao.getAll().size());
    }
    @Test
    public void deleteAll() throws Exception{
        GeneralNews testGeneralNews=setupNewGeneralNews();
        GeneralNews testGeneralNews1=setupNewGeneralNews1();
        generalNewsDao.add(testGeneralNews);
        generalNewsDao.add(testGeneralNews1);
        generalNewsDao.deleteAll();
        assertEquals(0,generalNewsDao.getAll().size());

    }

    //helpers
    public GeneralNews setupNewGeneralNews(){
        return new GeneralNews("Animations",2);
    }
    public GeneralNews setupNewGeneralNews1(){
        return new GeneralNews("IT",3);
    }
}

package dao;

import models.GeneralNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oGeneralNewsDaoTest {
    private Sql2oGeneralNewsDao generalNewsDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        generalNewsDao=new Sql2oGeneralNewsDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
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

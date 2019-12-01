package models;

import models.DepartmentNews;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentNewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //helper
    public DepartmentNews setUpDepartmentNews(){
        return new DepartmentNews("Animations is corrupt",1,1);
    }
    public DepartmentNews setUpDepartmentNews1(){
        return new DepartmentNews("Whoever wrote that post...nkt ",9,2);
    }

    @Test
    public void instanciatesCorrectly_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(true,testDepartmentNews instanceof News);
    }

    @Test
    public void getName_instanciatesWithContent_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals("Animations is corrupt",testDepartmentNews.getContent());
    }
    @Test
    public void setContent_setAContent_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setContent("Whoever wrote that post...nkt ");
        assertEquals("Whoever wrote that post...nkt ",testDepartmentNews.getContent());
    }

    @Test
    public void setId_setAnId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setId(4);
        assertEquals(4,testDepartmentNews.getId());
    }

    @Test
    public void getUserId_instanciatesWithUserId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(1,testDepartmentNews.getUserid());
    }
    @Test
    public void setUserId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setUserid(5);
        assertEquals(5,testDepartmentNews.getUserid());
    }

    @Test
    public void getDepartmentId_instanciatesDepartmentId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(1,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void setDepartmentId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setDepartmentid(5);
        assertEquals(5,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void getType_instanciatesWithType_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals("department",testDepartmentNews.getType());
    }
    @Test
    public void setType_setAType_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setType("Fisi");
        assertEquals("department",testDepartmentNews.getType());
    }



}

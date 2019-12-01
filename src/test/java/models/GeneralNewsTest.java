package models;

import models.GeneralNews;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralNewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //helper
    public GeneralNews setUpGeneralNews(){
        return new GeneralNews("Animations is corrupt",5);
    }
    public GeneralNews setUpGeneralNews1(){
        return new GeneralNews("Whoever wrote that post...nkt ",9);
    }

    @Test
    public void instanciatesCorrectly_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals(true,testGeneralNews instanceof News);
    }

    @Test
    public void getName_instanciatesWithContent_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals("Animations is corrupt",testGeneralNews.getContent());
    }
    @Test
    public void setContent_setAContent_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setContent("Whoever wrote that post...nkt ");
        assertEquals("Whoever wrote that post...nkt ",testGeneralNews.getContent());
    }

    @Test
    public void setId_setAnId_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setId(4);
        assertEquals(4,testGeneralNews.getId());
    }

    @Test
    public void getUserId_instanciatesWithUserId_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals(5,testGeneralNews.getUserid());
    }
    @Test
    public void setUserId_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setUserid(6);
        assertEquals(6,testGeneralNews.getUserid());
    }
    @Test
    public void getType_instanciatesWithType_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals("general",testGeneralNews.getType());
    }
    @Test
    public void setType_setAType_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setType("cowish");
        assertEquals("general",testGeneralNews.getType());
    }




}

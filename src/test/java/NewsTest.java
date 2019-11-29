import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //helper
    public News setUpNews(){
        return new News("Kevo",1);
    }
    public News setUpNews1(){
        return new News("Drakos",2);
    }

    @Test
    public void instanciatesCorrectly_true(){
        News testNews=setUpNews();
        assertEquals(true,testNews instanceof News);
    }

    @Test
    public void getName_instanciatesWithName_true(){
        News testNews=setUpNews();
        assertEquals("Kevo",testNews.getName());
    }
    @Test
    public void setName_setAName_true(){
        News testNews=setUpNews();
        testNews.setName("Doremy");
        assertEquals("Doremy",testNews.getName());
    }
    @Test
    public void setId_setAnId_true(){
        News testNews=setUpNews();
        testNews.setId(4);
        assertEquals(4,testNews.getId());
    }


    @Test
    public void getDepartmentId_instanciatesWithDepartmentId_true(){
        News testNews=setUpNews();
        assertEquals(1,testNews.getDepartmentid());
    }
    @Test
    public void setDepartmentId_true(){
        News testNews=setUpNews();
        testNews.setDepartmentid(4);
        assertEquals(4,testNews.getDepartmentid());
    }


}

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
        return new News("Animations is corrupt","Anonymous",1,1);
    }
    public News setUpNews1(){
        return new News("Whoever wrote that post...nkt ","Mouse",9,2);
    }

    @Test
    public void instanciatesCorrectly_true(){
        News testNews=setUpNews();
        assertEquals(true,testNews instanceof News);
    }

    @Test
    public void getName_instanciatesWithContent_true(){
        News testNews=setUpNews();
        assertEquals("Animations is corrupt",testNews.getContent());
    }
    @Test
    public void setContent_setAContent_true(){
        News testNews=setUpNews();
        testNews.setContent("Whoever wrote that post...nkt ");
        assertEquals("Whoever wrote that post...nkt ",testNews.getContent());
    }

    @Test
    public void getAuthor_instanciatesWithAuthor_true(){
        News testNews=setUpNews();
        assertEquals("Anonymous",testNews.getAuthor());
    }
    @Test
    public void setAuthor_setAnAuthor_true(){
        News testNews=setUpNews();
        testNews.setAuthor("Fisi");
        assertEquals("Fisi",testNews.getAuthor());
    }
    @Test
    public void setId_setAnId_true(){
        News testNews=setUpNews();
        testNews.setId(4);
        assertEquals(4,testNews.getId());
    }

    @Test
    public void getUserId_instanciatesWithUserId_true(){
        News testNews=setUpNews();
        assertEquals(1,testNews.getUserId());
    }
    @Test
    public void setUserId_true(){
        News testNews=setUpNews();
        testNews.setUserId(5);
        assertEquals(5,testNews.getUserId());
    }
    @Test
    public void getRating_instanciatesRating_true(){
        News testNews=setUpNews();
        assertEquals(1,testNews.getRating());
    }
    @Test
    public void setRating_true(){
        News testNews=setUpNews();
        testNews.setRating(5);
        assertEquals(5,testNews.getRating());
    }



}

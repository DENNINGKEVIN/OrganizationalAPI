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
        return new GeneralNews("Animations is corrupt","Anonymous",1,1);
    }
    public GeneralNews setUpGeneralNews1(){
        return new GeneralNews("Whoever wrote that post...nkt ","Mouse",9,2);
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
    public void getAuthor_instanciatesWithAuthor_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals("Anonymous",testGeneralNews.getAuthor());
    }
    @Test
    public void setAuthor_setAnAuthor_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setAuthor("Fisi");
        assertEquals("Fisi",testGeneralNews.getAuthor());
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
        assertEquals(1,testGeneralNews.getUserId());
    }
    @Test
    public void setUserId_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setUserId(5);
        assertEquals(5,testGeneralNews.getUserId());
    }
    @Test
    public void getRating_instanciatesRating_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals(1,testGeneralNews.getRating());
    }
    @Test
    public void setRating_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setRating(5);
        assertEquals(5,testGeneralNews.getRating());
    }



}

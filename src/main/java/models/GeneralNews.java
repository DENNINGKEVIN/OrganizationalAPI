package models;

public class GeneralNews extends News{

    public static final String DATABASE_TYPE= "GeneralNews";

    public GeneralNews(String content,String author,int userid){
        this.content=content;
        this.author=author;
        this.userid=userid;
//        type=DATABASE_TYPE;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }
}

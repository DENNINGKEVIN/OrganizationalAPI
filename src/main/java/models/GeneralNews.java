package models;

public class GeneralNews extends News{

    public static final String DATABASE_TYPE= "general";

    public GeneralNews(String content,int userid){
        this.content=content;
        this.userid=userid;
        type=DATABASE_TYPE;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {return userid; }

    public void setUserid(int userid) { this.userid = userid; }

    public String getType() { return type; }

    public void setType(String type) { type = DATABASE_TYPE;}

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

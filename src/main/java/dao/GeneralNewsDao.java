package dao;

import  models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {
    //CREATE
    void add(GeneralNews generalNews);

    //READ
    List<GeneralNews> getAll();
    GeneralNews findById(int id);

    //UPDATE
//    void update (int id,String content,int userid);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

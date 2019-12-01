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

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

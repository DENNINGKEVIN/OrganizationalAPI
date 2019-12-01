package dao;

import models.*;

import java.util.List;

public interface DepartmentNewsDao {
    //CREATE
    void add(DepartmentNews departmentnews);

    //READ
    List<DepartmentNews> getAll();
    DepartmentNews findById(int id);


    //UPDATE

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

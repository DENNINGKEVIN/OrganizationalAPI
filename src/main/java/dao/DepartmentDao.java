package dao;

import models.*;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Department department);

    //READ
    List<Department> getAll();
    Department findById(int id);
    List<User> getAllUsersByDepartment(int id);
    List<DepartmentNews> getAllDepartmentNewsForDepartment(int id);

    //UPDATE

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

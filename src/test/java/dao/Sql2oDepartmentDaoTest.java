package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao=new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId,testDepartment.getId());
    }
    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department testDepartment1=setupNewDepartment1();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment1);
        assertEquals(2, departmentDao.getAll().size());
    }
    @Test
    public void noFoodtypesReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        Department department = setupNewDepartment();
        departmentDao.add(department);
        departmentDao.deleteById(department.getId());
        assertEquals(0, departmentDao.getAll().size());
    }
    @Test
    public void deleteAll() throws Exception{
        Department testDepartment=setupNewDepartment();
        Department testDepartment1=setupNewDepartment1();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment1);
        departmentDao.deleteAll();
        assertEquals(0,departmentDao.getAll().size());

    }
    @Test
    public void update() throws Exception{
        Department testDepartment=setupNewDepartment();
        departmentDao.add(testDepartment);
        departmentDao.update(testDepartment.getId(),"Ghosts","Was demolished");
        Department foundDepartment=departmentDao.findById(testDepartment.getId());
        assertEquals("Ghosts",foundDepartment.getName());
        assertEquals("Was demolished",foundDepartment.getDescription());
    }

    //helpers
    public Department setupNewDepartment(){
        return new Department("Animations","Where animations come to life");
    }
    public Department setupNewDepartment1(){
        return new Department("IT","We solve all your it problems");
    }
}

package ApartmentProject.repository;

import ApartmentProject.Model.Apartment;
import org.junit.*;
import org.slf4j.Logger;

import java.util.List;

public class ApartmentDaoTest {

    private ApartmentDao apartmentDao;
    private Logger logger;
    private Apartment a;
    private Apartment b;
    @Before
    public void init() {
        apartmentDao = new ApartmentDaoImpl();
        a = new Apartment();
        a.setId(9998);
        a.setLowestPrice("$2000");
        a.setName("ABC Apartment");
        a.setSmallestSize("studio");
        a.setPhoto("No Photo Available");
        apartmentDao.save(a);
    }

    @After
    public void tearDown(){
        apartmentDao.delete(a.getName());
    }

    @Test
    public void getDepartmentsTest() {
        List<Apartment> apartments = apartmentDao.getApartments();
        int expectedNumOfApt = 1;
        apartments.forEach(apt -> System.out.println(apt));
        Assert.assertEquals(expectedNumOfApt, apartments.size());
    }

    @Test
    public void deleteTest(){
        List<Apartment> apartments = apartmentDao.getApartments();
        int sizeBefore = apartments.size();
        b = new Apartment();
        b.setId(9999);
        b.setSmallestSize("one bed");
        b.setPhoto("no");
        b.setName("DDD");
        b.setLowestPrice("$10000");
        apartmentDao.save(b);
        apartments=apartmentDao.getApartments();
        int sizeAfter = apartments.size();
        logger.info("size before save: "+sizeBefore+" , size after save: "+sizeAfter);
        apartmentDao.delete(b.getName());
        apartments=apartmentDao.getApartments();
        logger.info("size before delete: "+sizeAfter+" , size after delete: "+apartments.size());
    }

    @Test
    public void saveTest(){
        List<Apartment> apartments = apartmentDao.getApartments();
        int sizeBefore = apartments.size();
        b = new Apartment();
        b.setId(9999);
        b.setSmallestSize("one bed");
        b.setPhoto("no");
        b.setName("DDD");
        b.setLowestPrice("$10000");
        apartmentDao.save(b);
        apartments=apartmentDao.getApartments();
        int sizeAfter = apartments.size();
        logger.info("size before save: "+sizeBefore+" , size after save: "+sizeAfter);
        apartmentDao.delete(b.getName());
        apartments=apartmentDao.getApartments();
        logger.info("size before delete: "+sizeAfter+" , size after delete: "+apartments.size());
    }

    @Test
    public void updateTest(){
        a.setName("changed!!!!");
        apartmentDao.update(a);
        List<Apartment> apartments = apartmentDao.getApartments();
        logger.info("name before update: abc , name after update: "+apartments.get(0).getName());
    }

}

package ApartmentProject.jdbc;

import ApartmentProject.JDBC.ApartmentDao;
import ApartmentProject.Model.Apartment;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ApartmentDaoTest {
    private ApartmentDao apartmentDao;
    private Apartment a;
    private Apartment b;

   /* @BeforeClass
    public void classSetup(){

    }

    @AfterClass
    public void classTearDown(){

    }*/

    @Before
    public void init(){
        apartmentDao = new ApartmentDao();
        a = new Apartment();
        a.setId(1);
        a.setLowestPrice("$2000");
        a.setName("ABC Apartment");
        a.setSmallestSize("studio");
        a.setPhoto("No Photo Available");
        apartmentDao.addApartment(a);
    }

    @After
    public void tearDown(){
        apartmentDao.deleteApartment(a.getId());
    }

    @Test
    public void getApartmentTest(){
        List<Apartment> apartments = apartmentDao.getApartment();
        for(int i=0;i<apartments.size();i++) {
            System.out.println(apartments.get(i).getName());
        }
    }

    @Test
    public void searchApartmentTest(){
        Apartment b = apartmentDao.searchApartment(a.getId());
        System.out.println(b.getName());
    }

    @Test
    public void addApartmentTest(){
        List<Apartment> apartments = apartmentDao.getApartment();
        int a=apartments.size();
        b = new Apartment();
        b.setId(2);
        b.setSmallestSize("one bed");
        b.setPhoto("no");
        b.setName("DDD");
        b.setLowestPrice("$10000");
        apartmentDao.addApartment(b);
        apartments = apartmentDao.getApartment();
        int b=apartments.size();
        System.out.println("size before adding "+a+" , size after adding "+b);
        apartmentDao.deleteApartment(2);
        System.out.println("size before deleting "+b+" , size after deleting "+ apartments.size() );
    }

    @Test
    public void deleteApartmentTest(){
        List<Apartment> apartments = apartmentDao.getApartment();
        int a=apartments.size();
        b = new Apartment();
        b.setId(2);
        b.setSmallestSize("one bed");
        b.setPhoto("no");
        b.setName("DDD");
        b.setLowestPrice("$10000");
        apartmentDao.addApartment(b);
        apartments = apartmentDao.getApartment();
        int b=apartments.size();
        System.out.println("size before adding "+a+" , size after adding "+b);
        apartmentDao.deleteApartment(2);
    }

    
}

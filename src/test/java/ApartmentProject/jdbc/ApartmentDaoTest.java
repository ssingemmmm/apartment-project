package ApartmentProject.jdbc;

import ApartmentProject.JDBC.ApartmentDao;
import ApartmentProject.Model.Apartment;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ApartmentDaoTest {
    private ApartmentDao apartmentDao;
    private Apartment a;

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
        List<Apartment> apartments = new ArrayList<>();

    }

    @Test
    public void searchApartmentTest(){
        Apartment b = apartmentDao.searchApartment(a.getId());
        System.out.println(b);
    }

    @Test
    public void addApartmentTest(){

    }

    
}

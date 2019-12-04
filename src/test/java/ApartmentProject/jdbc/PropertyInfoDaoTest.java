package ApartmentProject.jdbc;


import ApartmentProject.JDBC.ApartmentDao;
import ApartmentProject.JDBC.PropertyInfoDao;
import ApartmentProject.Model.Apartment;
import ApartmentProject.Model.PropertyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PropertyInfoDaoTest {
    private ApartmentDao apartmentDao;
    private Apartment c;
    private PropertyInfoDao propertyInfoDao;
    private PropertyInfo a;
    private PropertyInfo b;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String loggerInfo = System.getenv("logging.level.");
   /* @BeforeClass
    public void classSetup(){

    }

    @AfterClass
    public void classTearDown(){

    }*/

    @Before
    public void init(){
        apartmentDao = new ApartmentDao();
        c = new Apartment();
        c.setId(9998);
        c.setLowestPrice("$2000");
        c.setName("ABC Apartment");
        c.setSmallestSize("studio");
        c.setPhoto("No Photo Available");
        apartmentDao.addApartment(c);
        propertyInfoDao = new PropertyInfoDao();
        a = new PropertyInfo();
        a.setAmenities("gym");
        a.setApartmentId(9998);
        a.setDescription("best");
        a.setEmail("abc@abc.com");
        a.setExpenses("$100");
        a.setNeighborhood("Arlington");
        a.setId(9998);
        a.setOfficeHours("closed");
        a.setPhoneNumber(123123123);
        a.setAddress("Abc st");
        propertyInfoDao.addPropertyInfo(a);
    }

    @After
    public void tearDown(){

        propertyInfoDao.deletePropertyInfo(a.getId());
        apartmentDao.deleteApartment(c.getId());
    }

    @Test
    public void getPropertyInfoTest(){
        List<PropertyInfo> propertyInfos = propertyInfoDao.getPropertyInfo();
        for(int i=0;i<propertyInfos.size();i++) {
            logger.info(propertyInfos.get(i).getEmail());
        }
    }

    @Test
    public void searchPropertyInfoTest(){
        PropertyInfo b = propertyInfoDao.searchPropertyInfo(a.getId());
        logger.info("Searching for: "+a.getId()+" , Searching result returned: "+ b.getId());
    }

    @Test
    public void addPropertyInfoTest(){
        List<PropertyInfo> propertyInfos = propertyInfoDao.getPropertyInfo();
        int a=propertyInfos.size();
        b = new PropertyInfo();
        b.setId(9999);
        b.setAmenities("gym2");
        b.setApartmentId(9998);
        b.setDescription("worst");
        b.setEmail("abb@abc.com");
        b.setExpenses("$200");
        b.setNeighborhood("Arlington");
        b.setOfficeHours("closed");
        b.setPhoneNumber(123123124);
        b.setAddress("Abcd st");
        propertyInfoDao.addPropertyInfo(b);
        propertyInfos = propertyInfoDao.getPropertyInfo();
        int b=propertyInfos.size();
        logger.info("size before adding "+a+" , size after adding "+b);
        propertyInfoDao.deletePropertyInfo(9999);
        propertyInfos = propertyInfoDao.getPropertyInfo();
        logger.info("size before deleting "+b+" , size after deleting "+ propertyInfos.size() );
    }

    @Test
    public void deletePropertyInfoTest(){
        List<PropertyInfo> propertyInfos = propertyInfoDao.getPropertyInfo();
        int a=propertyInfos.size();
        b = new PropertyInfo();
        b.setId(9999);
        b.setAmenities("gym2");
        b.setApartmentId(9998);
        b.setDescription("worst");
        b.setEmail("abb@abc.com");
        b.setExpenses("$200");
        b.setNeighborhood("Arlington");
        b.setOfficeHours("closed");
        b.setPhoneNumber(123123124);
        b.setAddress("Abcd st");
        propertyInfoDao.addPropertyInfo(b);
        propertyInfos = propertyInfoDao.getPropertyInfo();
        int b=propertyInfos.size();
        logger.info("size before adding "+a+" , size after adding "+b);
        propertyInfoDao.deletePropertyInfo(9999);
        propertyInfos = propertyInfoDao.getPropertyInfo();
        logger.info("size before deleting "+b+" , size after deleting "+ propertyInfos.size() );
    }

    @Test
    public void updatePropertyInfoTest(){
        a.setDescription("changed!!!!");
        propertyInfoDao.updatePropertyInfo(a);
        PropertyInfo d = propertyInfoDao.searchPropertyInfo(9998);
        logger.info("name before update: best , name after update: "+d.getDescription());
    }

}

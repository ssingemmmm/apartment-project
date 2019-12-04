package ApartmentProject.repository;

import ApartmentProject.Model.PropertyInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

public class PropertyInfoDaoTest {
    private PropertyInfoDao propertyInfoDao;
    private Logger logger;

    @Before
    public void init() {
        propertyInfoDao = new PropertyInfoDaoImpl();
    }

    @Test
    public void getDepartments() {
        List<PropertyInfo> propertyInfos = propertyInfoDao.getPropertyInfos();
        int expectedNumOfProInfo = 1;

        propertyInfos.forEach(propertyInfo -> System.out.println(propertyInfo));
        Assert.assertEquals(expectedNumOfProInfo, propertyInfos.size());
    }
}

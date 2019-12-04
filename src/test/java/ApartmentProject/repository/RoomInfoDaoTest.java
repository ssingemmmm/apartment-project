package ApartmentProject.repository;

import ApartmentProject.Model.RoomInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

public class RoomInfoDaoTest {
    private RoomInfoDao roomInfoDao;
    private Logger logger;

    @Before
    public void init() {
        roomInfoDao = new RoomInfoDaoImpl();
    }

    @Test
    public void getDepartments() {
        List<RoomInfo> roomInfos = roomInfoDao.getRoomInfos();
        int expectedNumOfRoomInfo = 1;

        roomInfos.forEach(roomInfo -> System.out.println(roomInfo));
        Assert.assertEquals(expectedNumOfRoomInfo, roomInfos.size());
    }
}

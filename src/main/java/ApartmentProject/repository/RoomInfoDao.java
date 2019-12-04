package ApartmentProject.repository;

import ApartmentProject.Model.RoomInfo;

import java.util.List;

public interface RoomInfoDao {
    boolean save(RoomInfo roomInfo);
    boolean update(RoomInfo roomInfo);
    boolean delete(String id);
    List<RoomInfo> getRoomInfos();
}

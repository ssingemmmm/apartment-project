package ApartmentProject.repository;

import ApartmentProject.Model.PropertyInfo;

import java.util.List;

public interface PropertyInfoDao {
    boolean save(PropertyInfo propertyInfo);
    boolean update(PropertyInfo propertyInfo);
    boolean delete(int id);
    List<PropertyInfo> getPropertyInfos();
}

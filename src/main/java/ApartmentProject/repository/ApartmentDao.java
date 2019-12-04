package ApartmentProject.repository;

import ApartmentProject.Model.Apartment;

import java.util.List;

public interface ApartmentDao {
    boolean save(Apartment apartment);
    boolean update(Apartment apartment);
    boolean delete(String name);
    List<Apartment> getApartments();
}

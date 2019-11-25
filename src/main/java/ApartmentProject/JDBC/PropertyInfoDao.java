package ApartmentProject.JDBC;
import ApartmentProject.Model.Apartment;
import ApartmentProject.Model.PropertyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PropertyInfoDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //Step1:database information
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/apartment_db";
    private static final String USER="admin";
    private static final String PASS="TRAINING123!";

    //get all infos
    public List<PropertyInfo> getPropertyInfo() {
        List<PropertyInfo> propertyInfos = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            //stept2:open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 3:execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM propertyInfo";
            rs = stmt.executeQuery(sql);
            //step 4: extract data from result set
            while (rs.next()) {
                int id=rs.getInt("id");
                int apartmentId=rs.getInt("apartment_id");
                int phoneNumber=rs.getInt("phone_number");
                String streetAddress=rs.getString("street_address");
                String city=rs.getString("city");
                String state=rs.getString("state");
                String zipCode=rs.getString("zip_code");
                String email=rs.getString("email");
                String officeHours=rs.getString("office_hours");
                String expenses=rs.getString("expenses");
                String description=rs.getString("description");
                String amenities=rs.getString("amenities");
                String neighborhood=rs.getString("neighborhood");

                PropertyInfo propertyInfo = new PropertyInfo();
                propertyInfo.setAmenities(amenities);
                propertyInfo.setApartmentId(apartmentId);
                propertyInfo.setCity(city);
                propertyInfo.setDescription(description);
                propertyInfo.setEmail(email);
                propertyInfo.setExpenses(expenses);
                propertyInfo.setNeighborhood(neighborhood);
                propertyInfo.setId(id);
                propertyInfo.setOfficeHours(officeHours);
                propertyInfo.setPhoneNumber(phoneNumber);
                propertyInfo.setState(state);
                propertyInfo.setStreetAddress(streetAddress);
                propertyInfo.setZipCode(zipCode);


                propertyInfos.add(propertyInfo);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();

        } finally {
            //close resources
            try{
                if(rs != null)rs.close();
                if(stmt !=null) stmt.close();
                if(conn!= null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        logger.info("exit the method getApartment");
        return propertyInfos;
    }
}
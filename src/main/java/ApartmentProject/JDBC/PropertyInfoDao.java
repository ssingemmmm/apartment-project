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
                String address=rs.getString("address");
                String email=rs.getString("email");
                String officeHours=rs.getString("office_hours");
                String expenses=rs.getString("expenses");
                String description=rs.getString("description");
                String amenities=rs.getString("amenities");
                String neighborhood=rs.getString("neighborhood");

                PropertyInfo propertyInfo = new PropertyInfo();
                propertyInfo.setAmenities(amenities);
                propertyInfo.setApartmentId(apartmentId);

                propertyInfo.setDescription(description);
                propertyInfo.setEmail(email);
                propertyInfo.setExpenses(expenses);
                propertyInfo.setNeighborhood(neighborhood);
                propertyInfo.setId(id);
                propertyInfo.setOfficeHours(officeHours);
                propertyInfo.setPhoneNumber(phoneNumber);
                propertyInfo.setAddress(address);
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
        logger.info("exit the method getPropertyInfo");
        return propertyInfos;
    }

    //insert data
    public void addPropertyInfo(PropertyInfo propertyInfo){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //stept2:open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 3:execute a query
            String sql = "insert into propertyInfo (id,apartment_id,address,phone_number,email,office_hours,expenses,description,amenities,neighborhood) values(?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, propertyInfo.getId());
            stmt.setInt(2, propertyInfo.getApartmentid());
            stmt.setString(3, propertyInfo.getAddress());
            stmt.setInt(4, propertyInfo.getPhoneNumber());
            stmt.setString(5, propertyInfo.getEmail());
            stmt.setString(6, propertyInfo.getOfficeHours());
            stmt.setString(7, propertyInfo.getExpenses());
            stmt.setString(8, propertyInfo.getDescription());
            stmt.setString(9, propertyInfo.getAmenities());
            stmt.setString(10, propertyInfo.getNeighborhood());
            stmt.execute();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("exit the method addPropertyInfo");
    }

    //delete data
    public void deletePropertyInfo(int id){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //stept2:open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 3:execute a query
            String sql = "delete from propertyInfo where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("exit the method deletePropertyInfo");
    }

    //insert data
    public void updatePropertyInfo(PropertyInfo propertyInfo){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //stept2:open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 3:execute a query
            String sql = "update propertyInfo set apartment_id=?,address=?,phone_number=?,email=?,office_hours=?,expenses=?,description=?,amenities=?,neighborhood=? where id=?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, propertyInfo.getApartmentid());
            stmt.setString(2, propertyInfo.getAddress());
            stmt.setInt(3, propertyInfo.getPhoneNumber());
            stmt.setString(4, propertyInfo.getEmail());
            stmt.setString(5, propertyInfo.getOfficeHours());
            stmt.setString(6, propertyInfo.getExpenses());
            stmt.setString(7, propertyInfo.getDescription());
            stmt.setString(8, propertyInfo.getAmenities());
            stmt.setString(9, propertyInfo.getNeighborhood());
            stmt.setInt(10, propertyInfo.getId());
            stmt.execute();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("exit the method updatePropertyInfo");
    }

    //search roomInfo
    public PropertyInfo searchPropertyInfo(int id){
        PropertyInfo propertyInfo = new PropertyInfo();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        try {
            //stept2:open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 3:execute a query
            String sql = "select * from propertyInfo where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            //step 4: extract data from result set
            while (rs.next()) {
                int apartmentId=rs.getInt("apartment_id");
                int phoneNumber=rs.getInt("phone_number");
                String address=rs.getString("address");
                String email=rs.getString("email");
                String officeHours=rs.getString("office_hours");
                String expenses=rs.getString("expenses");
                String description=rs.getString("description");
                String amenities=rs.getString("amenities");
                String neighborhood=rs.getString("neighborhood");
                propertyInfo.setAmenities(amenities);
                propertyInfo.setApartmentId(apartmentId);

                propertyInfo.setDescription(description);
                propertyInfo.setEmail(email);
                propertyInfo.setExpenses(expenses);
                propertyInfo.setNeighborhood(neighborhood);
                propertyInfo.setId(id);
                propertyInfo.setOfficeHours(officeHours);
                propertyInfo.setPhoneNumber(phoneNumber);
                propertyInfo.setAddress(address);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("exit the method searchPropertyInfo");

        return propertyInfo;
    }
}
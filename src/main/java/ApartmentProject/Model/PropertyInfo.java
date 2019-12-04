package ApartmentProject.Model;

import javax.persistence.*;

@Entity
@Table(name="propertyinfo")
public class PropertyInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="apartment_id")
    private int apartmentId;

    @Column(name="phone_number")
    private int phoneNumber;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="office_hours")
    private String officeHours;

    @Column(name="expenses")
    private String expenses;

    @Column(name="description")
    private String description;

    @Column(name="amenities")
    private String amenities;

    @Column(name="neighborhood")
    private String neighborhood;


    public int getId(){
        return id;
    }

    public void setId(int id){

        this.id=id;
    }

    public int getApartmentid(){

        return apartmentId;
    }

    public void setApartmentId(int apartmentId){

        this.apartmentId=apartmentId;
    }

    public int getPhoneNumber(){

        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber){

        this.phoneNumber=phoneNumber;
    }

    public String getAddress(){

        return address;
    }

    public void setAddress(String streetAddress){

        this.address=address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getOfficeHours(){
        return officeHours;
    }

    public void setOfficeHours(String officeHours){
        this.officeHours=officeHours;
    }

    public String getExpenses(){
        return expenses;
    }

    public void setExpenses(String expenses){
        this.expenses=expenses;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getAmenities(){
        return amenities;
    }

    public void setAmenities(String amenities){
        this.amenities=amenities;
    }

    public String getNeighborhood(){
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood){
        this.neighborhood=neighborhood;
    }
}

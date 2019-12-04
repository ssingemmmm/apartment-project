package ApartmentProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roominfo")
public class RoomInfo {
    @Id
    private String id;

    @Column(name="apartment_id")
    private int apartmentId;

    @Column(name="floor")
    private int floor;

    @Column(name="type")
    private String type;

    @Column(name="price_range")
    private String priceRange;

    @Column(name="available_date")
    private String availableDate;

    @Column(name="layout_photo")
    private String layoutPhoto;

    public String getId(){
        return id;
    }

    public void setId(String id){

        this.id=id;
    }

    public int getApartmentid(){

        return apartmentId;
    }

    public void setApartmentId(int apartmentId){

        this.apartmentId=apartmentId;
    }

    public int getFloor(){
        return floor;
    }

    public void setFloor(int floor){
        this.floor=floor;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getPriceRange(){
        return priceRange;
    }

    public void setPriceRange(String priceRange){
        this.priceRange=priceRange;
    }

    public String getAvailableDate(){
        return availableDate;
    }

    public void setAvailableDate(String availableDate){
        this.availableDate=availableDate;
    }

    public String getLayoutPhoto(){
        return layoutPhoto;
    }

    public void setLayoutPhoto(String layoutPhoto){
        this.layoutPhoto=layoutPhoto;
    }

}

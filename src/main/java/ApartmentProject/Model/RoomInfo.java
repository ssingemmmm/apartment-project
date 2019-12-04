package ApartmentProject.Model;

public class RoomInfo {
    private String id;
    private int apartmentId;
    private int floor;
    private String type;
    private String priceRange;
    private String availableDate;
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

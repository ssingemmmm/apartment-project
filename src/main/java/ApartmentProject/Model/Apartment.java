package ApartmentProject.Model;

public class Apartment {
    private int id;
    private String name;
    private String lowestPrice;
    private String smallestSize;
    private String photo;

    public int getId(){
        return id;
    }

    public void setId(int id){

        this.id=id;
    }

    public String getName(){

        return name;
    }

    public void setName(String name){

        this.name=name;
    }

    public String getLowestPrice(){

        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice){

        this.lowestPrice=lowestPrice;
    }

    public String getSmallestSize(){

        return smallestSize;
    }

    public void setSmallestSize(String smallestSize){

        this.smallestSize=smallestSize;
    }

    public String getPhoto(){
        return photo;
    }

    public void setPhoto(String photo){
        this.photo=photo;
    }
}

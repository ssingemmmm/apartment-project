package ApartmentProject.Model;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lowest_price")
    private String lowestPrice;

    @Column(name = "smallest_size")
    private String smallestSize;

    @Column(name = "photo")
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

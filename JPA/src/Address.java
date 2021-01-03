import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String zipCode;
    private String street;

    public Address(){

    }

    public Address(String city, String zipCode, String street){
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }
}

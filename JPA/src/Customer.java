import javax.persistence.Entity;

@Entity
public class Customer extends Company{
    private int discount;

    public Customer(){

    }

    public Customer(String companyName, String street, String city, String zipCode,
                    int discount){
        super(companyName,street,city,zipCode);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "discount=" + discount +
                '}';
    }
}

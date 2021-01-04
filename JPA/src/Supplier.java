
import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier extends Company{

    public String bankAccountNumber;

    @OneToMany
    @JoinColumn(name="SUPPLIER_FK")
    private Set<Product> products;


    public Supplier(){

    }

    public Supplier(String companyName, String street, String city, String zipCode,
                    String bankAccountNumber, Set<Product> products){
        super(companyName, street, city, zipCode);
        this.bankAccountNumber = bankAccountNumber;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "bankAccountNumber='" + bankAccountNumber + '\'' +
                ", products=" + products +
                '}';
    }
}

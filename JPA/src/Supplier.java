
import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SupplierID;
    private String CompanyName;
    //private String Street;
    //private String City;
    @OneToMany
    @JoinColumn(name="SUPPLIER_FK")
    private Set<Product> products;
    @Embedded
    private Address address;

    public Supplier(){

    }

    public Supplier(String CompanyName, Set<Product> products,
                    Address address){
        this.CompanyName = CompanyName;
        //this.Street = Street;
        //this.City = City;
        this.products = products;
        this.address = address;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "SupplierID=" + SupplierID +
                ", CompanyName='" + CompanyName + '\'' +
                ", products=" + products +
                '}';
    }
}


import javax.persistence.*;
import java.util.Set;

@Entity
@SecondaryTable(name = "ADDRESS")
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
    /*@Embedded
    private Address address;*/
    @Column(table = "ADDRESS")
    private String city;
    @Column(table = "ADDRESS")
    private String zipCode;
    @Column(table = "ADDRESS")
    private String street;


    public Supplier(){

    }

    public Supplier(String CompanyName, Set<Product> products,
                    String city, String zipCode, String street){
        this.CompanyName = CompanyName;
        //this.Street = Street;
        //this.City = City;
        this.products = products;
        //this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
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

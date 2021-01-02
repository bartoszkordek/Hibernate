
import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SupplierID;
    private String CompanyName;
    private String Street;
    private String City;
    @OneToMany
    @JoinColumn(name="SUPPLIER_FK")
    private Set<Product> products;

    public Supplier(){

    }

    public Supplier(String CompanyName, String Street, String City, Set<Product> products){
        this.CompanyName = CompanyName;
        this.Street = Street;
        this.City = City;
        this.products = products;
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
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", products=" + products +
                '}';
    }
}

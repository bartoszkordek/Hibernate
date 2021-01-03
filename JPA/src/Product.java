import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProductID;
    private String ProductName;
    private int UnitsInStock;
    @ManyToOne
    @JoinColumn(name="SUPPLIER_FK")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name="CATEGORY_FK")
    private Category category;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Invoice> invoices;

    public Product(){

    }

    public Product(String ProductName, int UnitsInStock, Supplier supplier, Category category,
                   Set<Invoice> invoices){
        this.ProductName=ProductName;
        this.UnitsInStock=UnitsInStock;
        this.supplier=supplier;
        this.category=category;
        this.invoices=invoices;
    }

    public String getProductName() {
        return ProductName;
    }

    public Category getCategory() {
        return category;
    }

    public Set<Invoice> getInvoices(){
        return invoices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID=" + ProductID +
                ", ProductName='" + ProductName + '\'' +
                ", UnitsInStock=" + UnitsInStock +
                ", supplier=" + supplier.getSupplierID() + ' ' + supplier.getCompanyName() +
                ", category=" + category.getCategoryID() + ' ' + category.getName() +
                '}';
    }
}

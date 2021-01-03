import javax.persistence.*;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceID;
    private int InvoiceNumber;
    private int Quantity;
    @ManyToMany(mappedBy = "invoices", cascade = CascadeType.PERSIST)
    private Set<Product> products;

    public Invoice(){

    }

    public Invoice(int InvoiceNumber, int Quantity, Set<Product> products){
        this.InvoiceNumber = InvoiceNumber;
        this.Quantity = Quantity;
        this.products = products;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "InvoiceID=" + InvoiceID +
                ", InvoiceNumber=" + InvoiceNumber +
                ", Quantity=" + Quantity +
                ", products=" + products +
                '}';
    }
}

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CategoryID;
    private String Name;
    @OneToMany
    @JoinColumn(name = "CATEGORY_FK")
    private List<Product> Products;

    public Category(){

    }

    public Category(String Name, List<Product> Products){
        this.Name = Name;
        this.Products = Products;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryID=" + CategoryID +
                ", Name='" + Name + '\'' +
                '}';
    }

}

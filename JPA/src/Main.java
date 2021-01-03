import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BKordekJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        Set<Product> productSetForSupplier1 = new HashSet<>();
        Set<Product> productSetForSupplier2 = new HashSet<>();

        List<Product> productListForCategory1 = new ArrayList<>();
        List<Product> productListForCategory2 = new ArrayList<>();

        Set<Product> productSetForInvoice1 = new HashSet<>();
        Set<Product> productSetForInvoice2 = new HashSet<>();
        Set<Product> productSetForInvoice3 = new HashSet<>();

        Set<Invoice> invoiceSetForProduct1 = new HashSet<>();
        Set<Invoice> invoiceSetForProduct2 = new HashSet<>();
        Set<Invoice> invoiceSetForProduct3 = new HashSet<>();

        Category category1 = new Category("Mrożonki", productListForCategory1);
        Category category2 = new Category("Przekąski", productListForCategory2);

        Supplier supplier1 = new Supplier("Tesco", "Kapelanka", "Kraków", productSetForSupplier1);
        Supplier supplier2 = new Supplier("Żabka", "Sołtysowka", "Kraków", productSetForSupplier2);

        Invoice invoice1 = new Invoice(123,10,productSetForInvoice1);
        Invoice invoice2 = new Invoice(124,10,productSetForInvoice2);
        Invoice invoice3 = new Invoice(125,10,productSetForInvoice3);

        Product product1 = new Product("Frytki", 20, supplier1, category1, invoiceSetForProduct1);
        Product product2 = new Product("Pizza", 10, supplier1, category1, invoiceSetForProduct2);
        Product product3 = new Product("Chipsy", 50, supplier2, category2, invoiceSetForProduct3);

        productSetForInvoice1.add(product1);
        productSetForInvoice1.add(product2);
        productSetForInvoice1.add(product3);

        productSetForInvoice2.add(product1);
        productSetForInvoice2.add(product3);

        productSetForInvoice3.add(product3);

        invoiceSetForProduct1.add(invoice1);
        invoiceSetForProduct1.add(invoice2);

        invoiceSetForProduct2.add(invoice1);

        invoiceSetForProduct3.add(invoice1);
        invoiceSetForProduct3.add(invoice2);
        invoiceSetForProduct3.add(invoice3);

        productSetForSupplier1.add(product1);
        productSetForSupplier1.add(product2);
        productSetForSupplier2.add(product3);

        productListForCategory1.add(product1);
        productListForCategory1.add(product2);
        productListForCategory2.add(product3);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        em.persist(supplier1);
        em.persist(supplier2);

        em.persist(category1);
        em.persist(category2);

        em.persist(invoice1);
        em.persist(invoice2);
        em.persist(invoice3);

        Invoice invoice = em.find(Invoice.class, 8);
        for(Product product : invoice.getProducts())
            System.out.println("Product Name: " + product.getProductName());

        Product product = em.find(Product.class, 1);
        for(Invoice inv : product.getInvoices())
            System.out.println("Invoice ID: " + inv.getInvoiceID() +
                    " Invoice Number: " + inv.getInvoiceNumber());

        etx.commit();
        em.close();
    }
}
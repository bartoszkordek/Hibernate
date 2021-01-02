import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
/*
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
*/
        Transaction tx = session.beginTransaction();
/*
        session.save(product1);
        session.save(product2);
        session.save(product3);

        session.save(supplier1);
        session.save(supplier2);

        session.save(category1);
        session.save(category2);

        session.save(invoice1);
        session.save(invoice2);
        session.save(invoice3);
*/
        /*
        Invoice invoice = session.find(Invoice.class, 8);
        for(Product product : invoice.getProducts())
            System.out.println("Product Name: " + product.getProductName());
*/
        Product product = session.find(Product.class, 1);
        for(Invoice invoice : product.getInvoices())
            System.out.println("Invoice ID: " + invoice.getInvoiceID() +
                    " Invoice Number: " + invoice.getInvoiceNumber());
        /*
        Category category = session.find(Category.class, 6);
        System.out.println("Category Name: "+ category.getName());
        for(Product product : category.getProducts()){
            System.out.println("Product Name: " + product.getProductName());
        }

         */
        /*
        Product product = session.find(Product.class, 1);
        System.out.println("Product Category ID: "+ product.getCategory().getCategoryID()+
                ", Product Category Name: " + product.getCategory().getName());
        */
        tx.commit();
        //session.close();

        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}
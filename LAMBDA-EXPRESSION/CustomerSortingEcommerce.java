// Lambda Expressions – Custom Sorting in E-Commerce

class Product {
    String name;
    double price;
    double rating;
    double discount;
}

class Shop {
    void sortProducts(List<Product> products, String mode) {
        if (mode == "price") products.sort((a,b) -> Double.compare(a.price, b.price));
        else if (mode == "rating") products.sort((a,b) -> Double.compare(b.rating, a.rating));
        else if (mode == "discount") products.sort((a,b) -> Double.compare(b.discount, a.discount));

        for (Product p : products) print p.name + " : " + p.price + " / " + p.rating + " / " + p.discount;
    }
}

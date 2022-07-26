package marino.busniess.services;

import marino.busniess.models.Product;
import marino.busniess.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    ProductsRepository productsRepository;

    public Product createProduct(Product product) {return productsRepository.save(product);}

    public List<Product> getProducts() { return productsRepository.findAll();}

    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productsRepository.findById(productId).get();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setInventory(productDetails.getInventory());
        product.setCost(productDetails.getCost());
        return productsRepository.save(product);
    }
    public void deleteProduct(Long empId) { productsRepository.deleteById(empId);}
}

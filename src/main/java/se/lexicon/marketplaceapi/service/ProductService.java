package se.lexicon.marketplaceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.ProductDTORequest;
import se.lexicon.marketplaceapi.entity.Product;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public ProductService(ProductRepository productRepository, AuthenticationService authenticationService) {
        this.productRepository = productRepository;
        this.authenticationService = authenticationService;
    }

    public Product createProduct(ProductDTORequest productDTORequest, String email, String password) {

        User user = authenticationService.authenticate(email, password);
        Product product = new Product();
        product.setName(productDTORequest.getName());
        product.setDescription(productDTORequest.getDescription());
        product.setPrice(productDTORequest.getPrice());
        product.setExpiryDate(productDTORequest.getExpiryDate());
        product.setUser(user);
       return productRepository.save(product);
    }
    public List<Product> getProducts(Long userId) {
        return productRepository.findByUser_UserId(userId);
    }
    public List<Product> getActiveProducts() {
        return productRepository.findByExpiryDateAfter(LocalDate.now());
    }
}

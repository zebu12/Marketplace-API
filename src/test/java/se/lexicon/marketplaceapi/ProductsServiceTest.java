package se.lexicon.marketplaceapi;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.marketplaceapi.dto.ProductDTORequest;
import se.lexicon.marketplaceapi.entity.Product;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.ProductRepository;
import se.lexicon.marketplaceapi.service.AuthenticationService;
import se.lexicon.marketplaceapi.service.ProductService;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductsServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testCreateProduct() {
        String email = "test@test.com";
        String password = "password";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        ProductDTORequest productDTORequest = new ProductDTORequest();
        productDTORequest.setName("test");
        productDTORequest.setDescription("description");
        productDTORequest.setExpiryDate(LocalDate.now());

        Product product = new Product();
        product.setName("test");
        product.setDescription("description");
        product.setExpiryDate(LocalDate.now());
        product.setUser(user);

        when(authenticationService.authenticate(email,password)).thenReturn(user);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createProduct = productService.createProduct(productDTORequest,email,password);
        assertNotNull(createProduct);
        assertEquals("test", createProduct.getName());

    }
}

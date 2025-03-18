package se.lexicon.marketplaceapi.controller;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.ProductDTORequest;
import se.lexicon.marketplaceapi.dto.ProductDTOResponse;
import se.lexicon.marketplaceapi.dtoConverter.DtoConverter;
import se.lexicon.marketplaceapi.entity.Product;
import se.lexicon.marketplaceapi.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/createProduct")
    @ApiResponse(responseCode = "200",description = "created successfully")
    @ApiResponse(responseCode = "400",description = "invalid input")
    @ApiResponse(responseCode = "401",description = "unauthorized")
    public ResponseEntity<ProductDTOResponse> createProduct(
            @Valid @RequestBody  ProductDTORequest productDTORequest ,
            @RequestParam String email ,
            @RequestParam String password) {

        Product product = productService.createProduct(productDTORequest, email, password);
        ProductDTOResponse response = DtoConverter.covertProductDTO(product);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/activeproducts")
    @ApiResponse(responseCode = "200",description = "list of active products")
    public ResponseEntity<List<ProductDTOResponse>> getActiveProducts() {
        List<Product> products = productService.getActiveProducts();
        List<ProductDTOResponse> responses = products.stream().map(DtoConverter::covertProductDTO).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}

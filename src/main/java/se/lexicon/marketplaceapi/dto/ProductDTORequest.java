package se.lexicon.marketplaceapi.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ProductDTORequest {

    @NotBlank(message = "Please enter a name")
    private String name;
    private String description;
    @NotBlank(message = "Please enter the price")
    private Double price;
    @Future(message = "the date should be on the future")
    private LocalDate expiryDate;

    public ProductDTORequest() {
    }

    public ProductDTORequest(String name, String description, Double price, LocalDate expiryDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}

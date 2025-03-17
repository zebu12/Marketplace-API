package se.lexicon.marketplaceapi.dto;

import java.time.LocalDate;

public class ProductDTOResponse {

    private Long adId;
    private String name;
    private String description;
    private Double price;
    private LocalDate expiryDate;
    private UserDTOResponse user;
    public ProductDTOResponse() {
    }

    public ProductDTOResponse(Long adId, String name, String description, Double price, LocalDate expiryDate, UserDTOResponse user) {
        this.adId = adId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
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

    public UserDTOResponse getUser() {
        return user;
    }

    public void setUser(UserDTOResponse user) {
        this.user = user;
    }
}

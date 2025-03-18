package se.lexicon.marketplaceapi.dtoConverter;

import se.lexicon.marketplaceapi.dto.ProductDTOResponse;
import se.lexicon.marketplaceapi.dto.UserDTOResponse;
import se.lexicon.marketplaceapi.entity.Product;
import se.lexicon.marketplaceapi.entity.User;

public class DtoConverter {
    public static UserDTOResponse covertUserDTO(User user) {
        UserDTOResponse userDTOResponse = new UserDTOResponse();
        userDTOResponse.setUserId(user.getUserId());
        userDTOResponse.setEmail(user.getEmail());
        return userDTOResponse;
    }

    public static ProductDTOResponse covertProductDTO(Product product) {
        ProductDTOResponse productDTOResponse = new ProductDTOResponse();
        productDTOResponse.setAdId(product.getAdId());
        productDTOResponse.setName(product.getName());
        productDTOResponse.setDescription(product.getDescription());
        productDTOResponse.setPrice(product.getPrice());
        productDTOResponse.setExpiryDate(product.getExpiryDate());
        productDTOResponse.setUser(covertUserDTO(product.getUser()));
        return productDTOResponse;
    }
}

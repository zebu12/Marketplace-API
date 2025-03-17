package se.lexicon.marketplaceapi.repository;

import se.lexicon.marketplaceapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByExpiryDateAfter(LocalDate currentDate);
    List<Product> findByUser_UserId(Long userId);
//    List<Product> findAllByPrice(double price);


}

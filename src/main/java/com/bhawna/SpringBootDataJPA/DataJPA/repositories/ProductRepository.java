package com.bhawna.SpringBootDataJPA.DataJPA.repositories;

import com.bhawna.SpringBootDataJPA.DataJPA.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findBy(Sort sort);
    List<ProductEntity> findByOrderByTitle();
    List<ProductEntity> findByTitle(String pepsi);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);
    List<ProductEntity> findByTitleLike(String title);
    List<ProductEntity> findByTitleContaining(String title, Pageable pageable);
//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from ProductEntity p where p.title=?1 and p.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}

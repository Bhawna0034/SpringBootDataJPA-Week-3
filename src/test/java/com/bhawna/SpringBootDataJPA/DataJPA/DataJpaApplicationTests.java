package com.bhawna.SpringBootDataJPA.DataJPA;

import com.bhawna.SpringBootDataJPA.DataJPA.entities.ProductEntity;
import com.bhawna.SpringBootDataJPA.DataJPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DataJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.price(BigDecimal.valueOf(9.5))
				.quantity(2)
				.sku("nestle799")
				.title("Nestle Chocolate")
				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(productEntity);
	}

	@Test
	void getRepository(){
		//List<ProductEntity> productEntities = productRepository.findByQuantityAndPrice(2,BigDecimal.valueOf(9.5));
	    //List<ProductEntity> productEntities = productRepository.findByTitleLike("%Choco%");
		List<ProductEntity> productEntities = productRepository.findByTitleContaining("Choco");
			System.out.println(productEntities);
		}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Coca-cola",BigDecimal.valueOf(18.5));
		entity.ifPresent(System.out::println);
	}
	}






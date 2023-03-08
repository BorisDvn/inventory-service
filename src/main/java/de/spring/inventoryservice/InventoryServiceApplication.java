package de.spring.inventoryservice;

import de.spring.inventoryservice.entities.Category;
import de.spring.inventoryservice.entities.Product;
import de.spring.inventoryservice.repository.CategoryRepository;
import de.spring.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            List.of("Computer", "Printer", "Smartphone").forEach(
                    cat -> {
                        Category category = Category.builder().name(cat).build();
                        categoryRepository.save(category);
                    }
            );

            Random random = SecureRandom.getInstanceStrong();
            categoryRepository.findAll().forEach(category -> {
                for (int i = 0; i < 10; i++) {
                    Product product = Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Product " + i)
                            .price(100 + Math.random() * 5000)
                            .quantity(random.nextInt(100))
                            .category(category).build();

                    productRepository.save(product);
                }


            });

        };
    }

}

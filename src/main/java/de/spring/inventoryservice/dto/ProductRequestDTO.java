package de.spring.inventoryservice.dto;

// java 14, immutable; il genere le rest lors de la compilation
public record ProductRequestDTO(String id,
                                String name,
                                double price,
                                int quantity,
                                Long categoryId) {
}

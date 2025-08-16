package br.com.movierflix.response;

import java.time.LocalDateTime;

public record MovieResponse(Long id, String title, String description, LocalDateTime releaseDate, double rating, LocalDateTime createdAt, LocalDateTime updatedAt) {
}

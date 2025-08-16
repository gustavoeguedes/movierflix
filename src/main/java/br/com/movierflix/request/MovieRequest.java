package br.com.movierflix.request;

import java.time.LocalDateTime;

public record MovieRequest(String title, String description, LocalDateTime releaseDate, double rating) {
}

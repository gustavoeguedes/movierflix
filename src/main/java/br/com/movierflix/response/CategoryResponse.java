package br.com.movierflix.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}

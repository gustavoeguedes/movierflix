package br.com.movierflix.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}

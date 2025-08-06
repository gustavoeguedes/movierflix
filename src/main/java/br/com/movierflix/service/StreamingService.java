package br.com.movierflix.service;

import br.com.movierflix.entity.Streaming;
import br.com.movierflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StreamingService {
    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> findAll() {
        return this.streamingRepository.findAll();
    }

    public Streaming create(Streaming newStreaming) {
        return this.streamingRepository.save(newStreaming);
    }

    public Optional<Streaming> findById(Long id) {
        return this.streamingRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.streamingRepository.deleteById(id);
    }
}

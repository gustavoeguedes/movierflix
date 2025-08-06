package br.com.movierflix.controller;

import br.com.movierflix.entity.Category;
import br.com.movierflix.entity.Streaming;
import br.com.movierflix.mapper.CategoryMapper;
import br.com.movierflix.mapper.StreamingMapper;
import br.com.movierflix.repository.StreamingRepository;
import br.com.movierflix.request.CategoryRequest;
import br.com.movierflix.request.StreamingRequest;
import br.com.movierflix.response.CategoryResponse;
import br.com.movierflix.response.StreamingResponse;
import br.com.movierflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movierflix/streaming")
public class StreamingController {
    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreamings() {

        List<Streaming> streamings = this.streamingService.findAll();
        List<StreamingResponse> list = streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = this.streamingService.create(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
        return this.streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (this.streamingService.findById(id).isPresent()) {
            this.streamingService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}

package dev.dluks.jsp03.controllers;

import dev.dluks.jsp03.dtos.ClientDTO;
import dev.dluks.jsp03.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Page<ClientDTO>> findAll(
            Pageable pageable) {

        Page<ClientDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(
            @PathVariable Long id) {

        ClientDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ClientDTO> insert(
            @Valid @RequestBody ClientDTO dto
    ) {

        ClientDTO result = service.insert(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ClientDTO dto
    ) {

        ClientDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

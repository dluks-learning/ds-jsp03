package dev.dluks.jsp03.services;

import dev.dluks.jsp03.dtos.ClientDTO;
import dev.dluks.jsp03.entities.Client;
import dev.dluks.jsp03.exceptions.ResourceNotFoundException;
import dev.dluks.jsp03.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client toInsert = new Client();
        copyDTOToClient(dto, toInsert);
        toInsert = repository.save(toInsert);
        return new ClientDTO(toInsert);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        Client toUpdate = repository.getReferenceById(id);
        copyDTOToClient(dto, toUpdate);
        toUpdate = repository.save(toUpdate);
        return new ClientDTO(toUpdate);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
        repository.deleteById(id);
    }

    private void copyDTOToClient(ClientDTO dto, Client toInsert) {
        toInsert.setName(dto.name());
        toInsert.setCpf(dto.cpf());
        toInsert.setIncome(dto.income());
        toInsert.setBirthDate(dto.birthDate());
        toInsert.setChildren(dto.children());
    }
}

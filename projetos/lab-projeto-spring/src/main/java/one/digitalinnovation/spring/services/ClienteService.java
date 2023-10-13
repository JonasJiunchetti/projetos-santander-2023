package one.digitalinnovation.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.spring.entities.Cliente;
import one.digitalinnovation.spring.entities.Endereco;
import one.digitalinnovation.spring.repositories.ClienteRepository;
import one.digitalinnovation.spring.repositories.EnderecoRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
	private ViaCepService viaCepService;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();

    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
        
    }

    public void save(Cliente cliente) {
        saveClienteWithCep(cliente);

    }

    public void update(Long id, Cliente cliente) {
        Optional<Cliente> clientedb = clienteRepository.findById(id);
            if(clientedb.isPresent())   {
                saveClienteWithCep(cliente);
        }
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);

    }

    private void saveClienteWithCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.searchCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}

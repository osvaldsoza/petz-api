package com.osvaldsoza.petzapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.osvaldsoza.petzapi.model.Cliente;
import com.osvaldsoza.petzapi.repository.ClienteRepository;
import com.osvaldsoza.petzapi.utils.exception.EntidadeEmUsoException;
import com.osvaldsoza.petzapi.utils.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarClientePorId(Long clienteId) {
		var cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Cliente de código %d não encontrado.", clienteId)));
		
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Long clienteId, Cliente cliente) {
		var clienteAtual = buscarClientePorId(clienteId);

		BeanUtils.copyProperties(cliente, clienteAtual, "id");
		
		return salvar(clienteAtual);
	}
	
	public void remover(Long clienteId) {
		try {
			clienteRepository.deleteById(clienteId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Cliente de código %d não encontrado.", clienteId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Exclusão não permitida! Cliente de código %d está em uso.", clienteId));
		}
	}
}

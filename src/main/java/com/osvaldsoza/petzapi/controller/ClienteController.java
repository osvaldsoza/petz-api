package com.osvaldsoza.petzapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldsoza.petzapi.controller.openapi.ClienteControllerOpenApi;
import com.osvaldsoza.petzapi.model.Cliente;
import com.osvaldsoza.petzapi.service.ClienteService;
import com.osvaldsoza.petzapi.utils.exception.EntidadeEmUsoException;
import com.osvaldsoza.petzapi.utils.exception.EntidadeNaoEncontradaException;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController implements ClienteControllerOpenApi {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listaClientes() {
		return clienteService.listaClientes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable("id") Long clienteID) {
		try {
			var cliente = clienteService.buscarClientePorId(clienteID);
			return ResponseEntity.ok().body(cliente);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizaCliente(Long clienteId, @RequestBody @Valid Cliente cliente) {
		try {
			cliente = clienteService.atualizar(clienteId, cliente);
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long clienteId) {
		try {
			clienteService.remover(clienteId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}

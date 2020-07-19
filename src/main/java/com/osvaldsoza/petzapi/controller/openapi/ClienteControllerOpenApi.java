package com.osvaldsoza.petzapi.controller.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.osvaldsoza.petzapi.model.Cliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Clientes")
public interface ClienteControllerOpenApi {

	@ApiOperation("Lista os clientes")
	public List<Cliente> listaClientes();

	@ApiOperation("Busca um cliente pelo ID")
	@ApiResponses({ @ApiResponse(code = 400, message = "ID do cliente inválido"),
			@ApiResponse(code = 404, message = "Cliente não encontrado") })
	public ResponseEntity<?> buscarCliente(@ApiParam(value = "ID de um cliente", example = "1") Long clienteID);

	@ApiOperation("Cadastra um cliente")
	@ApiResponses({ @ApiResponse(code = 201, message = "Cliente cadastrado") })
	public Cliente adicionaCliente(
			@ApiParam(name = "corpo", value = "Representação de um novo cliente") Cliente cliente);

	@ApiOperation("Atualiza um cliente pelo ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cliente atualizado"),
			@ApiResponse(code = 404, message = "Cliente não encontrado") })
	public ResponseEntity<?> atualizaCliente(@ApiParam(value = "ID de um cliente", example = "1") Long clienteId,
			@ApiParam(name = "corpo", value = "Representação de um novo cliente com novos dados") Cliente cliente);

	@ApiOperation("Exclui um cliente pelo ID")
	@ApiResponses({ @ApiResponse(code = 204, message = "Cliente excluído"),
			@ApiResponse(code = 404, message = "Cliente não encontrado") })
	public ResponseEntity<?> excluir(@ApiParam(value = "ID de um cliente", example = "1") Long clienteId);

}

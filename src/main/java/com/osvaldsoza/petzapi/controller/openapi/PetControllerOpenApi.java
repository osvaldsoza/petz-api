package com.osvaldsoza.petzapi.controller.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.osvaldsoza.petzapi.model.Pet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pets")
public interface PetControllerOpenApi {
	
	@ApiOperation("Lista os pets")
	public List<Pet> listaPets();
	
	@ApiOperation("Busca um pet pelo ID")
	@ApiResponses({ @ApiResponse(code = 400, message = "ID do pet inválido"),
		@ApiResponse(code = 404, message = "Pet não encontrado") })
	public ResponseEntity<?> buscarpet(
			@ApiParam(value = "ID de um pet", example = "1") Long petID);

	@ApiOperation("Cadastra um pet")
	@ApiResponses({ @ApiResponse(code = 201, message = "Pet cadastrado") })
	public Pet adicionaPet(
			@ApiParam(name = "corpo", value = "Representação de um novo pet") Pet pet);

	@ApiOperation("Atualiza um pet pelo ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pet atualizado"),
		@ApiResponse(code = 404, message = "Pet não encontrado") })
	public ResponseEntity<?> atualizapet(
			@ApiParam(value = "ID de um pet", example = "1") Long petId,
			@ApiParam(name = "corpo", value = "Representação de um novo pet com novos dados") Pet pet);

	@ApiOperation("Exclui um pet pelo ID")
	@ApiResponses({ @ApiResponse(code = 204, message = "Pet excluído"),
		@ApiResponse(code = 404, message = "Pet não encontrado") })
	public ResponseEntity<?> excluir(
			@ApiParam(value = "ID de um pet", example = "1") Long petId);

}

package com.osvaldsoza.petzapi;

import static io.restassured.RestAssured.given;

import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteApiTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private Flyway flyway;

	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.basePath = "/clientes";
		RestAssured.port = port;	
		
		flyway.migrate();
	}

	@Test
	public void testRetornarStatus200QuandoConsultarClientes() {
		given()
			.accept(ContentType.JSON)
			.auth().basic("petz", "petz")
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void testContemNomeClientes() {
		given()
			.accept(ContentType.JSON)
		 	.auth().basic("petz", "petz")
		.when()
			.get()
		.then()
			.body("nome", Matchers.hasItem("Naruto Uzumaki"));
	}
	
	@Test
	public void testRetornarStatus201QuandoCadastrarUmCliente() {
		given()
			.body("{\"nome\" : \"Mila\"}")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.auth().basic("petz","petz")
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());	
	}
	
	@Test
	public void testRetornarStatus200QuandoConsultarClienteExistente() {
		given()
			.accept(ContentType.JSON)
			.auth().basic("petz", "petz")
		.when()
			.get("/2")
		.then()
			.statusCode(HttpStatus.OK.value());	
	}
}

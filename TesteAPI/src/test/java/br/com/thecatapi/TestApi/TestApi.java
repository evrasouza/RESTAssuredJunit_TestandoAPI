package br.com.thecatapi.TestApi;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestApi extends massaDeDados {

	@BeforeClass
	public static void urlBase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}

	@Test
	public void cadastro() {

		Response response = given().contentType("application/json").body(corpoCadastro).when().post(urlCadastro);
		validacao(response);

	}

	public void votacao() {

		Response response = given().contentType("application/json").body(corpoVotacao).when().post("votes/");
		validacao(response);
		String id = response.jsonPath().getString("id");
		vote_id = id;
		System.out.println("ID => " + id);

	}

	private void deletavoto() {

		String url = "votes/{vote_id}";
		Response response = given().contentType("application/json")
				.header("x-api-key", "77535984-0100-4db3-b7f1-e857bcf35c9f")
				// .auth().basic(userName, password)
				.pathParam("vote_id", vote_id).when().delete(url);
		validacao(response);

	}

	@Test
	public void deletaVotacao() {
		votacao();
		deletavoto();
	}

	public void validacao(Response response) {
		response.then().statusCode(200).body("message", containsString("SUCCESS"));
		System.out.println("RETORNO DA API => " + response.body().asString());
		System.out.println("-----------------------------------------------");
	}

}

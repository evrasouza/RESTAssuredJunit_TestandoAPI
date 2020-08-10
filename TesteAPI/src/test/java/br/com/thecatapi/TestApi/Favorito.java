package br.com.thecatapi.TestApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Favorito extends massaDeDados {

	@BeforeClass
	public static void urlBase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}

	public void favorita() {

		Response response = given().contentType("application/json")
				.header("x-api-key", "77535984-0100-4db3-b7f1-e857bcf35c9f").body(corpoFavorita).when()
				.post("favourites");
		String id = response.jsonPath().getString("id");
		vote_id = id;

		validacao(response);
	}

	private void desfavorita() {

		Response response = given().contentType("application/json")
				.header("x-api-key", "77535984-0100-4db3-b7f1-e857bcf35c9f").pathParam("favourite_id", vote_id).when()
				.delete(corpoDesfavorita);

		validacao(response);

	}

	@Test
	public void favoritaDesfavorita() {
		favorita();
		desfavorita();
	}

	public void validacao(Response response) {
		response.then().statusCode(200).body("message", containsString("SUCCESS"));
		System.out.println("RETORNO DA API => " + response.body().asString());
		System.out.println("-----------------------------------------------");
	}

}

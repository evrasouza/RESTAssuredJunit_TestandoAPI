package br.com.thecatapi.TestApi;

public class massaDeDados {

	String vote_id;
	String urlCadastro = "user/passwordlesssignup";
	String corpoCadastro = "{\"email\": \"evrasouza@gmail.com\", \"appDescription\": \"Testes The Cat API\"}";
	String corpoVotacao = "{\"image_id\": \"5eg\", \"value\": \"true\", \"sub_id\": \"demo-56378a\"}";
	String corpoFavorita = "{\"image_id\": \"2uo\"}";
	String corpoDesfavorita = "favourites/{favourite_id}";
}

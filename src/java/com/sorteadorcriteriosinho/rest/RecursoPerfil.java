package com.sorteadorcriteriosinho.rest;

import java.io.StringWriter;
import java.net.URI;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.sorteadorcriteriosinho.model.Cadastro;
import com.sorteadorcriteriosinho.model.Usuario;

@Path("/perfil")
public class RecursoPerfil {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarUsuario(@CookieParam("emailLogado") String emailLogado) {
		Usuario u = Cadastro.obterInstancia().obterUsuario(emailLogado);
		if (u == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		StringWriter writer = new StringWriter();
		JsonGenerator gerador = Json.createGenerator(writer);

		gerador.writeStartObject();
		gerador.write("nome", u.getNome());
		gerador.write("email", u.getEmail());
		gerador.write("CPF", u.getCPF());
		gerador.write("senha", u.getSenha());

		gerador.writeEnd();

		gerador.flush();

		return Response.ok(writer.toString()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criarUsuario(@CookieParam("emailLogado") String emailLogado,
			JsonObject objeto) {
		Usuario u = Cadastro.obterInstancia().obterUsuario(emailLogado);
		if (u == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		String nome = objeto.getString("nome");
		String email = objeto.getString("email");
		String cpf = objeto.getString("cpf");

		u.setEmail(objeto.getString("email"));
		u.setNome(nome);
		u.setCPF(cpf);

		Cadastro.obterInstancia().salvarUsuario(u);

		return Response.created(URI.create("")).build();
	}

}

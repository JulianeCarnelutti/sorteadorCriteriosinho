/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sorteadorcriteriosinho.rest;

import com.sorteadorcriteriosinho.model.Cadastro;
import com.sorteadorcriteriosinho.model.Usuario;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URI;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author MatheusReinaldo
 */
@Path("/pessoas")
public class RecursoPessoa {
    
    @PathParam("email")
    private String email;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrarUsuario() {
        Usuario u = Cadastro.obterInstancia()
                .obterUsuario(email);
        if (u == null) {
            return Response.status(
                    Response.Status.NOT_FOUND)
                    .build();
        }
        /*
        JsonObject objeto = Json.createObjectBuilder()
                .add("email", u.getEmail())
                .add("senha", u.getSenha())
                .add("CPF", u.getCPF())
                .add("nome", u.getNome()).build();
        return Response.ok(objeto.toString()).build();
        */
        
        StringWriter writer = new StringWriter();
        JsonGenerator gerador = Json.createGenerator(writer);
        
        gerador.writeStartObject();
        gerador.write("email", u.getEmail());
        gerador.write("senha", u.getSenha());
        gerador.write("CPF", u.getCPF());
        gerador.write("nome", u.getNome());

        gerador.writeEnd();
        
        gerador.flush();
        
        return Response.ok(writer.toString()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarUsuario(JsonObject objeto) {
        String senha = objeto.getString("senha");
        String nome = objeto.getString("nome");
        
        Usuario u = new Usuario();
        u.setEmail(objeto.getString("email"));
        u.setSenha(senha);
        u.setNome(nome);
        
        Cadastro.obterInstancia().adicionarUsuario(u);
        
        return Response.created(URI.create("")).build();
    }
    
}

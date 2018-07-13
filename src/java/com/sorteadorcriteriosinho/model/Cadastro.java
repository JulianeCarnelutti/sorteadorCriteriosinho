/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sorteadorcriteriosinho.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author LucasReinaldo
 */

public class Cadastro {
	
	private static Cadastro instancia;
    
    public static Cadastro obterInstancia() {
        if (instancia == null)
            instancia = new Cadastro();
        return instancia;
    }
    
    // controlador, salva os usuarios
    private EntityManager em = Persistence.createEntityManagerFactory("sorteadorCriteriosinho").createEntityManager();

    // metodo pra salvar o usuario - A CLASSE RecursoUsuario USA ESSE METODO
    public void cadastrar(String email, String cpf, String nome, String senha) {
    
    	// criar usuario
    	Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        u.setCpf(cpf);
        u.setNome(nome);

        // processo de salvar usuario
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
    }
    
    // encontra um usuario pelo email- A CLASSE RecursoUsuario USA ESSE METODO
    public Usuario obterUsuario(String email) {
        return em.find(Usuario.class, email);
    }
    
}

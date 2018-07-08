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
    
    private EntityManager em = Persistence.createEntityManagerFactory("sorteadorCriteriosinho").createEntityManager();

    public void cadastrar(String nome, String email, String senha, String cpf) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        u.setCpf(cpf);

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    
    public Usuario obterUsuario(String email) {
        return em.find(Usuario.class, email);
    }
    
}

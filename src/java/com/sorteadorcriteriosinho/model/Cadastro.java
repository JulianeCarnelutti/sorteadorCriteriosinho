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
    public void adicionarUsuario(Usuario u) {
    
        // processo de salvar usuario
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
    }
    
    // encontra um usuario pelo email- A CLASSE RecursoUsuario USA ESSE METODO
    public Usuario obterUsuario(String email) {
        return em.find(Usuario.class, email);
    }
    
    // metodo pra salvar uma pessoa - A CLASSE RecursoPessoa USA ESSE METODO
    public void cadastrarPessoa(Pessoa p) {
    
        // processo de salvar uma pessoa
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
    }

    // encontra um usuario pelo email- A CLASSE RecursoUsuario USA ESSE METODO
    public Pessoa obterPessoa(String email) {
        return em.find(Pessoa.class, email);
    }

    public void salvarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }








    
    
}

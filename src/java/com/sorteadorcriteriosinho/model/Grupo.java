package com.sorteadorcriteriosinho.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Grupo {
    	
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    
    public int getId{
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setIdade(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

	

}

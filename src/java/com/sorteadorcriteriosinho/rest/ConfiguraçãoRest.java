/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sorteadorcriteriosinho.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author LucasReinaldo
 */

@ApplicationPath("usuarios")
public class ConfiguraçãoRest extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        Collections.addAll(classes, 
                RecursoUsuario.class,
                RecursoPessoa.class,
                RecursoPerfil.class);
        return classes;
    }
    
}

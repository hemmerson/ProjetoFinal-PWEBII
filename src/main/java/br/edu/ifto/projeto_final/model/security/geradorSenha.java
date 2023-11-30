package br.edu.ifto.projeto_final.model.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/11/2023
 */
public class geradorSenha {
    public static void main(String[] args) {
        //solicitando o encode para 123
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}

package br.edu.ifto.projeto_final.model.security;

import br.edu.ifto.projeto_final.model.entity.Usuario;
import br.edu.ifto.projeto_final.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 30/11/2023
 */
@Transactional
@Repository
public class UsuarioDetailsConfig implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.usuario(login);
        if(usuario == null){
            throw new UsernameNotFoundException("usuário não encontrado!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }
}

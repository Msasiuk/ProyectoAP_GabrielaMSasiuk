package com.portofio.GMsasiuk.Security.Service;

import com.portofio.GMsasiuk.Security.Entity.Usuario;
import com.portofio.GMsasiuk.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplement implements UserDetailsService {

    //Inyección de usuario service
    @Autowired
    UsuarioService usuarioService;

    //Implementación de mét. abstracto y sobreescritura del mismo
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }

}

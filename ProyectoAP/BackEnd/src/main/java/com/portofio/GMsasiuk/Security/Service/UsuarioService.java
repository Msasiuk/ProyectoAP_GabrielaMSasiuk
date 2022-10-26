package com.portofio.GMsasiuk.Security.Service;

import com.portofio.GMsasiuk.Security.Entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Security.Repository.IUsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;
    //Mét. propios de la clase que validan nombre usuario, email, buscan por nombre usuario y guardan un nuevo usuario
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }
}
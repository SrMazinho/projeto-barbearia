package br.com.iesp.barbearia.service;

import Model.UserModel;
import br.com.iesp.barbearia.repository.RoleModelRepository;
import br.com.iesp.barbearia.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UseRepository.UserRepository userRepository;
    @Autowired
    RoleModelRepository roleModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//                return new User(userModel.getUserName(),
//                userModel.getPassword(), true, true,
//                true, true,userModel.getAuthorities());

        try {
            return (UserDetails) userRepository.findByUserName(username)
                    .orElseThrow(()-> new UsernameNotFoundException("Não foi encontrado o usúario:" + username));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public UserModel criarUsuario(UserModel user){

        if (user.getUserName() != null && user.getPassword() != null && !user.getAuthorities().isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            user = (UserModel) userRepository.save(user);
        }else {
            throw new UsernameNotFoundException("Parametros null");
        }

        return user;
    }

}
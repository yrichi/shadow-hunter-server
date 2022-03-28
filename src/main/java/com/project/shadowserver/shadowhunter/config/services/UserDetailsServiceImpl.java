package com.project.shadowserver.shadowhunter.config.services;

import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurModel;
import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurProvider;
import com.project.shadowserver.shadowhunter.infrastructure.utilisateur.UtilisateurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    UtilisateurProvider utilisateurProvider;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtilisateurModel user = utilisateurProvider.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UtilisateurEntity.fromDomain(user);
	}

}

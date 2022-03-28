package com.project.shadowserver.shadowhunter.application.authentification;

import com.project.shadowserver.shadowhunter.infrastructure.role.RoleProvider;
import com.project.shadowserver.shadowhunter.application.authentification.request.LoginRequest;
import com.project.shadowserver.shadowhunter.application.authentification.request.UtilisateurPresentation;
import com.project.shadowserver.shadowhunter.application.authentification.response.JwtResponse;
import com.project.shadowserver.shadowhunter.application.authentification.response.MessageResponse;
import com.project.shadowserver.shadowhunter.config.jwt.JwtUtils;
import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurService;
import com.project.shadowserver.shadowhunter.infrastructure.utilisateur.UtilisateurEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthentificationEndpointImpl implements AuthentificationEndpoint {


    private final AuthenticationManager authenticationManager;


    private final RoleProvider roleProvider;


    private final PasswordEncoder encoder;


    private final JwtUtils jwtUtils;

    private final UtilisateurService utilisateurService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UtilisateurEntity userDetails = (UtilisateurEntity) authentication.getPrincipal();
        
        // TODO gerer les roles pour de vrai
        List<String> roles = List.of("ROLE_USER");

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getMail(),
                roles));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UtilisateurPresentation utilisateurPresentation) {
        if (utilisateurService.existsByUsername(utilisateurPresentation.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("pseudo deja utilisé"));
        }

        UtilisateurPresentation utilisateurToSave = utilisateurPresentation;
        utilisateurPresentation.setPassword(encoder.encode(utilisateurPresentation.getPassword()));
        utilisateurService.save(utilisateurToSave.toDomain());

        return ResponseEntity.ok(new MessageResponse("Utilisateur bien enregistré!"));
    }
}

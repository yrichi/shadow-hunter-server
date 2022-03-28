package com.project.shadowserver.shadowhunter.infrastructure.role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleProvider {

    private final RoleRepository roleRepository;


}

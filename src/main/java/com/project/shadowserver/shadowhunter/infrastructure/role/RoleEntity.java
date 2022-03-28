package com.project.shadowserver.shadowhunter.infrastructure.role;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.role.RoleEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;
}

package com.gaming.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "game", uniqueConstraints = {
        @UniqueConstraint(name = "UC_NAME", columnNames = {"name"}),
        @UniqueConstraint(name = "UC_NAME_EX_ID", columnNames = {"name", "externalId"})
})
@EntityListeners(AuditingEntityListener.class)
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "externalId", nullable = false)
    private String externalId;

    @Column(columnDefinition = "int default 1")
    private boolean active;

}

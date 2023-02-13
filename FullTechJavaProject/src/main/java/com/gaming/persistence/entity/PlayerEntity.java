package com.gaming.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
    private List<RegisterEntity> registerList;


}

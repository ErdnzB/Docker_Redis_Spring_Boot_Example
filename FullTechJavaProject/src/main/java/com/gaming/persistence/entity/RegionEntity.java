package com.gaming.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "region",
        uniqueConstraints = @UniqueConstraint(name = "UC_COUNTRY", columnNames = {"country"}))

@EntityListeners(AuditingEntityListener.class)
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;


}

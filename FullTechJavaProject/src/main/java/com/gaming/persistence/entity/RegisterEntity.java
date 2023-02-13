package com.gaming.persistence.entity;


import com.gaming.enums.PlayerLevels;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "register",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_PLAYER_GAME_REGION", columnNames = {"player_id", "game_id", "region_id"})
        })
@EntityListeners(AuditingEntityListener.class)
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PlayerLevels playerLevel;

}

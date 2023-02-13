package com.gaming.persistence.specification;

import com.gaming.enums.PlayerLevels;
import com.gaming.persistence.entity.RegisterEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterSpecification {

    public static Specification<RegisterEntity> filter(Long gameId, Long playerId, Long regionId, PlayerLevels levels) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(gameId)) {
                predicates.add(criteriaBuilder.equal(root.get("game"), gameId));
                //predicates.add(criteriaBuilder.equal(root.get("game_id").in("CAN TAKE ID LIST"));
            }
            if (Objects.nonNull(playerId)) {
                predicates.add(criteriaBuilder.equal(root.get("player"), playerId));
            }
            if (Objects.nonNull(regionId)) {
                predicates.add(criteriaBuilder.equal(root.get("region"), regionId));
            }
            if (Objects.nonNull(levels)) {
                predicates.add(criteriaBuilder.equal(root.get("playerLevel"), levels.getType()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}

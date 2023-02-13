package com.gaming.persistence.repository;

import com.gaming.persistence.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Long>, JpaSpecificationExecutor<RegisterEntity>,
        PagingAndSortingRepository<RegisterEntity, Long> {


    RegisterEntity findByGame_IdAndPlayer_IdAndRegion_Id(Long gameId, Long playerId, Long regionId);

    RegisterEntity findByGame_IdAndPlayer_Id(Long gameId, Long playerId);

}

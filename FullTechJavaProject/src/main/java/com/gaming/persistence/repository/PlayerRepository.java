package com.gaming.persistence.repository;

import com.gaming.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long>, JpaSpecificationExecutor<PlayerEntity>, PagingAndSortingRepository<PlayerEntity, Long> {


}

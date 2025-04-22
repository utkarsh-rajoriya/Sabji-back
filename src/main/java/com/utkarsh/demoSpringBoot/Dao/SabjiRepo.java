package com.utkarsh.demoSpringBoot.Dao;

import com.utkarsh.demoSpringBoot.Models.Sabji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SabjiRepo extends JpaRepository<Sabji , Integer> {

    @Query("SELECT s FROM Sabji s WHERE s.imageName = :imageName")
    Optional<Sabji> findByImageName(@Param("imageName") String imageName);
}

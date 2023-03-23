package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.entity.LandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandLordRepository extends JpaRepository<LandLord, Integer> {
}

package com.tc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tc.model.MrgModel;

@Repository
public interface MrgRepository extends JpaRepository<MrgModel, Long>{

}

package com.kgisl.cmtool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.cmtool.entity.CmProcess;

@Repository
public interface CmProcessRepo extends JpaRepository<CmProcess, String>{

}

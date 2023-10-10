package com.kgisl.cmtool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.cmtool.entity.CmCustCase;

@Repository
public interface CmCustCaseRepo extends JpaRepository<CmCustCase, String> {

}

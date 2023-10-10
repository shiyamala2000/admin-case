package com.kgisl.cmtool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.cmtool.entity.CmSubProcess;

@Repository
public interface CmSubProcessRepo extends JpaRepository<CmSubProcess, String> {
	
	 List<CmSubProcess> findByCmProcessProcessId(String processId);

}

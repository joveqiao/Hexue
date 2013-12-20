package com.joveqiao.Hexue.dao.common;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joveqiao.Hexue.domain.SysConfig;

@Repository
public interface SysConfigDao extends PagingAndSortingRepository<SysConfig, Long>, JpaSpecificationExecutor<SysConfig> {

}

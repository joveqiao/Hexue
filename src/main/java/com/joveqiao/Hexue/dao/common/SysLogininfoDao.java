package com.joveqiao.Hexue.dao.common;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joveqiao.Hexue.domain.SysLogininfo;

@Repository
public interface SysLogininfoDao extends PagingAndSortingRepository<SysLogininfo, Long>,
		JpaSpecificationExecutor<SysLogininfo> {

}

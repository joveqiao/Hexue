package com.joveqiao.Hexue.dao.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joveqiao.Hexue.domain.Userinfo;

@Repository
public interface UserinfoDao extends PagingAndSortingRepository<Userinfo, Long>, JpaSpecificationExecutor<Userinfo> {

	public List<Userinfo> findByLoginnameAndLoginpwd(String loginname, String loginpwd);
}

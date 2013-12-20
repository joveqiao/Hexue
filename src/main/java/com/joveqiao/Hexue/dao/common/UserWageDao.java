package com.joveqiao.Hexue.dao.common;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joveqiao.Hexue.domain.UserWage;

@Repository
public interface UserWageDao extends PagingAndSortingRepository<UserWage, Long>, JpaSpecificationExecutor<UserWage> {

}

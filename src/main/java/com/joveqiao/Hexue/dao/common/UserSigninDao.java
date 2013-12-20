package com.joveqiao.Hexue.dao.common;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joveqiao.Hexue.domain.UserSignin;

@Repository
public interface UserSigninDao extends PagingAndSortingRepository<UserSignin, Long>,
		JpaSpecificationExecutor<UserSignin> {

}

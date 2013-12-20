package com.joveqiao.Hexue.dao.common;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.joveqiao.Hexue.domain.UserSignin;

public class Test {

	public Iterable<UserSignin> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<UserSignin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserSignin> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserSignin> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserSignin findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<UserSignin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<UserSignin> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public void delete(UserSignin entity) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends UserSignin> entities) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public UserSignin findOne(Specification<UserSignin> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserSignin> findAll(Specification<UserSignin> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<UserSignin> findAll(Specification<UserSignin> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserSignin> findAll(Specification<UserSignin> spec, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count(Specification<UserSignin> spec) {
		// TODO Auto-generated method stub
		return 0;
	}

}

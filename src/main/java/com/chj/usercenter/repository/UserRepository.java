package com.chj.usercenter.repository;

import com.chj.usercenter.domain.UserE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<UserE, Long>, JpaSpecificationExecutor<UserE> {

    List<UserE> findByNameLike(String name);

    List<UserE> findTop3ByName(String name);

    List<UserE> findByName(String name, Sort sort);
    Page<UserE> findByName(String name, Pageable pageable);
}

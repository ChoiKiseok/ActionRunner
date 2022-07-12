package com.buk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buk.user.domain.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{
    public UserInfo findByUserId(String userId);
}

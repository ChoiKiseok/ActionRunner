package com.buk.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buk.admin.domain.BukToday;

@Repository
public interface BukTodayRepository extends JpaRepository<BukToday, Long> {
  
}

package com.buk.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buk.data.domain.KosisMenuDto;

public interface KosisMenuRepository extends JpaRepository<KosisMenuDto, String> {
  public List<KosisMenuDto> findByUpId(String parentId);
}

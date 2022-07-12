package com.buk.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buk.admin.domain.BukToday;
import com.buk.admin.repository.BukTodayRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BukTodayService {
    private final BukTodayRepository bukTodayRepository;

    public List<BukToday> getTodayList() {
        return bukTodayRepository.findAll();
    }
}

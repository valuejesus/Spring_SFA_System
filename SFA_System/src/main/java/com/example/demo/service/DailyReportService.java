package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Dailyreport;
import com.example.demo.mapper.DailyReportMapper;

@Service
public class DailyReportService {

	@Autowired
	private DailyReportMapper dailyreportMapper;

	@Transactional
	public List<Dailyreport> findAll() {
		return dailyreportMapper.findAll();
	}

	@Transactional
	public Dailyreport findOne(Long id) {
		return dailyreportMapper.findOne(id);
	}

	@Transactional
	public void save(Dailyreport dailyreport) {
		dailyreportMapper.save(dailyreport);
	}

	@Transactional
	public void update(Dailyreport dailyreport) {
		dailyreportMapper.update(dailyreport);
	}

	@Transactional
	public void delete(Long id) {
		dailyreportMapper.delete(id);
	}

}

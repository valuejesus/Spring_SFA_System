package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Dailyreport;

@Mapper
public interface DailyReportMapper {
	List<Dailyreport> findAll();

	Dailyreport findOne(Long id);

	void save(Dailyreport item);

	void update(Dailyreport item);

	void delete(Long id);
}

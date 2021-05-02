package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Clientlist;

@Mapper
public interface ClientMapper {
	List<Clientlist> findAll();

	Clientlist findOne(Long id);

	void save(Clientlist clientlist);

	void update(Clientlist clientlist);

	void delete(Long id);
}

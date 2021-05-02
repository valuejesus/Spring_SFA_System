package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Productlist;

@Mapper
public interface ProductMapper {
	List<Productlist> findAll();

	Productlist findOne(Long id);

	void save(Productlist productlist);

	void update(Productlist productlist);

	void delete(Long id);
}

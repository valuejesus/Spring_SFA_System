package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Productlist;
import com.example.demo.mapper.ProductMapper;

@Service
public class ProductListService {

	@Autowired
	private ProductMapper productMapper;

	@Transactional
	public List<Productlist> findAll() {
		return productMapper.findAll();
	}

	@Transactional
	public Productlist findOne(Long id) {
		return productMapper.findOne(id);
	}

	@Transactional
	public void save(Productlist productlist) {
		productMapper.save(productlist);
	}

	@Transactional
	public void update(Productlist productlist) {
		productMapper.update(productlist);
	}

	@Transactional
	public void delete(Long id) {
		productMapper.delete(id);
	}

}

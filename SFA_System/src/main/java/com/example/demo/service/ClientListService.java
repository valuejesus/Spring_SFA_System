package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Clientlist;
import com.example.demo.mapper.ClientMapper;

@Service
public class ClientListService{

	@Autowired
	private ClientMapper clientMapper;

	@Transactional
	public List<Clientlist> findAll() {
		return clientMapper.findAll();
	}

	@Transactional
	public Clientlist findOne(Long id) {
		return clientMapper.findOne(id);
	}

	@Transactional
	public void save(Clientlist clientlist) {
		clientMapper.save(clientlist);
	}

	@Transactional
	public void update(Clientlist clientlist) {
		clientMapper.update(clientlist);
	}

	@Transactional
	public void delete(Long id) {
		clientMapper.delete(id);
	}

}

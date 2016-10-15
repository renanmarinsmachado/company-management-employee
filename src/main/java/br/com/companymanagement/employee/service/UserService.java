package br.com.companymanagement.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.companymanagement.common.entity.User;
import br.com.companymanagement.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User getByUsername(String username){
		return repository.findOneByUsername(username);
	}
	
	public List<User> list(){
		return repository.findAll();
	}
	
	public void save(User user){
		repository.save(user);
	}
}

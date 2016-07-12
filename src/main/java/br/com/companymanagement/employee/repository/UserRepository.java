package br.com.companymanagement.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.companymanagement.employee.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findOneByUsername(String username);
}

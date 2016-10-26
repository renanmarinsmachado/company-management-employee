package br.com.companymanagement.employee.service;

import static br.com.companymanagement.common.patcher.Patcher.applyPatch;
import static br.com.companymanagement.employee.converter.UserConverter.getListUserDTO;
import static br.com.companymanagement.employee.converter.UserConverter.getUser;
import static br.com.companymanagement.employee.converter.UserConverter.getUserDTO;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.common.entity.User;
import br.com.companymanagement.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> list(String username){
		if(StringUtils.isNotEmpty(username)){
			return Arrays.asList(getUserDTO(repository.findOneByUsername(username)));
		}
		
		return getListUserDTO(repository.findAll());
	}
	
	public UserDTO get(String id){
		if(StringUtils.isNotEmpty(id)){
			return getUserDTO(repository.findOne(Long.parseLong(id)));
		}
		
		return new UserDTO();
	}
	
	public UserDTO save(UserDTO userDTO){
		userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		User user = repository.save(getUser(userDTO));
		return getUserDTO(user);
	}
	
	public void update(Long id, String patch) throws Exception {

		User entity = repository.findOne(id);
		UserDTO resource = getUserDTO(entity);

		// apply patch
		resource = applyPatch(patch, resource, UserDTO.class);

		if(!resource.getPassword().equals(entity.getPassword())){
			resource.setPassword(new BCryptPasswordEncoder().encode(resource.getPassword()));
		}
		
		// persist
		entity = getUser(resource);
		entity = repository.save(entity);
	}
	
	public void delete(Long id) throws Exception {
		repository.delete(id);
	}
}

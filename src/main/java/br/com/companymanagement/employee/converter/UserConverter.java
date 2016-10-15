package br.com.companymanagement.employee.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.common.entity.User;

public class UserConverter {

	public static UserDTO getUserDTO(User user){
		UserDTO userDTO = new UserDTO();
		if(user != null){
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
		}
		return userDTO;
	}
	
	public static List<UserDTO> getListUserDTO(List<User> users){
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(User user : users){
			userDTOs.add(getUserDTO(user));
		}
		return userDTOs;
	}
}

package br.com.companymanagement.employee.converter;

import static org.springframework.beans.BeanUtils.copyProperties;
import java.util.ArrayList;
import java.util.List;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.common.entity.User;

public class UserConverter {

	public static UserDTO getUserDTO(User user){
		UserDTO userDTO = new UserDTO();
		copyProperties(user, userDTO);
		
		return userDTO;
	}
	
	public static List<UserDTO> getListUserDTO(List<User> users){
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(User user : users){
			userDTOs.add(getUserDTO(user));
		}
		return userDTOs;
	}
	
	public static User getUser(UserDTO userDTO){
		User user = new User();
		copyProperties(userDTO, user);
		
		return user;
	}
}

package br.com.companymanagement.employee.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.employee.converter.UserConverter;
import br.com.companymanagement.employee.service.UserService;

@RestController
@RequestMapping("/ed/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public List<UserDTO> list(){
		return UserConverter.getListUserDTO(userService.list());
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public UserDTO getByUsername(@RequestBody UserDTO userDTO){
		return UserConverter.getUserDTO(userService.getByUsername(userDTO.getUsername()));
	}
}

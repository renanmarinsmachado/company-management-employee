
package br.com.companymanagement.employee.restcontroller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.employee.service.UserService;

@RestController
@RequestMapping("/ed/user")
public class UserRestController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@Transactional(readOnly = true)
	public ResponseEntity<List<UserDTO>> filter(@RequestParam(value = "username", required = false) String username){
		return new ResponseEntity<List<UserDTO>>(service.list(username), OK);
	}
	
	@RequestMapping(method=POST, path="", consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE)
	@Transactional(readOnly = false)
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO resource) throws Exception {

		resource = service.save(resource);

		return new ResponseEntity<UserDTO>(resource, CREATED);
	}

	@RequestMapping(method=PUT, path="/{id}", consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE)
	@Transactional(readOnly = false)
	public ResponseEntity<UserDTO> update(@PathVariable("id") String id, @RequestBody String jsonPatch) throws Exception {
		
		service.update(Long.valueOf(id), jsonPatch);

		return new ResponseEntity<UserDTO>(NO_CONTENT);
	}

	@RequestMapping(method=DELETE, path="/{id}", consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE)
	@Transactional(readOnly = false)
	public ResponseEntity<UserDTO> delete(@PathVariable("id") String id) throws Exception {

		service.delete(Long.valueOf(id));

		return new ResponseEntity<UserDTO>(NO_CONTENT);
	}
}

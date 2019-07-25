package org.marlabs.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hris")
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository departmentRepository;
	
	@ResponseBody
    @RequestMapping(value = "/employees", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeVo>> getProjects() {
		try {
			System.out.println("------In DepartmentController-----");
			List<EmployeeVo> departments=departmentRepository.listEmployees();
			return new ResponseEntity<List<EmployeeVo>>(departments,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<EmployeeVo>>(HttpStatus.NOT_FOUND);
		}
	}
	
}

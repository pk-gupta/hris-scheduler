package org.marlabs.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hris")
public class DepartmentController {
	
	@Autowired
    private DepartmentRepository departmentRepository;
	
	@ResponseBody
    @RequestMapping(value = "/departments", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentVo>> getProjects() {
		try {
			System.out.println("------In DepartmentController-----");
			List<DepartmentVo> departments=departmentRepository.listDepartments();
			return new ResponseEntity<List<DepartmentVo>>(departments,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DepartmentVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findDeptByDivision", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentVo>> findDeptByDivision(@RequestParam("division") String division) {
		try {
			System.out.println("------In DepartmentController-----findDeptByDivision ");
			List<DepartmentVo> department=departmentRepository.findDeptByDivision(division);
			return new ResponseEntity<List<DepartmentVo>>(department,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DepartmentVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findDeptByName", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentVo>> findProjectByName(@RequestParam("deptName") String deptName) {
		try {
			System.out.println("------In DepartmentController---deptName--");
			List<DepartmentVo> department=departmentRepository.findDeptByName(deptName);
			return new ResponseEntity<List<DepartmentVo>>(department,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DepartmentVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findDeptById", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentVo>> findProjectById(@RequestParam("deptId") String deptId) {
		try {
			System.out.println("------In DepartmentController---deptId--");
			List<DepartmentVo> department=departmentRepository.findDeptById(deptId);
			return new ResponseEntity<List<DepartmentVo>>(department,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DepartmentVo>>(HttpStatus.NOT_FOUND);
		}
	}
}

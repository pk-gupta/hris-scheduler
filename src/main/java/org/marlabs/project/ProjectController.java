package org.marlabs.project;

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
public class ProjectController {
	
	@Autowired
    private ProjectRepository projectRepository;
	
	@ResponseBody
    @RequestMapping(value = "/projects", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectVo>> getProjects() {
		try {
			System.out.println("------In ProjectController-----");
			List<ProjectVo> projects=projectRepository.listProjects();
			return new ResponseEntity<List<ProjectVo>>(projects,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findProjectByCode", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectVo>> findProjectByCode(@RequestParam("projectCode") String projectCode) {
		try {
			System.out.println("------In ProjectController-----projectCode ");
			List<ProjectVo> project=projectRepository.findProjectByCode(projectCode);
			return new ResponseEntity<List<ProjectVo>>(project,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findProjectByName", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectVo>> findProjectByName(@RequestParam("projectName") String projectName) {
		try {
			System.out.println("------In ProjectController---projectName--");
			List<ProjectVo> project=projectRepository.findProjectByName(projectName);
			return new ResponseEntity<List<ProjectVo>>(project,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
	@ResponseBody
    @RequestMapping(value = "/findProjectById", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectVo>> findProjectById(@RequestParam("projectId") String projectId) {
		try {
			System.out.println("------In ProjectController---projectName--");
			List<ProjectVo> project=projectRepository.findProjectById(projectId);
			return new ResponseEntity<List<ProjectVo>>(project,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
}

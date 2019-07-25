package org.marlabs.iis.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iis")
public class ProjectIISController {
	
	@Autowired
    private ProjectIISRepository projectIISRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ResponseBody
    @RequestMapping(value = "/projects", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectIISVo>> getProjects() {
		try {
			List<ProjectIISVo> projects=projectIISRepository.listProjects();
			return new ResponseEntity<List<ProjectIISVo>>(projects,HttpStatus.OK);
		} catch (Exception e) {
			log.debug("-----In projectIIS Repository --------"+e.getMessage());
			return new ResponseEntity<List<ProjectIISVo>>(HttpStatus.NOT_FOUND);
		}
	}
}

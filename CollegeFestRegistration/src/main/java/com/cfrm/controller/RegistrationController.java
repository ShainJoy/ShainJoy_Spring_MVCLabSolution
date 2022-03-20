package com.cfrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfrm.entity.Student;
import com.cfrm.service.RegistrationServices;

/**
 * Controller class handles all Post & Request mappings
 * 
 * @author Shain Joy
 */

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationServices regService;
	
	@RequestMapping("/addParticipant")
	public String addParticipant(Model theStudent) {
		Student participant = new Student();
		theStudent.addAttribute("Student", participant);
		return "Student-Form";
	}
	
	@RequestMapping("/list")
	public String listParticipants(Model theStudent) {
		List<Student> participants = regService.findAll();
		theStudent.addAttribute("Students",participants);
		return "List-Participants";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("name") String name,
			@RequestParam("department") String department,
			@RequestParam("country") String country,
			Model theStudent) {
		
		if (name.trim().isEmpty() && department.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/registration/list";
		}
		else {
			List<Student> participants =
					regService.searchBy(name, department, country);
			theStudent.addAttribute("Students", participants);
		return "List-Participants";
		}
	}
	
	@RequestMapping("/Update")
	public String updateOption(@RequestParam("studentId") int id, Model theStudent) {
		Student participant = regService.searchById(id);
		theStudent.addAttribute("Student", participant);
		return "Student-Form";
	}

	/* Save handler gets both Save and Update tasks.
	 * If the ID is 0, create new participant with given parameters 
	 * If ID not 0, get the participant from db, update the same with given parameter.
	 * Finally give the updated/new object to repository for persisting.
	 */
	@PostMapping("/save")
	public String saveParticipant(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {
		
		System.out.println(id);
		Student participant;
		if (id!=0) {
			participant = regService.searchById(id);
			participant.setName(name);
			participant.setDepartment(department);
			participant.setCountry(country);
		}
		else {
			participant = new Student(name, department, country);
		}
		regService.save(participant);
		return "redirect:/registration/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		regService.deleteById(id);
		return "redirect:/registration/list";
	}
	
}
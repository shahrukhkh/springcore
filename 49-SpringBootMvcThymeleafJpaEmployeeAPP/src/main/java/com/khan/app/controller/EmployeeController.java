package com.khan.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.exception.EmployeeEntityNotFoundException;
import com.khan.app.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private IEmployeeService employeeService;

	public EmployeeController(IEmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@GetMapping("/register")
	public String getRegisterEmpForm() {
		return "/RegisterEmployee";
	}

	@PostMapping("/save")
	public String registerEmpForm(@ModelAttribute EmployeeEntity employeeEntity, Model model) {
		Integer id = employeeService.saveEmployeeEntity(employeeEntity);

		String msg = "Employee '" + id + "' saved...";
		model.addAttribute("msg", msg);
		return "/RegisterEmployee";
	}

//	@GetMapping("/all")
//	public String getAllEmployee(Model model,@RequestParam(value="msg",required = false) String msg)
//	{
//		
//		List<EmployeeEntity> list = employeeService.getAllEmployeeEntitys();
//		model.addAttribute("list", list);
//		model.addAttribute("msg", msg);
//		return "EmployeeData";
//	}
	// .../all?page=3&size=10
	@GetMapping("/all")
	public String showData(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable,
			@RequestParam(value = "msg", required = false) String msg) {
		// List<Employee> list = service.getAllEmployees();
		Page<EmployeeEntity> page = employeeService.getAllEmployeeEntitys(pageable);
		model.addAttribute("list", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("msg", msg);
		return "EmployeeData";
	}

	@GetMapping("/remove")
	public String removeEmployee(@RequestParam("id") Integer id, RedirectAttributes model) {
		String msg = null;

		try {
			employeeService.deleteEmployeeEntity(id);
			msg = "Emplyee '" + id + "'is deleted...";

		} catch (EmployeeEntityNotFoundException e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String showEdit(@RequestParam("id") Integer empId, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			EmployeeEntity employee = employeeService.getOneEmployeeEntity(empId);
			model.addAttribute("emp", employee);
			page = "EmployeeEdit";
		} catch (EmployeeEntityNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("msg", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateData(@ModelAttribute EmployeeEntity employee, RedirectAttributes attributes) {
		employeeService.updateEmployeeEntity(employee);
		attributes.addAttribute("msg", "Employee '" + employee.getEmpId() + "' Updated!");
		return "redirect:all";
	}

}

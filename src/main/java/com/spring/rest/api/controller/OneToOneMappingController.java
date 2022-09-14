/*
 * package com.spring.rest.api.controller;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.spring.rest.api.model.Employee;
 * 
 * @RestController public class OneToOneMappingController {
 * 
 * @GetMapping("/employees") public ResponseEntity<List<Employee>>
 * gelAllEmployees(@RequestParam final int pageNo,
 * 
 * @RequestParam final int pageSize) { List<Employee> employee =
 * employeeService.getEmployees(pageNo, pageSize); return new
 * ResponseEntity<>(employee, HttpStatus.OK); }
 * 
 * @GetMapping("/employees/{id}") public Optional<Employee>
 * getEmployee(@PathVariable("id") final Long id) { return
 * employeeService.getEmployee(id); }
 * 
 * @DeleteMapping("/employees") public void deleteEmployee(@RequestParam("id")
 * final Long id) { employeeService.deleteEmployee(id); }
 * 
 * @PostMapping("/employees") public Employee saveEmployee(@Valid @RequestBody
 * Employee employee) { System.out.println("Save method called..!!"); return
 * employeeService.saveEmployee(employee); }
 * 
 * @PutMapping("/employees/{id}") public Employee updateEmployee(@PathVariable
 * final Long id, @RequestBody Employee employee) { employee.setId(id); return
 * employeeService.updateEmployee(employee); } }
 */
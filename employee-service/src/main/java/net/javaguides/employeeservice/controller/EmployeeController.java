package net.javaguides.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.EmployeeServiceApplication;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    //build save employee REst API

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.saveEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build get employee REST API
    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("employee-id") int employeeId){
       APIResponseDto apiResponseDto=  employeeService.getEmployeeById(employeeId);
       return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}

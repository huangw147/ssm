package com.hw.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.hw.ssm.pojo.Employee;
import com.hw.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*@author DaWeiGe
 *开发时间：2022/8/18 20:20
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/page/{pageNumber}")
    public String getEmployeePage(Model model, @PathVariable("pageNumber") Integer pageNumber) {
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNumber);
        model.addAttribute("page", page);
        return "employee_list";
    }

    @GetMapping("/employee")
    private String getAllEmployee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list", list);
        return "employee_list";
    }

}

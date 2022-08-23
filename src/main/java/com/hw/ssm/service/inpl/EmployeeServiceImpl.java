package com.hw.ssm.service.inpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hw.ssm.mapper.EmployeeMapper;
import com.hw.ssm.pojo.Employee;
import com.hw.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@author DaWeiGe
 *开发时间：2022/8/18 20:51
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNumber) {
        PageHelper.startPage(pageNumber, 4);
        List<Employee> list = employeeMapper.getAllEmployee();
        return new PageInfo<Employee>(list, 5);
    }
}

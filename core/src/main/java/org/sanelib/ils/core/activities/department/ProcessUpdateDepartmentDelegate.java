package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateDepartmentDelegate implements JavaDelegate {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Department called");

        UpdateDepartment command = (UpdateDepartment) execution.getVariable("command");
        Department entity = departmentRepository.get(new DepartmentId(command.getLibraryId(), command.getId()));
        entity.setDeptName(command.getDeptName());
        entity.setHodId(command.getHodId());
        departmentRepository.save(entity);

        execution.setVariable("result", entity.getDepartmentId().getId());
    }
}

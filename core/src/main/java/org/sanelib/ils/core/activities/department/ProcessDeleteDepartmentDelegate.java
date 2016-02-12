package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.DeleteDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteDepartmentDelegate implements JavaDelegate {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Delete Department called");

        DeleteDepartment command = (DeleteDepartment) execution.getVariable("command");
        Department department = this.departmentRepository.load(new DepartmentId(command.getLibraryId(), command.getId()));
        departmentRepository.remove(department);
        execution.setVariable("result", "Record Deleted successfully " + department.getDepartmentId().getId());

    }
}

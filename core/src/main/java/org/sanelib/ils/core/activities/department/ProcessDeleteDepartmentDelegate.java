package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.DeleteDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteDepartmentDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeleteDepartmentDelegate.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Delete Department called");

        DeleteDepartment command = (DeleteDepartment) execution.getVariable("command");

        Department department = this.departmentRepository.load(new DepartmentId(command.getLibraryId(), command.getId()));

        departmentRepository.remove(department);
    }
}

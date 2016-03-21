package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddDepartmentDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddDepartmentDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Add Department called");

        AddDepartment command = (AddDepartment) execution.getVariable("command");

        Department entity = new Department();

        Integer nextId = hibernateHelper.getNextId(Department.class, "departmentId.id");
        entity.setDepartmentId(nextId, command.getLibraryId());
        entity.setName(command.getName());
        entity.setHodId(command.getHodId());
        entity.setUserCode(command.getUserCode());

        departmentRepository.save(entity);

        execution.setVariable("result", entity.getDepartmentId().getId());
    }
}

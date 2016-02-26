package org.sanelib.ils.core.activities.materialType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.DeleteMaterialType;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
@Component
public class CheckMaterialTypeIdReferenceDelegate implements JavaDelegate{

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        List list = new ArrayList<>();
        boolean idReferred = false;
        Integer id = ((DeleteMaterialType)command).getId();

        Criteria criteriaForIdExist = unitOfWork.getCurrentSession().createCriteria(MaterialType.class);
        criteriaForIdExist.add(Restrictions.eq("id" ,id));

        if(criteriaForIdExist.list().isEmpty()){
            processError.addError("common.field.notExist", "id", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.common.id"), String.valueOf(id));
        }

        Criteria criteriaForCirculation = unitOfWork.getCurrentSession().createCriteria(CirculationMatrix.class);
        criteriaForCirculation.add(Restrictions.eq("circulationMatrixId.materialTypeId", id));

        if(!criteriaForCirculation.list().isEmpty()){
            idReferred = true;
        }

        if(idReferred == true){
            processError.addError("common.field.duplicate" , "id" , "domain.common.id");
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}

package org.sanelib.ils.api.services;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.impl.pvm.PvmException;
import org.activiti.engine.runtime.ProcessInstance;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.Dto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.dao.read.ViewServiceBase;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.*;
import java.util.stream.Collectors;

public abstract class ApiServiceBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    UnitOfWork unitOfWork;

    @Autowired
    ApplicationContext ctx;

    @SuppressWarnings("unchecked")
    protected String execute(Dto dto, String processKey) throws Throwable {

        String response = null;

        String converterName = processKey + "Converter";

        DtoToCommandConverter converter = (DtoToCommandConverter) ctx.getBean(converterName);

        ProcessError processError = new ProcessError();

        ProcessCommand command = converter.convert(dto, processError);

        if(!processError.isValid()){
            throw new AppException(processError);
        }

        String processName = processKey + "Process";
        Map<String, Object> variables = new HashMap<>();
        variables.put("command", command);
        variables.put("errors", processError);

        try {
            unitOfWork.begin();
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(processName, variables);
            Map<String, VariableInstanceEntity> variableInstances = ((ExecutionEntity) instance).getVariableInstances();
            if(variableInstances.containsKey("result")){
                response = variableInstances.get("result").getValue().toString();
            }
            unitOfWork.commit();
        } catch (Exception exception){
            unitOfWork.rollback();
            if(exception instanceof PvmException){
                throw exception.getCause();
            }
            throw exception;
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    protected List fetchAll(String viewName) throws Throwable {

        String converterName = viewName + "Converter";
        String serviceName = viewName + "Repository";

        ViewToDtoConverter converter = (ViewToDtoConverter) ctx.getBean(converterName);
        ViewServiceBase service = (ViewServiceBase) ctx.getBean(serviceName);

        List dtoList = new ArrayList<>();
        List viewList = service.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> converter.convert((DomainView) v)).collect(Collectors.toList()));
        return dtoList;
    }
}

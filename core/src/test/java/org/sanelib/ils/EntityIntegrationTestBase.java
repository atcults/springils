package org.sanelib.ils;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.sanelib.ils.common.properties.AppProperties;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.CustomClock;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.domain.entity.EntityBase;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreTestMain.class)
public abstract class EntityIntegrationTestBase {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private Clock clock;

    @Autowired
    private UnitOfWork unitOfWork;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Before
    public void start() throws Exception {
        Locale.setDefault(new Locale(this.appProperties.getLocale()));
        this.unitOfWork.begin();
    }

    @After
    public void tearDown() throws Exception {
        this.unitOfWork.rollback();
    }

    protected String execute(ProcessCommand command, String processKey) throws Throwable {

        ProcessError processError = new ProcessError();

        String processName = processKey + "Process";
        Map<String, Object> variables = new HashMap<>();
        variables.put("command", command);
        variables.put("errors", processError);

        String response = null;

        System.out.println("Command:" + command);
        System.out.println("Process Name:" + processName);

        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processName, variables);

        System.out.println("instance:" + instance);

        Map<String, VariableInstanceEntity> variableInstances = ((ExecutionEntity) instance).getVariableInstances();
        if(variableInstances.containsKey("result")){
            response = variableInstances.get("result").getValue().toString();
        }
        unitOfWork.flush();

        return response;
    }

    protected void stubCurrentDate(int year, int month, int day) {
        ((CustomClock) clock).set(DateHelper.constructDate(year, month, day));
    }

    protected void stubCurrentDate(Date date) {
        ((CustomClock) clock).set(date);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public <T> T fetch(Class klass, Serializable id) {
        return (T) this.unitOfWork.getCurrentSession().get(klass, id);
    }

    public void persist(EntityBase entity) {
        this.unitOfWork.getCurrentSession().save(entity);
        this.unitOfWork.flush();
        this.unitOfWork.clear();
    }
}


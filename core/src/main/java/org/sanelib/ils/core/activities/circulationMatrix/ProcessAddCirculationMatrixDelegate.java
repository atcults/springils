package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessAddCirculationMatrixDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddCirculationMatrixDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process Add Circulation Matrix called");

        AddCirculationMatrix command = (AddCirculationMatrix) execution.getVariable("command");

        CirculationMatrix entity = new CirculationMatrix();

        entity.setOverAllLoanLimit(command.getOverAllLoanLimit());
        entity.setRenewalLimit(command.getRenewalLimit());
        entity.setFinePerDay(command.getFinePerDay());
        entity.setMaxCeilOnFine(command.getMaxCeilOnFine());
        entity.setRenewalThroughOPAC(Boolean.parseBoolean(command.getRenewalThroughOPAC()));
        entity.setOtherDetails(command.getOtherDetails());
        entity.setAuditUserCode(command.getAuditUserCode());
        entity.setLoanDurationType(command.getLoanDurationType());
        entity.setLoanDuration(command.getLoanDuration());
        entity.setIncludeHolidaysInDateDue(command.getIncludeHolidaysInDateDue());
        entity.setChargeDurationType(command.getChargeDurationType());
        entity.setIncludeHolidaysInCharges(command.getIncludeHolidaysInCharges());
        entity.addChargeDetail(command.getFrom(), command.getTo() , command.getAmount());
        entity.addFixedDateDue(command.getDay(), command.getMonth());

        circulationMatrixRepository.save(entity);


    }
}

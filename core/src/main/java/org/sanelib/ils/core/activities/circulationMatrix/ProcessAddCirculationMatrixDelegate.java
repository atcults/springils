package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.enums.DurationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
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

        entity.setAuditUserCode(command.getAuditUserCode());
        entity.setRenewalThroughOPAC(command.getRenewalThroughOPAC());
        entity.setOverAllLoanLimit(command.getOverAllLoanLimit());
        entity.setRenewalLimit(command.getRenewalLimit());
        entity.setFinePerDay(command.getFinePerDay());
        entity.setMaxCeilOnFine(command.getMaxCeilOnFine());
        entity.setOtherDetails(command.getOtherDetails());
        entity.setLoanDurationType(command.getLoanDurationType());
        entity.setIncludeHolidaysInDateDue(command.isIncludeHolidaysInDateDue());
        entity.setChargeDurationType(command.getChargeDurationType());
        entity.setIncludeHolidaysInCharges(command.isIncludeHolidaysInCharges());

        if(Objects.equals(command.getLoanDurationType(), DurationType.Days)) {
            entity.setAuditUserCode(command.getAuditUserCode());
            entity.setLoanDuration(command.getLoanDuration());
        }

        if(Objects.equals(command.getLoanDurationType(), DurationType.Fixed)) {
            entity.addFixedDateDue(command.getDay(), command.getMonth());

        }

        if(Objects.equals(command.getChargeDurationType(), DurationType.Hours)) {
            entity.addChargeDetail(command.getFrom(), command.getTo() , command.getAmount());
        }

        circulationMatrixRepository.save(entity);
    }
}

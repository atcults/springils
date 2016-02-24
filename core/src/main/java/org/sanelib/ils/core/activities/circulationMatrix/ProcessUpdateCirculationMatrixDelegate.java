package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.commands.circulationMatrix.UpdateCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.domain.entity.CirculationMatrixId;
import org.sanelib.ils.core.enums.DurationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProcessUpdateCirculationMatrixDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckCirculationMatrixExistDelegate.class);

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Checking circulation matrix with existing data");

        UpdateCirculationMatrix command = (UpdateCirculationMatrix) execution.getVariable("command");

        CirculationMatrix entity = circulationMatrixRepository.get(new CirculationMatrixId(command.getLibraryId(), command.getPatronCategoryId(), command.getMaterialTypeId(), command.getWithEffectFrom()));

        entity.setRenewalThroughOPAC(command.getRenewalThroughOPAC());

        entity.setLoanDurationType(command.getLoanDurationType());

        if(Objects.equals(command.getLoanDurationType(), DurationType.Fixed)) {
            for(AddCirculationMatrix.FixedDate fixDate : command.getFixedDateDues()){
                entity.addFixedDateDue(fixDate.getDay(), fixDate.getMonth());
            }
        }

        entity.setIncludeHolidaysInDateDue(command.isIncludeHolidaysInDateDue());
        entity.setOverAllLoanLimit(command.getOverAllLoanLimit());
        entity.setRenewalLimit(command.getRenewalLimit());
        entity.setFinePerDay(command.getFinePerDay());
        entity.setMaxFine(command.getMaxFine());

        entity.setChargeDurationType(command.getChargeDurationType());

        if(Objects.equals(command.getChargeDurationType(), DurationType.Hours)) {
            for(AddCirculationMatrix.ChargeDetail chargeDetail : command.getChargeDetails()) {
                entity.addChargeDetail(chargeDetail.getFrom(), chargeDetail.getTo(), chargeDetail.getAmount());
            }
        }

        entity.setIncludeHolidaysInCharges(command.isIncludeHolidaysInCharges());

        circulationMatrixRepository.save(entity);
    }
}

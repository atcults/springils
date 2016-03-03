package org.sanelib.ils.core.activities.serialBoundVolume;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.SerialBoundVolumeRepository;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddSerialBoundVolumeDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddSerialBoundVolumeDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    SerialBoundVolumeRepository serialBoundVolumeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Add SerialBoundVolume called");

        AddSerialBoundVolume command = (AddSerialBoundVolume) execution.getVariable("command");

        SerialBoundVolume entity = new SerialBoundVolume();

        Integer nextId = hibernateHelper.getNextId(SerialBoundVolume.class, "serialBoundVolumeId.id");
        entity.setSerialBoundVolumeId(nextId, command.getLibraryId());
        entity.setName(command.getName());
        entity.setColor(command.getColor());
        entity.setPrice(command.getPrice());
        entity.setUserCode(command.getUserCode());

        serialBoundVolumeRepository.save(entity);

        execution.setVariable("result", entity.getSerialBoundVolumeId().getId());
	}
}
package org.sanelib.ils.core.activities.serialBoundVolume;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.serialBoundVolume.UpdateSerialBoundVolume;
import org.sanelib.ils.core.dao.SerialBoundVolumeRepository;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.domain.entity.SerialBoundVolumeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateSerialBoundVolumeDelegate implements JavaDelegate {

    @Autowired
    SerialBoundVolumeRepository serialBoundVolumeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update SerialBoundVolume called");

        UpdateSerialBoundVolume command = (UpdateSerialBoundVolume) execution.getVariable("command");

        SerialBoundVolume entity = serialBoundVolumeRepository.get(new SerialBoundVolumeId(command.getLibraryId(), command.getId()));

        entity.setName(command.getName());
        entity.setColor(command.getColor());
        entity.setPrice(command.getPrice());
        entity.setEntryId(command.getEntryId());

        serialBoundVolumeRepository.save(entity);
	}
}

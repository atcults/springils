package org.sanelib.ils.core.activities.serialBoundVolume;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.serialBoundVolume.DeleteSerialBoundVolume;
import org.sanelib.ils.core.dao.SerialBoundVolumeRepository;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.domain.entity.SerialBoundVolumeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteSerialBoundVolumeDelegate implements JavaDelegate {

    @Autowired
    SerialBoundVolumeRepository serialBoundVolumeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Delete SerialBoundVolume called");

        DeleteSerialBoundVolume command = (DeleteSerialBoundVolume) execution.getVariable("command");
        SerialBoundVolume serialBoundVolume = this.serialBoundVolumeRepository.load(new SerialBoundVolumeId(command.getLibraryId(), command.getId()));

        serialBoundVolumeRepository.remove(serialBoundVolume);
	}
}

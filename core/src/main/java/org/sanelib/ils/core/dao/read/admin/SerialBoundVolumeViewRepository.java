package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.SerialBoundVolumeMapper;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class SerialBoundVolumeViewRepository implements ViewService {

    @Autowired
    SerialBoundVolumeMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatements() {
        return "select * from sm_co_bind_specification";
    }

    public List<SerialBoundVolumeView> getAll() throws Throwable {

        return viewServiceHelper.loadQuery(getStatements(), mapper);
    }
}

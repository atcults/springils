package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class SerialBoundVolumeMapper implements ViewMapper<SerialBoundVolumeView>{
    @Override
    public SerialBoundVolumeView map(DataResultSet rs) throws SQLException {

        final String viewName = "sm_co_bind_specification";

        final SerialBoundVolumeView serialBoundVolumeView=new SerialBoundVolumeView();

        serialBoundVolumeView.setLibraryId(rs.getInt(viewName,"library_id"));
        serialBoundVolumeView.setBindTypeId(rs.getInt(viewName,"bind_type_id"));
        serialBoundVolumeView.setName(rs.getString(viewName,"name"));
        serialBoundVolumeView.setColor(rs.getString(viewName,"color"));
        serialBoundVolumeView.setPrice(rs.getDouble(viewName,"price"));

        return serialBoundVolumeView;
    }
}

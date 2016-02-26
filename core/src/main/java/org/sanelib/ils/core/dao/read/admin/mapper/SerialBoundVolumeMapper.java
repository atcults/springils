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

        final String sm_co_bind_specification = "sm_co_bind_specification";

        final SerialBoundVolumeView serialBoundVolumeView=new SerialBoundVolumeView();

        serialBoundVolumeView.setLibraryId(rs.getInt(sm_co_bind_specification,"library_id"));
        serialBoundVolumeView.setBindTypeId(rs.getInt(sm_co_bind_specification,"bind_type_id"));
        serialBoundVolumeView.setName(rs.getString(sm_co_bind_specification,"name"));
        serialBoundVolumeView.setColor(rs.getString(sm_co_bind_specification,"color"));
        serialBoundVolumeView.setPrice(rs.getDouble(sm_co_bind_specification,"price"));

        return serialBoundVolumeView;
    }
}

package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.MaterialTypeView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class MaterialTypeMapper implements ViewMapper<MaterialTypeView> {

    @Override
    public MaterialTypeView map(DataResultSet rs) throws SQLException {

        final String viewName = "adm_co_material_type";

        final MaterialTypeView materialTypeView = new MaterialTypeView();

        materialTypeView.setId(rs.getInt(viewName , "material_type_id"));
        materialTypeView.setMaterialTypeName(rs.getString(viewName, "material_type"));

        return materialTypeView;
    }
}

package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.MaterialTypeMapper;
import org.sanelib.ils.core.domain.view.admin.MaterialTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class MaterialTypeViewRepository implements ViewService{

    @Autowired
    MaterialTypeMapper materialTypeMapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    public String getStatement() {
        return "select * from adm_co_material_type";
    }

    public List<MaterialTypeView> getAllMaterialTypes(){
        return viewServiceHelper.loadQuery(getStatement() , materialTypeMapper);
    }
}

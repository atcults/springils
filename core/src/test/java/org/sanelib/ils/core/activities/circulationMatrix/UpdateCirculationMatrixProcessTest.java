package org.sanelib.ils.core.activities.circulationMatrix;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.circulationMatrix.UpdateCirculationMatrix;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.domain.entity.CirculationMatrixId;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.sanelib.ils.core.domain.entity.PatronCategoryId;
import org.sanelib.ils.core.enums.DurationType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class UpdateCirculationMatrixProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateCirculationMatrixProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        PatronCategory patronCategory = new PatronCategory();
        patronCategory.setPatronCategoryId(hibernateHelper.getNextId(PatronCategoryId.class), library.getId());
        patronCategory.setName("patron");

        persist(patronCategory);

        MaterialType materialType = new MaterialType();
        materialType.setId(hibernateHelper.getNextId(MaterialType.class));
        materialType.setMaterialType("material");

        persist(materialType);

        CirculationMatrix circulationMatrix = new CirculationMatrix();

        Date withEffectFrom = DateHelper.constructDate(2016, 2, 2);

        circulationMatrix.setCirculationMatrixId(1, 1, 1, withEffectFrom);
        circulationMatrix.setRenewalThroughOPAC(true);
        circulationMatrix.setLoanDurationType(DurationType.Days);
        circulationMatrix.setLoanDuration(2);
        circulationMatrix.setLoanDurationType(DurationType.Fixed);
        circulationMatrix.addFixedDateDue(2, 2);
        circulationMatrix.setIncludeHolidaysInDateDue(true);
        circulationMatrix.setOverAllLoanLimit(2);
        circulationMatrix.setRenewalLimit(2);
        circulationMatrix.setFinePerDay(2.2);
        circulationMatrix.setMaxFine(2.2);
        circulationMatrix.setChargeDurationType(DurationType.Hours);
        circulationMatrix.addChargeDetail(2, 2, 2.2);
        circulationMatrix.setIncludeHolidaysInCharges(true);

        persist(circulationMatrix);

        UpdateCirculationMatrix updateCirculationMatrix = new UpdateCirculationMatrix();

        updateCirculationMatrix.setPatronCategoryId(1);
        updateCirculationMatrix.setMaterialTypeId(1);
        updateCirculationMatrix.setWithEffectFrom(DateHelper.constructDate(2016, 5, 4));
        updateCirculationMatrix.setRenewalThroughOPAC(true);
        updateCirculationMatrix.setLoanDurationType(DurationType.Days);
        updateCirculationMatrix.setLoanDuration(2);
        updateCirculationMatrix.setLoanDurationType(DurationType.Fixed);
        updateCirculationMatrix.addFixedDateDue(2, 2);
        updateCirculationMatrix.setIncludeHolidaysInDateDue(true);
        updateCirculationMatrix.setOverAllLoanLimit(2);
        updateCirculationMatrix.setRenewalLimit(2);
        updateCirculationMatrix.setFinePerDay(2.2);
        updateCirculationMatrix.setMaxFine(2.2);
        updateCirculationMatrix.setChargeDurationType(DurationType.Hours);
        updateCirculationMatrix.addChargeDetail(2, 2, 2.2);
        updateCirculationMatrix.setIncludeHolidaysInCharges(true);

        String result = execute(updateCirculationMatrix, ActivitiProcessConstants.Admin.UPDATE_CIRCULATION_MATRIX);

        assertNull(result);

        CirculationMatrix dbCirculationMatrix = fetch(CirculationMatrix.class, new CirculationMatrixId(library.getId(), patronCategory.getPatronCategoryId().getId(), materialType.getId(), circulationMatrix.getCirculationMatrixId().getWithEffectFrom()));

        assertNotNull(dbCirculationMatrix);

        assertEquals(updateCirculationMatrix.getPatronCategoryId(), circulationMatrix.getCirculationMatrixId().getPatronCategoryId());
        assertEquals(updateCirculationMatrix.getMaterialTypeId(), circulationMatrix.getCirculationMatrixId().getMaterialTypeId());
        assertEquals(updateCirculationMatrix.getWithEffectFrom(), circulationMatrix.getCirculationMatrixId().getWithEffectFrom());
        assertEquals(updateCirculationMatrix.getRenewalThroughOPAC(), circulationMatrix.getRenewalThroughOPAC());
        assertEquals(updateCirculationMatrix.getLoanDurationType(), circulationMatrix.getLoanDurationType());
        assertEquals(updateCirculationMatrix.getLoanDuration(), circulationMatrix.getLoanDuration());
        assertEquals(updateCirculationMatrix.getFixedDateDues(), circulationMatrix.getFixedDateDues());
        assertEquals(updateCirculationMatrix.isIncludeHolidaysInDateDue(), circulationMatrix.isIncludeHolidaysInDateDue());
        assertEquals(updateCirculationMatrix.getOverAllLoanLimit(), circulationMatrix.getOverAllLoanLimit());
        assertEquals(updateCirculationMatrix.getRenewalLimit(), circulationMatrix.getRenewalLimit());
        assertEquals(updateCirculationMatrix.getFinePerDay(), circulationMatrix.getFinePerDay());
        assertEquals(updateCirculationMatrix.getMaxFine(), circulationMatrix.getMaxFine());
        assertEquals(updateCirculationMatrix.getChargeDurationType(), circulationMatrix.getChargeDurationType());
        assertEquals(updateCirculationMatrix.getChargeDetails(), circulationMatrix.getChargeDetails());
        assertEquals(updateCirculationMatrix.isIncludeHolidaysInCharges(), circulationMatrix.isIncludeHolidaysInCharges());
    }
}

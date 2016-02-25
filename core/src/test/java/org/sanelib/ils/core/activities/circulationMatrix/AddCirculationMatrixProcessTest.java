package org.sanelib.ils.core.activities.circulationMatrix;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.domain.entity.CirculationMatrixId;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.sanelib.ils.core.domain.entity.PatronCategoryId;
import org.sanelib.ils.core.enums.DurationType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("ALL")
public class AddCirculationMatrixProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Test
    public void testAddCirculationMatrixProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        PatronCategory patronCategory = new PatronCategory();
        patronCategory.setPatronCategoryId(hibernateHelper.getNextId(PatronCategoryId.class), library.getId());
        patronCategory.setName("patron");

        persist(patronCategory);

        MaterialType materialType = new MaterialType();
        materialType.setId(hibernateHelper.getNextId(MaterialType.class));
        materialType.setMaterialType("material");

        persist(materialType);

        AddCirculationMatrix addCirculationMatrix = new AddCirculationMatrix();

        addCirculationMatrix.setLibraryId(library.getId());
        addCirculationMatrix.setPatronCategoryId(patronCategory.getPatronCategoryId().getId());
        addCirculationMatrix.setMaterialTypeId(materialType.getId());
        addCirculationMatrix.setWithEffectFrom(DateHelper.fromDateString("2016-02-02"));

        addCirculationMatrix.setRenewalThroughOPAC(true);

        DurationType durationType = DurationType.getByName("Day");
        addCirculationMatrix.setLoanDurationType(durationType);

        DurationType durationType1 = DurationType.getByName("NextOccurring");
        addCirculationMatrix.setChargeDurationType(durationType1);
        addCirculationMatrix.addFixedDateDue(2, 2);

        addCirculationMatrix.setIncludeHolidaysInDateDue(true);
        addCirculationMatrix.setOverAllLoanLimit(2);
        addCirculationMatrix.setRenewalLimit(2);
        addCirculationMatrix.setMaxFine(2.2);

        DurationType durationType2 = DurationType.getByName("Hour");
        addCirculationMatrix.setChargeDurationType(durationType2);
        addCirculationMatrix.addChargeDetail(2, 2, 2.2);

        addCirculationMatrix.setIncludeHolidaysInCharges(true);

        String result = execute(addCirculationMatrix, ActivitiProcessConstants.Admin.ADD_CIRCULATION_MATRIX);

        assertNotNull(result);

        CirculationMatrix circulationMatrix = fetch(CirculationMatrix.class, new CirculationMatrixId(library.getId(), patronCategory.getPatronCategoryId().getId(), materialType.getId(), addCirculationMatrix.getWithEffectFrom()));

        assertNotNull(circulationMatrix);

        assertEquals(addCirculationMatrix.getRenewalThroughOPAC(), circulationMatrix.getRenewalThroughOPAC());
        assertEquals(addCirculationMatrix.getLoanDurationType(), circulationMatrix.getLoanDurationType());
        assertEquals(addCirculationMatrix.getLoanDuration(), circulationMatrix.getLoanDuration());
        assertEquals(addCirculationMatrix.getFixedDateDues(), circulationMatrix.getFixedDateDues());
        assertEquals(addCirculationMatrix.isIncludeHolidaysInCharges(), circulationMatrix.isIncludeHolidaysInDateDue());
        assertEquals(addCirculationMatrix.getOverAllLoanLimit(), circulationMatrix.getOverAllLoanLimit());
        assertEquals(addCirculationMatrix.getRenewalLimit(), circulationMatrix.getRenewalLimit());
        assertEquals(addCirculationMatrix.getMaxFine(), circulationMatrix.getMaxFine());
        assertEquals(addCirculationMatrix.getFinePerDay(), circulationMatrix.getFinePerDay());
        assertEquals(addCirculationMatrix.getChargeDurationType(), circulationMatrix.getChargeDurationType());
        assertEquals(addCirculationMatrix.getChargeDetails(), circulationMatrix.getChargeDetails());
        assertEquals(addCirculationMatrix.isIncludeHolidaysInCharges(), circulationMatrix.isIncludeHolidaysInCharges());
    }
}

package org.sanelib.ils.api.converters.holiday;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.HolidayView;
import org.sanelib.ils.core.enums.HolidayType;
import java.util.List;

public class HolidayViewConverterTest {

    HolidayViewConverter holidayViewConverter = null;

    @Test
    public void testConvertWithSpecificAndRepeatedHolidays() throws Exception {
        holidayViewConverter = new HolidayViewConverter();

        List<HolidayView> views = generateSpecificAndRepeatedHolidays();

        List<HolidayDto> response = holidayViewConverter.convert(views);

        Assert.assertEquals(3, response.size());

    }

    private List<HolidayView> generateSpecificAndRepeatedHolidays(){
        List<HolidayView> views = Lists.newArrayList();

        HolidayView holidayView = null;

        holidayView = createHolidayView("2016-02-07",HolidayType.Repeated, "Sunday");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-09",HolidayType.Repeated, "Tuesday");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-14",HolidayType.Repeated, "Sunday");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-16",HolidayType.Repeated, "Tuesday");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-21",HolidayType.Repeated, "Sunday");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-22",HolidayType.Specific, "Vacation");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-23",HolidayType.Specific, "Vacation");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-24",HolidayType.Specific, "Vacation");
        views.add(holidayView);

        holidayView = createHolidayView("2016-02-28",HolidayType.Repeated, "Sunday");
        views.add(holidayView);

        return views;
    }

    private HolidayView createHolidayView(String date, HolidayType holidayType, String note){
        HolidayView holidayView = new HolidayView();
        holidayView.setNote(note);
        holidayView.setHolidayType(holidayType);
        holidayView.setHolidayDate(DateHelper.fromDateString(date));

        return holidayView;
    }

}

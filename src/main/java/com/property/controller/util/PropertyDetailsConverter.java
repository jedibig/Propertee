package com.property.controller.util;


import com.property.dto.Property_Details;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class PropertyDetailsConverter {

    public final FurnishingConverter furnishingConverter = new FurnishingConverter();
    public final DateConverter dateConverter = new DateConverter();


    public class FurnishingConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Property_Details.Furnishing.class, text.toUpperCase()));
        }
    }

    public class DateConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Date.parse(text));
        }
    }
}

package com.property.controller.util;


import com.property.dto.Property_Details;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Component
public class PropertyDetailsConverter {

    public final FurnishingConverter furnishingConverter = new FurnishingConverter();
    public final DateConverter dateConverter = new DateConverter();


    public static class FurnishingConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Property_Details.Furnishing.class, text.toUpperCase()));
        }
    }

    public static class DateConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(LocalDate.parse(text));
        }
    }
}

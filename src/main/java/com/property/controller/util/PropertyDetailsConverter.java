package com.property.controller.util;


import com.property.dto.PropertyDetails;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.util.Date;

@Component
public class PropertyDetailsConverter {

    public final FurnishingConverter furnishingConverter = new FurnishingConverter();
    public final DateConverter dateConverter = new DateConverter();


    public class FurnishingConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(PropertyDetails.Furnishing.class, text.toUpperCase()));
        }
    }

    public class DateConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Date.parse(text));
        }
    }
}

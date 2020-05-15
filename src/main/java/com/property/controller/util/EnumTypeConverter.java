package com.property.controller.util;

import java.beans.PropertyEditorSupport;

public class EnumTypeConverter<T extends Enum<T>> extends PropertyEditorSupport {

    private final Class<T> clazz;

    public EnumTypeConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Enum.valueOf(clazz, text.toUpperCase()));
    }
}

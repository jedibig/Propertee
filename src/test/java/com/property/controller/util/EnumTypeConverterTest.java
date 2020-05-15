package com.property.controller.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.beans.PropertyEditorSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EnumTypeConverterTest {

    enum TestEnum1 {
        VALUE1, VALUE2, VALUE3;
    }

    enum TestEnum2 {
        VALUE1("value1"), VALUE2("value2"), VALUE3("value3");

        String name;

        TestEnum2(String name) {
            this.name = name;
        }
    }

    @Test
    void testValidConversion1() {
        PropertyEditorSupport converter = new EnumTypeConverter<>(TestEnum1.class);
        converter.setAsText("value1");
        assertEquals(TestEnum1.VALUE1, converter.getValue());
        assertThrows(IllegalArgumentException.class, () -> converter.setAsText("value4"));
    }

    @Test
    void testValidConversion2() {
        PropertyEditorSupport converter = new EnumTypeConverter<>(TestEnum2.class);
        converter.setAsText("value3");
        assertEquals(TestEnum2.VALUE3, converter.getValue());
    }


}

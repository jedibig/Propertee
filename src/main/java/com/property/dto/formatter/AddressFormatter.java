package com.property.dto.formatter;

import com.property.dto.Address;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AddressFormatter implements Formatter<Address> {
    @Override
    public Address parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Address object, Locale locale) {
        return null;
    }
}

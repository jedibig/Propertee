package com.property.controller.util;

import com.property.dto.Listing;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class ListingFieldsMapper {

    public final PropertyTypeConverter propertyTypeConverter = new PropertyTypeConverter();
    public final ListForConverter listForConverter = new ListForConverter();
    public final UserTypeConverter userTypeConverter = new UserTypeConverter();
    public final HouseSubtypeConverter houseSubtypeConverter = new HouseSubtypeConverter();
    public final ApartmentSubtypeConverter apartmentSubtypeConverter = new ApartmentSubtypeConverter();

    public class PropertyTypeConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Listing.Property_Type.class, text.toUpperCase()));
        }
    }

    public class ListForConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Listing.List_For.class, text.toUpperCase()));
        }
    }

    public class UserTypeConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Listing.User_Type.class, text.toUpperCase()));
        }
    }

    public class HouseSubtypeConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Enum.valueOf(Listing.House_Subtype.class, text.toUpperCase()));
        }
    }

    public class ApartmentSubtypeConverter extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Enum.valueOf(Listing.Apartment_Subtype.class, text.toUpperCase());
        }
    }
}

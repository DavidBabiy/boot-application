package com.itdev.bootapplication.projection;

public interface AddressProjection extends IdProjection {

    String getStreet();
    String getCity();
    Integer getHouseNumber();
    Integer getApartmentNumber();

}

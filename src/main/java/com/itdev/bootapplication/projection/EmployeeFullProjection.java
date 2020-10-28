package com.itdev.bootapplication.projection;

import java.util.List;

public interface EmployeeFullProjection extends IdNameTupleProjection {

    Integer getSalary();
    AddressProjection getAddress();
    List<CompanyProjection> getCompanies();

}

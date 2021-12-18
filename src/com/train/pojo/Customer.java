package com.train.pojo;
// Copyright© 2021 谈翰文
//
//         This program is free software: you can redistribute it and/or modify
//         it under the terms of the GNU General Public License as published by
//         the Free Software Foundation, either version 3 of the License, or
//         (at your option) any later version.
//
//         This program is distributed in the hope that it will be useful,
//         but WITHOUT ANY WARRANTY; without even the implied warranty of
//         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//         GNU General Public License for more details.
//
//         You should have received a copy of the GNU General Public License
//         along with this program.  If not, see <https://www.gnu.org/licenses/>.
public class Customer {
    private String customerId;
    private String customerName;
    private String customerSex;
    private String customerAge;
    private String customerBifthday;
    private String customerDept;
    private String customerMajor;
    private String customerClazzId;
    private String customerCellPhone;
    private String customerPad;


    public Customer() {
        super();
    }

    public Customer(String customerId, String customerName, String customerSex, String customerAge, String customerBifthday,
                   String customerDept, String customerMajor, String customerClazzId, String customerCellPhone,String customerPad) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSex = customerSex;
        this.customerAge = customerAge;
        this.customerBifthday = customerBifthday;
        this.customerDept = customerDept;
        this.customerMajor = customerMajor;
        this.customerClazzId = customerClazzId;
        this.customerCellPhone = customerCellPhone;
        this.customerPad = customerPad;
    }

    public String getcustomerId() {
        return customerId;
    }
    public void setcustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getcustomerName() {
        return customerName;
    }
    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getcustomerSex() {
        return customerSex;
    }
    public void setcustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }
    public String getcustomerAge() {
        return customerAge;
    }
    public void setcustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }
    public String getcustomerDept() {
        return customerDept;
    }
    public void setcustomerDept(String customerDept) {
        this.customerDept = customerDept;
    }
    public String getcustomerMajor() {
        return customerMajor;
    }
    public void setcustomerMajor(String customerMajor) {
        this.customerMajor = customerMajor;
    }
    public String getcustomerClazzId() {
        return customerClazzId;
    }
    public void setcustomerClazzId(String customerClazzId) {
        this.customerClazzId = customerClazzId;
    }
    public String getcustomerCellPhone() {
        return customerCellPhone;
    }
    public void setcustomerCellPhone(String customerCellPhone) {
        this.customerCellPhone = customerCellPhone;
    }

    public String getcustomerBifthday() {
        return customerBifthday;
    }

    public void setcustomerBifthday(String customerBifthday) {
        this.customerBifthday = customerBifthday;
    }

    public String getcustomerPad() {
        return customerPad;
    }

    public void setcustomerPad(String customerPad) {
        this.customerPad = customerPad;
    }

    @Override
    public String toString() {
        return "customer [customerId=" + customerId + ", customerName=" + customerName + ", customerSex=" + customerSex
                + ", customerAge=" + customerAge + ", customerBifthday=" + customerBifthday + ", customerDept=" + customerDept
                + ", customerMajor=" + customerMajor + ", customerClazzId=" + customerClazzId + ", customerCellPhone="
                + customerCellPhone + ", customerPad=" + customerPad + "]";
    }
}

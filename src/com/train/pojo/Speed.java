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
public class Speed {
    private Integer id;
    private String customerId;
    private String clazzId;
    private String score;
    private Customer customer;
    private Clazz clazz;

    public Speed() {
        super();
    }
    public Speed(Integer id,String customerId, String clazzId, String score, Customer customer, Clazz clazz) {
        super();
        this.id = id;
        this.customerId = customerId;
        this.clazzId = clazzId;
        this.score = score;
        this.customer = customer;
        this.clazz = clazz;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getClazzId() {
        return clazzId;
    }
    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }
    public String getSpeed() {
        return score;
    }
    public void setSpeed(String score) {
        this.score = score;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Clazz getClazz() {
        return clazz;
    }
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Speed [id=" + id + ", customerId=" + customerId + ", clazzId=" + clazzId + ", score=" + score
                + ", customer=" + customer + ", clazz=" + clazz + "]";
    }
}

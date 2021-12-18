package com.train.dao;

import com.train.pojo.Customer;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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
public interface CustomerMapper {
    public int addCustomerInfo(Customer customer);
    public int updateCustomerInfo(Customer customer);
    public Customer queryCustomerById(String id);
    public int deleteCustomerInfoById(@Param("customerId") String id);
    public List<Customer> findByPage(HashMap<String,Object> map);
    int selectCount(@Param("customerId")String id);
    //重置
    public int restCustomer(@Param("customerId")String id);
    public int changePwd(@Param("customerId")String customerId, @Param("newPass")String newPass);
}

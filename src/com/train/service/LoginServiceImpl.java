package com.train.service;
import com.train.dao.CustomerMapper;
import com.train.dao.LoginMapper;
import com.train.pojo.Customer;
import com.train.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private CustomerMapper customerMapper;

    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public void setUserMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public boolean login(String name, String password) {

        User user = loginMapper.findUserByName(name);
        System.out.println(user);
        if (user!=null&&user.getPassword().equals(password)){
            System.out.println("获取用户名密码成功");
            return true;
        }
        System.out.println("获取用户名密码失败");
        return false;
    }

    @Override
    public boolean customerlogin(String name, String password) {

        Customer customer = loginMapper.findUserById(name);
        System.out.println(customer);
        if (customer!=null&&customer.getcustomerPad().equals(password)){
            System.out.println("获取用户名密码成功");
            return true;
        }
        System.out.println("获取用户名密码失败");
        return false;
    }

    public Customer queryCustomerById(String loginUser) {
        return  customerMapper.queryCustomerById(loginUser);
    }

    public int updateCustomerPad(String id,String newPad) {
        return customerMapper.changePwd(id,newPad);
    }
}

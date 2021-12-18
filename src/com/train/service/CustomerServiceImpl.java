package com.train.service;
import java.util.HashMap;
import java.util.List;

import com.train.dao.CustomerMapper;
import com.train.pojo.Customer;
import com.train.untils.PageBean;
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
public class CustomerServiceImpl implements CustomerService{
    //调用dao层
    @Autowired
    private CustomerMapper customerMapper;

    public void setCustomermapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    //添加客户信息
    @Override
    public int addCustomerInfo(Customer customer) {
        return customerMapper.addCustomerInfo(customer);
    }

    //查询要更新的客户信息
    @Override
    public Customer queryCustomerById(String id) {
        return customerMapper.queryCustomerById(id);
    }

    //更新客户信息
    @Override
    public int updateCustomerInfo(Customer customer) {
        return customerMapper.updateCustomerInfo(customer);
    }

    //删除客户信息
    @Override
    public int deleteCustomerInfoById(String id) {
        return customerMapper.deleteCustomerInfoById(id);
    }

    //查询全部客户信息
    @Override
    public PageBean<Customer> findByPage(int currentPage,String id) {

        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Customer> pageBean = new PageBean<Customer>();

        pageBean.setCurrPage(currentPage);//封装当前页
        pageBean.setId(id);

        int pageSize=7;//每页显示的数据数
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = customerMapper.selectCount(id);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize); //向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("customerId",id);

        //封装每页显示的数据		
        List<Customer> lists = customerMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public int restCustomer(String id) {
        return customerMapper.restCustomer(id);
    }
}

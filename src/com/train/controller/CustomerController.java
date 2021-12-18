package com.train.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.train.pojo.Customer;
import com.train.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@Controller
@RequestMapping("/customerInfo")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //查询全部
    @RequestMapping("/query")
    public String findCustomerInfo(Model model,@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String id ) {

        model.addAttribute("pagemsg",customerService.findByPage(currentPage, id));

        return "customerInfo";
    }

    //添加客户
    @RequestMapping("/addcustomer")
    public String AddCustomerInfo(Customer customer, Model model) {

        Customer customer1 = customerService.queryCustomerById(customer.getcustomerId());
        if(customer1==null) {
            int rows = customerService.addCustomerInfo(customer);
            if (rows > 0) {
                System.out.println("成功添加" + rows + "条数据！");
                model.addAttribute("msg", "添加成功！");
            } else {
                System.out.println("ִ添加失败");
                model.addAttribute("msg", "添加失败！");
            }
            return "redirect:query";
        }
        model.addAttribute("msg", "学号重复！");
        return "addcustomerinfo";
    }

    //获取要更新的客户信息
    @RequestMapping("/update")
    public String findCustomerInfo(Customer customer1 , Model model) {

        Customer customer = customerService.queryCustomerById(customer1.getcustomerId());
        System.out.println(customer);
        model.addAttribute("customer", customer);
        return "updatecustomer";
    }

    //更新客户
    @RequestMapping("/updatecustomer")
    public String UpdateCustomerinfo(Customer customer) {

        int rows = customerService.updateCustomerInfo(customer);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "条数据！");
        } else {
            System.out.println("ִ更新失败");
        }
        return "redirect:query";
    }

    @RequestMapping("/update2")
    public String findCustomer(Customer customer1 , Model model) {

        Customer customer = customerService.queryCustomerById(customer1.getcustomerId());
        System.out.println(customer);
        model.addAttribute("customer", customer);
        return "updatecustomer2";
    }
    @RequestMapping("/updatecustomer2")
    public String UpdateCustomer(Customer customer) {

        int rows = customerService.updateCustomerInfo(customer);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "条数据！");
        } else {
            System.out.println("ִ更新失败");
        }
        return "redirect:queryByName";
    }

    //删除客户
    @RequestMapping("/deletecustomer")
    @ResponseBody
    public String DeleteCustomer(String id) {

        //String customerId = request.getParameter("customerId");

        int rows = customerService.deleteCustomerInfoById(id);
        if (rows > 0) {
            System.out.println("成功删除" + rows + "条数据！");
            return "OK";
        } else {
            System.out.println("ִ删除失败");
            return "FAIL";
        }

        //return "redirect:query";
    }

    //批量删除
    @RequestMapping("/delselected")
    public String DelSelectedServlet(HttpServletRequest request) {

        String[] name = request.getParameterValues("uid");
        int rs = 0;
        for(int i=0;i<name.length;i++){
            rs = rs + customerService.deleteCustomerInfoById(name[i]);
        }
        if (rs > 0) {
            System.out.println("成功删除" + rs + "条数据！");
        } else {
            System.out.println("ִ删除失败");
        }

        return "redirect:query";
    }

    //重置客户密码
    @RequestMapping("/rest")
    @ResponseBody
    public String  RestServlet(String id) {

        int rows = customerService.restCustomer(id);
        if (rows > 0) {
            System.out.println("成功重置" + rows + "条数据！");
            return "OK";
        }else{

            System.out.println("ִ重置失败");
            return "FAIL";
        }
        //return "redirect:query";
    }

    //通过学号获取客户信息
    @RequestMapping("/queryByName")
    public String QueryById(Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("name");
        System.out.println(id);
        model.addAttribute("customer",customerService.queryCustomerById( id));

        return "user";
    }
}
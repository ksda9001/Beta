package com.train.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.pojo.Customer;
import com.train.pojo.User;
import com.train.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/1")
    public String Login(Model model, User user, HttpServletRequest request, HttpServletResponse response) {
        if(user.getName().length()== 10) {
            boolean flag = loginService.customerlogin(user.getName(), user.getPassword());
            //ModelAndView modelAndView = new ModelAndView();
            if (flag) {
                HttpSession session = request.getSession();
                session.setAttribute("name",user.getName());
                session.setMaxInactiveInterval(6000);
                //modelAndView.setViewName("main1");
                System.out.println("登录成功");
                return "main1";
            } else {
                //modelAndView.setViewName("login");
                System.out.println("登录失败");
                model.addAttribute("msg","登录失败！");
                return "login";
            }
            //return modelAndView;
        }
        else  {
            boolean flag = loginService.login(user.getName(), user.getPassword());
            //ModelAndView modelAndView = new ModelAndView();
            if (flag) {
                HttpSession session = request.getSession();
                session.setAttribute("name",user.getName());
                session.setMaxInactiveInterval(6000);
                //modelAndView.setViewName("main");
                System.out.println("登录成功");
                return "main";
            } else {
                //modelAndView.setViewName("login");
                System.out.println("登录失败");
                model.addAttribute("msg","登录失败！");
                return "login";
            }
            //return modelAndView;
        }
    }

    @RequestMapping("/userlogin")
    public ModelAndView UserLogin(User user ,HttpServletRequest request,HttpServletResponse response) {

        boolean flag = loginService.login(user.getName(), user.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        if (flag) {
            HttpSession session = request.getSession();
            session.setAttribute("name",user.getName());
            session.setMaxInactiveInterval(6000);
            modelAndView.setViewName("main");
            System.out.println("登录成功");
        } else {
            modelAndView.setViewName("login");
            System.out.println("登录失败");
        }
        return modelAndView;
    }

    @RequestMapping("/userexit")
    public String UserExit(User user ,HttpServletRequest request,HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.setAttribute("name",user.getName());
        if(user != null){
            session.removeAttribute("userName");
            request.setAttribute("info",null);
        }

        return "logoff";
    }

    @RequestMapping("/updatepad")
    public String updatePassword(Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        String loginedUser = (String)session.getAttribute("name");
        System.out.println(loginedUser);
        String oldPwd = request.getParameter("oldpass");
        System.out.println(oldPwd);
        String newPwd = request.getParameter("newpass");
        System.out.println(newPwd);

        Customer customer = loginService.queryCustomerById(loginedUser);
        System.out.println(customer);
        if(customer.getcustomerPad().equals(oldPwd)) {
            int r = loginService.updateCustomerPad(customer.getcustomerId(), newPwd);
            if(r > 0) {
                model.addAttribute("msg","更新成功！");
                System.out.println("更新成功！");
            }else {
                model.addAttribute("msg","更新失败！");
                System.out.println("更新失败2！");
            }
        }else {
            model.addAttribute("msg","密码错误！");
            System.out.println("更新失败！");
        }

        return "updatepad";
    }
}

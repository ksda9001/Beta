package com.train.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.train.pojo.Clazz;
import com.train.pojo.Customer;
import com.train.pojo.Speed;
import com.train.service.ClazzService;
import com.train.service.CustomerService;
import com.train.service.SpeedService;
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
@RequestMapping("/speedInfo")
public class SpeedController {
    @Autowired
    private SpeedService speedService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ClazzService clazzService;

    //查询全部信息
    @RequestMapping("/querySpeed")
    public String findCustomerInfo(Model model,@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String id) {

        model.addAttribute("pagemsg",speedService.findByPage(currentPage, id));

        return "CustomerSpeeds";
    }

    //添加成绩信息
    @RequestMapping("/addspeed")
    public String AddClazzInfo(Speed speed, Model model) {

        Customer customer = customerService.queryCustomerById(speed.getCustomerId());

        if(customer != null) {
            Clazz clazz = clazzService.query1(speed.getClazzId());
            if(clazz==null){
                model.addAttribute("msg", "该时速信息不存在!");
                System.out.println("时速信息不存在");
                return "addspeedinfo";
            }else {
                int rows = speedService.addSpeedInfo(speed);
                if (rows > 0) {
                    System.out.println("成功添加" + rows + "条数据！");
                    model.addAttribute("msg","添加成功！");
                } else {
                    System.out.println("ִ添加失败");
                    model.addAttribute("msg","添加失败！");
                }
                return "redirect:querySpeed";
            }
        }
        model.addAttribute("msg", "该学生不存在!");
        System.out.println("学生不存在");
        return "addspeedinfo";
    }

    // 更新成绩
    @RequestMapping("/updateSpeed")
    public String UpdateClazzInfo(Speed speed) {

        int rows = speedService.updateSpeedInfo(speed);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "条数据！");
        } else {
            System.out.println("ִ更新失败");
        }
        return "redirect:querySpeed";
    }

    //获取要修改的成绩
    @RequestMapping("/update")
    public String findClazz(Speed speed1, Model model) {

        Speed speed = speedService.querySpeedById(speed1);
        System.out.println(speed);
        model.addAttribute("speed", speed);
        return "updateSpeed";
    }

    //删除成绩
    @RequestMapping("/deleteSpeed")
    @ResponseBody
    public String DeleteClazz(String id) {

        int rows = speedService.deleteSpeedInfoById(id);
        if (rows > 0) {
            System.out.println("成功删除" + rows + "条数据！");
            return "OK";
        } else {
            System.out.println("ִ删除失败");
            return "F";
        }

        //return "redirect:querySpeed";
    }

    //批量删除
    @RequestMapping("/delselected")
    public String DelClazz(HttpServletRequest request) {

        String[] name = request.getParameterValues("uid");
        int rs = 0;
        for (int i = 0; i < name.length; i++) {
            rs = rs + speedService.deleteSpeedInfoById(name[i]);
        }
        if (rs > 0) {
            System.out.println("成功删除" + rs + "条数据！");
        } else {
            System.out.println("ִ删除失败");
        }

        return "redirect:querySpeed";
    }

    @RequestMapping("/queryById")
    public String QueryById(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("name");
        System.out.println(id);
        model.addAttribute("pagemsg",speedService.findByPage(currentPage, id));

        return "CustomerSpeeds2";

    }
}

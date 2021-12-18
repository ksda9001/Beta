package com.train.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.train.pojo.Clazz;
import com.train.service.ClazzService;
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
@RequestMapping("/clazzInfo")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    // 查询全部
    @RequestMapping("/queryClazz")
    public String findClazzInfo(Model model,@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String id) {

        model.addAttribute("pagemsg",clazzService.findByPage(currentPage, id));

        return "clazzInfo";
    }

    // 添加等级
    @RequestMapping("/addClazz")
    public String AddClazzInfo(Clazz clazz) {

        int rows = clazzService.addClazzInfo(clazz);
        if (rows > 0) {
            System.out.println("成功添加" + rows + "条数据！");
        } else {
            System.out.println("ִ添加失败");
        }
        return "redirect:queryClazz";
    }

    //更新等级
    @RequestMapping("/updateClazz")
    public String UpdateClazzInfo(Clazz clazz) {

        int rows = clazzService.updateClazzInfo(clazz);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "条数据！");
        } else {
            System.out.println("ִ更新失败");
        }
        return "redirect:queryClazz";
    }

    @RequestMapping("/update")
    public String findClazz(Clazz clazz1, Model model) {

        Clazz clazz = clazzService.queryClazzById(clazz1.getClazzId());
        System.out.println(clazz);
        model.addAttribute("clazz", clazz);
        return "updateClazz";
    }

    // 删除等级
    @RequestMapping("/deleteClazz")
    @ResponseBody
    public String DeleteClazz(String id) {

        int rows = clazzService.deleteClazzInfoById(id);
        if (rows > 0) {
            System.out.println("成功删除" + rows + "条数据！");
            return "OK";
        } else {
            System.out.println("ִ删除失败");
            return "F";
        }

        //return "redirect:queryClazz";
    }

    // 批量删除
    @RequestMapping("/delselected")
    public String DelClazz(HttpServletRequest request) {

        String[] name = request.getParameterValues("uid");
        int rs = 0;
        for (int i = 0; i < name.length; i++) {
            rs = rs + clazzService.deleteClazzInfoById(name[i]);
        }
        if (rs > 0) {
            System.out.println("成功删除" + rs + "条数据！");
        } else {
            System.out.println("ִ删除失败");
        }

        return "redirect:queryClazz";
    }

    @RequestMapping("/queryById")
    public String QueryById(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("name");
        System.out.println(id);
        model.addAttribute("pagemsg",clazzService.query(currentPage, id));

        return "clazzInfo1";

    }
}

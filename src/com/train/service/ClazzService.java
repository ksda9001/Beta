package com.train.service;
import com.train.untils.PageBean;
import com.train.pojo.Clazz;
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
public interface ClazzService {
    //获取要修改的等级信息
    public Clazz queryClazzById(String id);

    //查询等级
    public PageBean<Clazz> findByPage(int currentPage,String id);

    //添加等级
    public int addClazzInfo(Clazz course);

    //更新等级
    public int updateClazzInfo(Clazz course);

    //删除等级
    public int deleteClazzInfoById(@Param("courseId") String id);

    public PageBean<Clazz> query(int currentPage,String id);

    public Clazz query1(String id);
}

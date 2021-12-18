package com.train.service;
import java.util.HashMap;
import java.util.List;

import com.train.dao.ClazzMapper;
import com.train.pojo.Clazz;
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
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzMapper clazzMapper;

    public void setClazzMapper(ClazzMapper clazzMapper) {
        this.clazzMapper = clazzMapper;
    }

    //添加等级
    @Override
    public int addClazzInfo(Clazz clazz) {
        return clazzMapper.addClazzInfo(clazz);
    }

    //更新等级
    @Override
    public int updateClazzInfo(Clazz clazz) {
        return clazzMapper.updateClazzInfo(clazz);
    }

    //删除等级
    @Override
    public int deleteClazzInfoById(String id) {
        return clazzMapper.deleteClazzInfoById(id);
    }

    //获取要更新等级的信息
    @Override
    public Clazz queryClazzById(String id) {
        return clazzMapper.queryClazzById(id);
    }

    //查询等级
    @Override
    public PageBean<Clazz> findByPage(int currentPage,String id) {

        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Clazz> pageBean = new PageBean<Clazz>();

        pageBean.setId(id);
        pageBean.setCurrPage(currentPage);//封装当前页数

        int pageSize=7;//每页显示的数据
        pageBean.setPageSize(7);

        //封装记录总数
        int totalCount = clazzMapper.selectCount(id);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("clazzId",id);

        //封装每页显示的数据
        List<Clazz> lists = clazzMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public PageBean<Clazz> query(int currentPage,String id) {

        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Clazz> pageBean = new PageBean<Clazz>();

        pageBean.setId(id);
        pageBean.setCurrPage(currentPage);//封装当前页数

        int pageSize=7;//每页显示的数据
        pageBean.setPageSize(7);

        //封装记录总数
        int totalCount = clazzMapper.selectcount(id);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("id",id);

        //封装每页显示的数据
        List<Clazz> lists = clazzMapper.query(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public Clazz query1(String id) {

        return clazzMapper.query1(id);
    }
}

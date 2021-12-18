package com.train.service;
import java.util.HashMap;
import java.util.List;

import com.train.dao.SpeedMapper;
import com.train.pojo.Speed;
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
public class SpeedServiceImpl implements SpeedService{
    @Autowired
    private SpeedMapper speedMapper;

    public void setSpeedMapper(SpeedMapper speedMapper) {
        this.speedMapper = speedMapper;
    }

    //获取要更新速度的信息
    @Override
    public Speed querySpeedById(Speed speed) {

        return speedMapper.querySpeedById(speed);
    }

    //添加速度
    @Override
    public int addSpeedInfo(Speed speed) {

        return speedMapper.addSpeedInfo(speed);
    }

    //更新速度
    @Override
    public int updateSpeedInfo(Speed speed) {

        return speedMapper.updateSpeedInfo(speed);
    }

    //删除速度
    @Override
    public int deleteSpeedInfoById(String id) {

        return speedMapper.deleteSpeedInfoById(id);
    }

    //查询速度信息
    @Override
    public PageBean<Speed> findByPage(int currentPage, String id) {

        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Speed> pageBean = new PageBean<Speed>();

        pageBean.setId(id);
        pageBean.setCurrPage(currentPage);//封装当前页数

        int pageSize=7;//每页显示数据数
        pageBean.setPageSize(pageSize);

        //封装记录总数
        int totalCount = speedMapper.selectCount(id);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("id",id);

        //封装每页显示的数据
        List<Speed> lists = speedMapper.findByPage(map);
        System.out.println(lists);

        pageBean.setLists(lists);

        return pageBean;
    } 
}

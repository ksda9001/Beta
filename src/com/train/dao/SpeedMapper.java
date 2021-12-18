package com.train.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.train.pojo.Speed;
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
public interface SpeedMapper {
    // 获取要更新时速的信息
    public Speed querySpeedById(Speed score);

    // 查询时速
    List<Speed> findByPage(HashMap<String,Object> map);

    // 添加时速
    public int addSpeedInfo(Speed score);

    // 更新时速
    public int updateSpeedInfo(Speed score);

    // 删除时速
    public int deleteSpeedInfoById(String id);

    //获取总条数
    public int selectCount(@Param("id")String id);

}

package com.train.dao;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.train.pojo.Clazz;

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
public interface ClazzMapper {
    //获取要更新等级的信息
    public Clazz queryClazzById(@Param("clazzId") String id);

    //添加等级
    public int addClazzInfo(Clazz clazz);

    // 更新等级
    public int updateClazzInfo(Clazz clazz);

    // 删除等级
    public int deleteClazzInfoById(@Param("clazzId")String id);

    //查询等级
    public List<Clazz> findByPage(HashMap<String,Object> map);

    //查询总条数
    public int selectCount(@Param("clazzId")String id);

    //通过学号查询等级
    public List<Clazz> query(HashMap<String,Object> map);

    //查询总条数
    public int selectcount(String id);

    //查询等级
    public Clazz query1(String id);
}

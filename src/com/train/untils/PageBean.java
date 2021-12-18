package com.train.untils;
import java.util.List;
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
public class PageBean<T> {
    private int currPage;//当前页数
    private int pageSize;//每页显示的记录数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private String id;
    private List<T> lists;//每页的显示的数据

    public PageBean() {
        super();
    }
    public int getCurrPage() {
        return currPage;
    }
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public List<T> getLists() {
        return lists;
    }
    public void setLists(List<T> lists) {
        this.lists = lists;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

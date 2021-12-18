package com.train.pojo;
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
public class Clazz {
    private String id;
    private String clazzId;
    private String clazzName;
    private String buyYear;
    private String teacher;
    private String creditHour;

    public Clazz() {
        super();
    }

    public Clazz(String id, String clazzId, String clazzName, String buyYear, String teacher, String creditHour) {
        super();
        this.id = id;
        this.clazzId = clazzId;
        this.clazzName = clazzName;
        this.buyYear = buyYear;
        this.teacher = teacher;
        this.creditHour = creditHour;
    }

    public String getSchoolYear() {
        return buyYear;
    }

    public void setSchoolYear(String buyYear) {
        this.buyYear = buyYear;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(String creditHour) {
        this.creditHour = creditHour;
    }

    public String getClazzId() {
        return clazzId;
    }
    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }
    public String getClazzName() {
        return clazzName;
    }
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Clazz [id=" + id + ", clazzId=" + clazzId + ", clazzName=" + clazzName + ", buyYear="
                + buyYear + ", teacher=" + teacher + ", creditHour=" + creditHour + "]";
    }
}

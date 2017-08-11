package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Employee;
import com.zhidi.util.DateUtil;

/**
 * Created by Administrator on 2017/7/31.
 */
public class EmployeeVO {
    private String empid;
    private String position;
    private Integer status;
    private String name;
    private String img;
    private String sex;
    private String email;
    private String telephone;
    private String address;
    private String createtime;
    private String createby;
    private String updatetime;
    private String updateby;
    private String userid;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public static EmployeeVO parseEmployee(Employee emp){
        if (emp != null){
            EmployeeVO empVo = new EmployeeVO();
            empVo.setEmpid(emp.getEmpid());
            empVo.setAddress(emp.getAddress());
            empVo.setCreateby(emp.getCreateby());
            empVo.setCreatetime(DateUtil.formatDate(emp.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            empVo.setEmail(emp.getEmail());
            empVo.setImg(emp.getImg());
            empVo.setName(emp.getName());
            empVo.setPosition(emp.getPosition() == null ? null : emp.getPosition().getPositionid());
            empVo.setSex(emp.getSex() == null ? null :emp.getSex().toString());
            empVo.setStatus(emp.getStatus());
            empVo.setTelephone(emp.getTelephone());
            empVo.setUpdateby(emp.getUpdateby());
            empVo.setUpdatetime(DateUtil.formatDate(emp.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            empVo.setUserid(emp.getUser() == null ? null : emp.getUser().getId());
            return empVo;
        }
        return null;
    }

}

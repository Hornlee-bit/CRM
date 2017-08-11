package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Position;



/**
 * Created by Administrator on 2017-08-01.
 */
public class PositionVO {
    private String positionid;
    //private Department department;
    private String departmentParentId;//所属部门id
    private String positionParentId;//上级岗位id
    private String departmentName;
    private String positionName;
    //private Position position;
    private String name;
    private String description;

    public static PositionVO fromPosition(Position position){
        if(position!=null){
            PositionVO positionVO = new PositionVO();
            positionVO.setPositionid(position.getPositionid());
            positionVO.setName(position.getName());
            positionVO.setDescription(position.getDescription());
            if(position.getDepartment()!=null){
                positionVO.setDepartmentParentId(position.getDepartment().getDepartmentid());
                positionVO.setDepartmentName(position.getDepartment().getName());
            }
            if(position.getPosition()!=null){
                positionVO.setPositionParentId(position.getPosition().getPositionid());
                positionVO.setPositionName(position.getPosition().getName());
            }
            return positionVO;
        }
        return null;
    }
    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(String departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    public String getPositionParentId() {
        return positionParentId;
    }

    public void setPositionParentId(String positionParentId) {
        this.positionParentId = positionParentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}

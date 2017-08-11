package com.zhidi.system.vo;

import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.util.DateUtil;

/**
 * Created by Administrator on 2017-07-27.
 */
public class RoleVO {
    private String id;
    private String rolename;
    private Integer sortnum;
    private Integer status;
    private String rolenote;
    private String funcIds;
    private String createById;
    private String createByName;
    private String createTime;
    private String updateByName;
    private String updateById;
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRolenote() {
        return rolenote;
    }

    public void setRolenote(String rolenote) {
        this.rolenote = rolenote;
    }

    public String getFuncIds() {
        return funcIds;
    }

    public void setFuncIds(String funcIds) {
        this.funcIds = funcIds;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public static RoleVO fromRole(Role role){
        if(role!=null) {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(role.getId());
            roleVO.setRolename(role.getRolename());
            roleVO.setSortnum(role.getSortnum());
            roleVO.setStatus(role.getStatus());
            roleVO.setCreateTime(DateUtil.formatDate(role.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            roleVO.setUpdateTime(DateUtil.formatDate(role.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            roleVO.setRolenote(role.getRolenote());
            if (role.getUserByCreateby() != null) {
                roleVO.setCreateById(role.getUserByCreateby().getId());
                roleVO.setCreateByName(role.getUserByCreateby().getUsername());
            }
            if (role.getUserByUpdateby() != null) {
                roleVO.setUpdateById(role.getUserByUpdateby().getId());
                roleVO.setUpdateByName(role.getUserByUpdateby().getUsername());
            }
            StringBuffer sbIds = new StringBuffer();
            if(role.getFunctions()!=null){
                for(Function function : role.getFunctions()){
                    sbIds.append(function.getId());
                    sbIds.append(",");
                }
            }
            if(sbIds.length()>0){
                sbIds.deleteCharAt(sbIds.length()-1);
            }
            roleVO.setFuncIds(sbIds.toString());
            return roleVO;
        }
        return null;
    }
}

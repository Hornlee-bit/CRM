package com.zhidi.system.vo;

import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;

import java.util.Date;

/**
 * Created by lx on 2017/7/25.
 */
public class UserVO {

    private String id;
    private String updateById;
    private String updateByName;
    private String createById;
    private String createByName;
    private String createTime;
    private String email;
    private String password;
    private String phone;
    private String salt;
    private Integer sortnum;
    private Integer status;
    private String updateTime;
    private String usernote;
    private String username;
    private String roleIds;
    private String roleNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUsernote() {
        return usernote;
    }

    public void setUsernote(String usernote) {
        this.usernote = usernote;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    /**
     * 把User对象的属性封装到vo中
     * @param user
     * @return
     */
    public static UserVO fromUser(User user) {
        if (user != null) {
            UserVO userVO = new UserVO();
            userVO.setId(user.getId());
            if (user.getUserByUpdateby() != null) {
                userVO.setUpdateById(user.getUserByUpdateby().getId());
                userVO.setUpdateByName(user.getUserByUpdateby().getUsername());
            }
            if (user.getUserByCreateby() != null) {
                userVO.setCreateById(user.getUserByCreateby().getId());
                userVO.setCreateByName(user.getUserByCreateby().getUsername());
            }

            userVO.setCreateTime(DateUtil.formatDate(user.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            userVO.setEmail(user.getEmail());
            userVO.setPassword(user.getPassword());
            userVO.setPhone(user.getPhone());
            userVO.setSalt(user.getSalt());
            userVO.setSortnum(user.getSortnum());
            userVO.setUpdateTime(DateUtil.formatDate(user.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            userVO.setUsernote(user.getUsernote());
            userVO.setUsername(user.getUsername());
            userVO.setStatus(user.getStatus());

            //创建两个StringBuffer来拼接
            StringBuffer sbName = new StringBuffer();
            StringBuffer sbIds = new StringBuffer();
            if (user.getRoles() != null) {
                for (Role role : user.getRoles()) {
                    sbName.append(role.getRolename());
                    sbName.append(",");
                    sbIds.append(role.getId());
                    sbIds.append(",");
                }
            }
            if (sbName.length() > 0) {
                sbName.deleteCharAt(sbName.length() - 1 );
                sbIds.deleteCharAt(sbIds.length() - 1);
            }
            userVO.setRoleIds(sbIds.toString());
            userVO.setRoleNames(sbName.toString());
            return userVO;
        }
        return null;
    }
}

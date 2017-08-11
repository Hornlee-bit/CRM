package com.zhidi.system.vo;

import com.zhidi.system.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * Created by Administrator on 2017-08-04.
 */
public class QueryUserVO {
    private String id;
    private String username;

    public static QueryUserVO fromUser(User user){
        if(user!=null){
            QueryUserVO queryUserVO = new QueryUserVO();
            BeanUtils.copyProperties(user,queryUserVO);
            return queryUserVO;
        }
        return null;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

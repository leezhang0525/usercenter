package com.zhangsan.dto.req.login;

import com.google.common.base.Preconditions;
import com.zhangsan.common.constants.ResConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author zhangsan
 * @Date 2022/5/9 16:47
 */
@Data
public class LoginReqDTO implements Serializable {
    private static final long serialVersionUID = 5235497320362583676L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录类型
     */
    private Integer loginType;

    public void checkParam (){
        Preconditions.checkArgument(StringUtils.isNotBlank(this.getUsername()), ResConstants.MSG_USERNAME_EMPTY_ERROR);
        Preconditions.checkArgument(StringUtils.isNotBlank(this.getPassword()),ResConstants.MSG_PASSWORD_EMPTY_ERROR);
        Preconditions.checkArgument(this.getLoginType() != null,ResConstants.MSG_LOGIN_TYPE_EMPTY_ERROR);
    }
}

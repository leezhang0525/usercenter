package com.zhangsan.impl.login;

import com.zhangsan.common.constants.ResConstants;
import com.zhangsan.common.exception.ServiceException;
import com.zhangsan.dto.req.login.LoginReqDTO;
import com.zhangsan.entity.user.TUser;
import com.zhangsan.service.login.LoginService;
import com.zhangsan.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author zhangsan
 * @Date 2022/5/9 16:41
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public String login(LoginReqDTO loginReqDTO) {
        // 检验登录信息
        loginReqDTO.checkParam();
        String userName = loginReqDTO.getUsername();
        String password = loginReqDTO.getPassword();
        Integer loginType = loginReqDTO.getLoginType();
        // 获取用户信息
        TUser user = userService.getUserByUserName(userName);
        if(Objects.isNull(user)){
            // 用户不存在
            throw new ServiceException(ResConstants.MSG_USERNAME_ERROR);
        }
        if(!user.getPassword().equals(password)){
            // 密码错误
            throw new ServiceException(ResConstants.MSG_PASSWORD_ERROR);
        }
        String userId = user.getId().toString();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user",userId);
        return userId;
    }

    @Override
    public String test() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        String userId =(String) session.getAttribute("user");
        return userId;
    }
}

package com.zhangsan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhangsan
 * @since 2022-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 用户签名
     */
    @TableField("token")
    private String token;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField("creationtime")
    private Date creationtime;

    /**
     * 创建人
     */
    @TableField("creator")
    private Integer creator;

    /**
     * 修改时间
     */
    @TableField("modifiedtime")
    private Date modifiedtime;

    /**
     * 修改人
     */
    @TableField("modifier")
    private Integer modifier;


}

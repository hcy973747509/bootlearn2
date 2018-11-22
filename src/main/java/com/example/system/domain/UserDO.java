package com.example.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author huangcy
 * @Date 2018/11/22 17:15
 * @Version 1.0
 **/
@Data
@TableName("sys_user")
public class UserDO implements Serializable{

	private static final long serialVersionUID = 974935497223698167L;

	private Long userId;
	// 用户名
	private String username;
	// 用户真实姓名
	private String name;
	// 密码
	private String password;
	// 部门
	private Long deptId;
	@TableField(exist=false)
	private String deptName;
	// 邮箱
	private String email;
	// 手机号
	private String mobile;
	// 状态 0:禁用，1:正常
	private Integer status;
	// 创建用户id
	private Long userIdCreate;
	// 创建时间
	private Date gmtCreate;
	// 修改时间
	private Date gmtModified;
	//角色
	@TableField(exist=false)
	private List<Long> roleIds;
	//性别
	private Long sex;
	//出身日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	//图片ID
	private Long picId;
	//现居住地
	private String liveAddress;
	//爱好
	private String hobby;
	//省份
	private String province;
	//所在城市
	private String city;
	//所在地区
	private String district;
}

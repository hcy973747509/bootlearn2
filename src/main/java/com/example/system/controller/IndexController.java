package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.domain.UserDO;
import com.example.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author huangcy
 * @Date 2018/11/22 17:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/system")
public class IndexController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping
	public Object findOne(){
		QueryWrapper<UserDO> userDOQueryWrapper = new QueryWrapper<>();
		userDOQueryWrapper.eq("user_id","1");
		return userMapper.selectOne(userDOQueryWrapper);
	}
}

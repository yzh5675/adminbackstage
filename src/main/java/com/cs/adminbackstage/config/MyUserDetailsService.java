package com.cs.adminbackstage.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cs.adminbackstage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserDetailsService")
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		QueryWrapper<com.cs.adminbackstage.entity.User> wrapper=new QueryWrapper<com.cs.adminbackstage.entity.User>();
		wrapper.eq("name",username);

		com.cs.adminbackstage.entity.User user=userMapper.selectOne(wrapper);
		if (user==null) {
			throw new BadCredentialsException("用户名不存在，请注册") ;
		}

		List<SimpleGrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("discuss"));

		UserDetails userDetails=new User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()),list);
		return userDetails;
	}

}

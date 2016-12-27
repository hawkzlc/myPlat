package com.yihaomen.mybatis.inter;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

public interface IUserOperation {
	// 此处方法名要与User.xml中的方法id相同---<select id="selectUserByID"
	// @Select("select * from user where id = #{id}")
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public List<Article> getUserArticles(int id);
}
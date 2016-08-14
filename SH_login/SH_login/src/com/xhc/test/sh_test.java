package com.xhc.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.xhc.entity.Users;
import com.xhc.service.UsersService;

public class sh_test {
	public static void main(String[] args) {
		sh_test st=new sh_test();
		//st.create_table();
		//st.findAll();
		//st.delete(1);
		//st.findAll();
		//st.save();
		st.get(1);
		
	}
/*	public void create_table(){
		Configuration cfg=new Configuration().configure();
		SchemaExport se=new SchemaExport(cfg);
		se.create(true,true);
	}
	public void findAll(){
		UsersService us=new UsersService();
		List<Users> list=us.findAll();
		for (Users s:list) {
			System.out.println(s);
			
		}
	}*/
	public void delete(int id){
		UsersService us=new UsersService();
		us.delete(id);
	}
	public void findAll(){
		UsersService us=new UsersService();
		List<Users> list=new ArrayList<>();
		list=us.findAll();
		for(Users s:list){
			System.out.println(s);
		}
	}
	public void save(){
		UsersService us=new UsersService();
		Users user=new Users();
		user.setUser_name("lisi");
		user.setAddress("hz");
		user.setAge(23);
		user.setPassword("1234");
		user.setReal_name("sisi");
		us.save(user);
	}
	public void get(Integer id){
		UsersService us=new UsersService();
		Users users=new Users();
		users=us.get(id);
		System.out.println(users);
	}
}

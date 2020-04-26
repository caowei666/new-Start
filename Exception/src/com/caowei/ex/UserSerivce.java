package com.caowei.ex;

public class UserSerivce {
	public User login(String username,String password)throws MyException {
		if(!"admin".equals(username)) {
			throw new MyException("ÓÃ»§Ãû´íÎó");
		}else if(!"12345".equals(password)) {
			throw new MyException("ÃÜÂë´íÎó");
		}
		User user = new User("adming","12345",18,"ÄĞ");
				return user;
	}
}

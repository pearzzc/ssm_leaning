package com.zzc.test;

import com.zzc.domain.User;
import com.zzc.domain.UserQueryVo;
import com.zzc.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMapperTest {
	private ApplicationContext applicationContext;

	@Before
	public void init() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserList() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setSex("男");
        user.setUsername("周周舟");
        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(10);
        lists.add(24);

        userQueryVo.setIds(lists);
        List<User> userList = userMapper.findUserList(userQueryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

	@Test
	public void testFindUserCount() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        Integer userCount = userMapper.findUserCount("小");
        System.out.println(userCount);
    }

	@Test
	public void testFindUserListResultMap() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
    }

	@Test
	public void testFindUserByName() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        List<User> users = userMapper.findUserByName("明");
        for (User user : users) {
            System.out.println(user);
        }
    }

	@Test
	public void testInsertUser() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = new User("你妹的", new Date(), "男", "三都没回");
        userMapper.insertUser(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = new User();
        user.setId(1);
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("上东");
        user.setUsername("ziziz");

        userMapper.updateUser(user);
    }
    @Test
    public void testDeleteUser() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        userMapper.deleteUser(38);
    }
}

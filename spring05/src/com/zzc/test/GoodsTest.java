package com.zzc.test;

import com.zzc.demo1.GoodsDao;
import com.zzc.demo1.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsTest {
    //属性注入
    @Resource(name="goodsDao")
    private GoodsDao goodsDao;
    @Resource(name = "userDao")
    private User user;
    @Test
    public void test(){
       /* this.goodsDao.add();*/
        /*this.goodsDao.delete();*/
       /* this.goodsDao.update();*/
        this.goodsDao.find();
        /*this.user.save();*/
    }
}

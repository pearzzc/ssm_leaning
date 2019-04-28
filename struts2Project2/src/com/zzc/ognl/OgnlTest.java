package com.zzc.ognl;

import com.zzc.domain.Goods;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

public class OgnlTest {
    @Test
    public void test() throws OgnlException {
        //使用ognl
        OgnlContext ognlContext = new OgnlContext();
        //存数据  根对象
        Goods goods = new Goods();
        goods.setName("zhouzechong");
        goods.setPrice(12.4);

        ognlContext.setRoot(goods);

        //获取数据:分三步：使用的是Ognl的方法: getVavle()
        //1.表达式： 哪一个字段
        //2.ognlContext
        //3.root
        Object root = ognlContext.getRoot();

        //取出相应的数据
        Object name = Ognl.getValue("price", ognlContext, root);
        System.out.println(name);

    }

    @Test
    public void test1() throws OgnlException {
        //使用ognl,存在非根对象中的数据以键值对的形式：
        OgnlContext ognlContext = new OgnlContext();
        //存数据 非根对象
        Goods goods = new Goods();
        goods.setName("zhouzechong");
        goods.setPrice(12.4);

        ognlContext.put("goods",goods);

        //获取数据:分三步：使用的是Ognl的方法: getVavle().存在非跟对象的时候，不能直接取出对应的字段，只能取出相应的对象
        //1.表达式：#key
        //2.ognlContext
        //3.root
        Object root = ognlContext.getRoot();

        //取出相应的数据
        Goods goods1 = (Goods)Ognl.getValue("#goods", ognlContext, root);
        System.out.println(goods1.getName());
        System.out.println(goods1.getPrice());

    }
    @Test
    public void test3() throws OgnlException {
        OgnlContext ognlContext = new OgnlContext();
        Object root = ognlContext.getRoot();

        //调用相应的普通方法
        Object value = Ognl.getValue("'hhh'.length()", ognlContext, root);
        System.out.println(value);

        //调用静态的方法
        Object value1 = Ognl.getValue("@java.lang.Math@random()", ognlContext.getRoot());
        System.out.println(value1);
    }
}

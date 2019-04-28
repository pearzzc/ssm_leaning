package com.zzc.ognl;

import com.zzc.domain.Goods;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

public class OgnlTest {
    @Test
    public void test() throws OgnlException {
        //ʹ��ognl
        OgnlContext ognlContext = new OgnlContext();
        //������  ������
        Goods goods = new Goods();
        goods.setName("zhouzechong");
        goods.setPrice(12.4);

        ognlContext.setRoot(goods);

        //��ȡ����:��������ʹ�õ���Ognl�ķ���: getVavle()
        //1.���ʽ�� ��һ���ֶ�
        //2.ognlContext
        //3.root
        Object root = ognlContext.getRoot();

        //ȡ����Ӧ������
        Object name = Ognl.getValue("price", ognlContext, root);
        System.out.println(name);

    }

    @Test
    public void test1() throws OgnlException {
        //ʹ��ognl,���ڷǸ������е������Լ�ֵ�Ե���ʽ��
        OgnlContext ognlContext = new OgnlContext();
        //������ �Ǹ�����
        Goods goods = new Goods();
        goods.setName("zhouzechong");
        goods.setPrice(12.4);

        ognlContext.put("goods",goods);

        //��ȡ����:��������ʹ�õ���Ognl�ķ���: getVavle().���ڷǸ������ʱ�򣬲���ֱ��ȡ����Ӧ���ֶΣ�ֻ��ȡ����Ӧ�Ķ���
        //1.���ʽ��#key
        //2.ognlContext
        //3.root
        Object root = ognlContext.getRoot();

        //ȡ����Ӧ������
        Goods goods1 = (Goods)Ognl.getValue("#goods", ognlContext, root);
        System.out.println(goods1.getName());
        System.out.println(goods1.getPrice());

    }
    @Test
    public void test3() throws OgnlException {
        OgnlContext ognlContext = new OgnlContext();
        Object root = ognlContext.getRoot();

        //������Ӧ����ͨ����
        Object value = Ognl.getValue("'hhh'.length()", ognlContext, root);
        System.out.println(value);

        //���þ�̬�ķ���
        Object value1 = Ognl.getValue("@java.lang.Math@random()", ognlContext.getRoot());
        System.out.println(value1);
    }
}

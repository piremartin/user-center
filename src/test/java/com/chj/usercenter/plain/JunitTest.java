package com.chj.usercenter.plain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.chj.usercenter.domain.UserE;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class JunitTest {

    private UserE user;



    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("junit---before class");
    }

    @Test
    public void test1(){
        System.out.println("junit---test1");
    }

    //junit
    @Test(expected = ArithmeticException.class)
    public void testException(){
//        UserE user = null;
//        System.out.println(user.getName());

        int i = 1/0;
    }

    @Ignore
    @Test
    public void testIgnore(){
        System.out.println("junit - do nothing");
    }

    //junit
    @Test(timeout = 1000)
    public void testTimeout(){
        while (true);
    }




    @Before
    public void setUp() throws Exception {
        user = new UserE();
        user.setName("王力宏");
        user.setAge(18);
    }

    @Test
    public void testFastJson1() {
        Date date = new Date();
        String strDate = JSON.toJSONString(date);
        System.out.println("strDate=" + strDate);
    }
    @Test
    public void test2() {
        UserE user = new UserE();
        user.setName("leehome");
        user.setAge(18);
        String jsonPerson = JSON.toJSONString(user);
        UserE parseUser = JSON.parseObject(jsonPerson, UserE.class);
        System.out.println("------");
    }
    @Test
    public void test3(){
        List<UserE> list = new ArrayList<>();
        list.add(new UserE("zhoujielun"));
        list.add(new UserE("linjunjie"));
        String jsonList = JSON.toJSONString(list);
        List<UserE> parseList = JSON.parseArray(jsonList, UserE.class);
        System.out.println("-----------------");
    }
    @Test
    public void test4(){
        Map<Long,UserE> map = new HashMap<>();
        map.put(1L,new UserE("林志玲"));
        map.put(2L,new UserE("林俊杰"));
        String jsonMap = JSON.toJSONString(map) ;

        Map<Long, UserE> parseMap = JSON.parseObject(jsonMap,
                new TypeReference<Map<Long, UserE>>() {});
        System.out.println(parseMap.get(2L));
        System.out.println("-----------------");

    }

    //跨应用-条件查询
    @Test
    public void test5(){
        //此处可尝试用builder模式


        String jsonPerson = JSON.toJSONString(user);
        JSONObject jsonObjPerson = JSON.parseObject(jsonPerson);
        String name = jsonObjPerson.getString("name");
        assertEquals("王力宏", name);

        Integer age = jsonObjPerson.getInteger("age");
        assertEquals(Long.valueOf("18"), Long.valueOf(String.valueOf(age)));
        System.out.println("------");
    }
}

package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * mybatis的工具类
 */
public class    MybatisUtil {

    //定义一个用于生产核心对象SqlSession的工厂对象
    private static SqlSessionFactory factory;

    //使用静态代码块给工厂赋值
    static {
        //1.定义流对象
        InputStream in = null;
        try{
            //1.读取核心配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.构建工程对象
            factory = builder.build(in);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in != null){
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    //提供一个静态方法，从工厂中生产一个新的SqlSession对象
    public static SqlSession openSession(){
        return factory.openSession();
    }


    public static void commit(SqlSession sqlSession){
        sqlSession.commit();
    }

    public static void rollback(SqlSession sqlSession){
        sqlSession.rollback();
    }


    public static  void close(SqlSession sqlSession){
        sqlSession.close();
    }
}

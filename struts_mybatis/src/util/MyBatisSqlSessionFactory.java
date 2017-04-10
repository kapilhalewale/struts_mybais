package util;

import java.io.Reader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ibatis.common.resources.Resources;

public class MyBatisSqlSessionFactory
{
    protected static final SqlSessionFactory FACTORY;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("configuration.xml");
            FACTORY = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e){
            throw new RuntimeException("Error : " + e, e);
        }
    }
    public static SqlSessionFactory getSqlSessionFactory()
    {
        return FACTORY;
    }
}
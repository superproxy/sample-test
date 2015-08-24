package dao;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username} and password=#{password}")
    User getUser(@Param("username")
                 String userName, @Param("password")
                 String password);
}

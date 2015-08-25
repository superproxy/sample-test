package dao;

import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username} and password=#{password}")
    User query(@Param("username")
               String userName, @Param("password")
               String password);

    @Select("SELECT * FROM users WHERE name = #{username}")
    User queryByUserName(@Param("username")
                         String userName);

    @Update("update users set  age = #{age} where name = #{name}")
    public int update(User user);

    @Select("select * from users")
    public List<User> getAllUsers();

    @Select("delete from users where name = #{username}")
    Object delete(@Param("username") String userName);

    @Insert("insert into users(name, password, age)values(#{name}, #{password}, #{age})")
    int create(User user);
}

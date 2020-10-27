package cn.mvc.dao;

import cn.mvc.pojo.UserAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAccountDao {
    List<UserAccount> queryUser(@Param("empyno") String empyno);
}

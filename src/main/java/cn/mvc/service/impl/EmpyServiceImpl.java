package cn.mvc.service.impl;

import cn.mvc.dao.UserAccountDao;
import cn.mvc.pojo.UserAccount;
import cn.mvc.service.EmpyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpyServiceImpl implements EmpyService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public UserAccount queryUser(String empyno) {
        List<UserAccount> list = userAccountDao.queryUser(empyno);
        if(list.iterator().hasNext()){
            return list.iterator().next();
        }
        return null;
    }
}

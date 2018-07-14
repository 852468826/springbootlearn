package com.huawei.springboot.mybaitservice;



import java.util.List;



import com.huawei.springboot.entries.MUser;





public interface ImybatisService {
  public List<MUser> getUsers();

  public boolean updateUser(MUser id);

public boolean createUser(MUser muser);

public MUser getUser(String id);

}

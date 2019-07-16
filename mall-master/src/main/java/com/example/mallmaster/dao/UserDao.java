package com.example.mallmaster.dao;
import com.example.mallmaster.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 根据用户名，密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */

    List<User> findByUsername(String username);


    /**
     * 分页查询用户列表
     *
     * @param pageable
     * @return
     */
    /* Page<User> findAll(Pageable pageable);*/

    /*@Override
    Page<User> findAll(Pageable pageable) ;*/

    /**
     * 删除某一个指定用户
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "delete from  user u where u.id=?1 ",nativeQuery = true)
    boolean delete(@Param("userId") int id);
}

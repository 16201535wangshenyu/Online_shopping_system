package com.example.mallmaster.dao;

import com.example.mallmaster.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderDao extends JpaRepository<Order, Integer> {

    /**
     * 更改订单状态
     * @param state
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update `order` o set o.state=?1 where o.id=?2",nativeQuery = true)
    void updateState(int state, int id);

    /**
     * 查找用户的订单
     * @param userId
     * @return
     */
    List<Order> findByUserId(int userId);

    /**
     * 根据商品Id查找某一个商品
     * @param orderID
     * @return
     */
    @Query(value = "SELECT * FROM `order` where id= ?1  ",nativeQuery = true)
    Order findByOrderId(@Param("orderID") Integer orderID);

    /**
     * 删除订单
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "delete from`order` o where o.id=?1 ",nativeQuery = true)
    void delete(@Param("orderId") int id);
}

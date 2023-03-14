package ra.model.service;

import ra.model.entity.Catalog;
import ra.model.entity.OrDers;

import java.util.List;

public interface OrderService {
    OrDers findByStatusAndUsers_UserId(int userId,int status);
    OrDers findByUsers_UserId(int id);
    List<OrDers> finAllOrders();
    OrDers findOrderById(int orDersId);
    OrDers saveAndUpdate(OrDers orDers);
    void delete(int orDersId);
}

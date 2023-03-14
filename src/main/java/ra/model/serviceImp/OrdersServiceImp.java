package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.OrDers;
import ra.model.repository.OrderRepository;
import ra.model.service.OrderService;

import java.util.List;
@Service

public class OrdersServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public OrDers findByStatusAndUsers_UserId( int userId,int status) {
        return  orderRepository.findByStatusAndUsers_UserId(userId,status);
    }

    @Override
    public OrDers findByUsers_UserId(int id) {
        return orderRepository.findByUsers_UserId(id);
    }

    @Override
    public List<OrDers> finAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrDers findOrderById(int orDersId) {
        return orderRepository.findById(orDersId).get();
    }

    @Override
    public OrDers saveAndUpdate(OrDers orDers) {
        return orderRepository.save(orDers);
    }

    @Override
    public void delete(int orDersId) {
        orderRepository.deleteById(orDersId);

    }
}

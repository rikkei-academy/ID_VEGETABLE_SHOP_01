package ra.model.service;

import org.springframework.stereotype.Service;
import ra.model.entity.OrDerDetail;
import ra.model.entity.OrDers;

import java.util.List;
@Service
public interface OrdersDetaiService {
    List<OrDerDetail> finAllOrderDetail();
    OrDerDetail findOrderDetailById(int detaiId);
    OrDerDetail saveAndUpdate(OrDerDetail orDerDetail);
    void delete(int detaiId);
}

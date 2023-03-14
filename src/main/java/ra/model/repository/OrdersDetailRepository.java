package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.OrDerDetail;
@Repository
public interface OrdersDetailRepository extends JpaRepository<OrDerDetail,Integer> {
}

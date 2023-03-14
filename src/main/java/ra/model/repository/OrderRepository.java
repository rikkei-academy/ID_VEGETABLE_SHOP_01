package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.OrDers;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrDers,Integer> {

    @Query(value = "from OrDers o where o.users.userId=:userId and  o.status=:status")
        OrDers findByStatusAndUsers_UserId( @Param("userId") int userId,@Param("status") int status);
    OrDers findByUsers_UserId(int id);
}

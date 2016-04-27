package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonMenuRepository extends CrudRepository<SalonMenu, Integer>{

	List<SalonMenu> findByType(int type);
}

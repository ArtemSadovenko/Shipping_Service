package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}

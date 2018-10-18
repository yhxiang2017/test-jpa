package cn.xyh.testjpa.repository;

import cn.xyh.testjpa.entity.Persion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersionRepository extends JpaRepository<Persion, Long> {

}

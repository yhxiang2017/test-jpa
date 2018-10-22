package cn.xyh.testjpa.repository;

import cn.xyh.testjpa.entity.Persion;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;

public interface PersionRepository extends JpaRepository<Persion, Long> {


//    @Query("select p.id,p.name,p.age, c.className from Persion p left join Class c on p.id = c.pId")


    @Query(value = "select * from Persion", nativeQuery = true)
    Persion queryPersionById(long id);


}

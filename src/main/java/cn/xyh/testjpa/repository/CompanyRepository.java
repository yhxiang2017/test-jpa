package cn.xyh.testjpa.repository;

import cn.xyh.testjpa.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}

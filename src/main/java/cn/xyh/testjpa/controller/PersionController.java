package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.entity.Company;
import cn.xyh.testjpa.entity.Persion;
import cn.xyh.testjpa.repository.CompanyRepository;
import cn.xyh.testjpa.repository.PersionRepository;
import cn.xyh.testjpa.util.ResponseResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersionController {

    @Autowired
    private PersionRepository persionRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("addPersion")
    public ResponseResult addPersion (@RequestBody Persion persion) {
        Persion save = persionRepository.save(persion);
//        PersionModel model = new PersionModel();
//        BeanUtils.copyProperties(save, model);
//        return ResponseResult.success(model);
        return ResponseResult.success();
    }

    @GetMapping("getById")
    public ResponseResult getById (Long id, String name) {
        System.out.println(name);
        Persion persion = persionRepository.getOne(id);
        return ResponseResult.success(persion);
    }


    @DeleteMapping("delById")
    public ResponseResult delete (long id) {

        Persion persion = persionRepository.getOne(id);

        if (persion == null){
            return ResponseResult.failed();
        }
        persionRepository.delete(persion);

        return ResponseResult.success();
    }

    @PutMapping("updateById")
    public ResponseResult update (long id) {

        Persion persion = persionRepository.getOne(id);

        if (persion == null){
            return ResponseResult.failed();
        }
        persion.setName("lisi");

        persionRepository.saveAndFlush(persion);

        return ResponseResult.success();
    }

    @GetMapping("test")
    public void testAfterThrowing (long id) {
        persionRepository.queryPersionById(id);
    }

    @GetMapping("testPage")
    public ResponseResult pageLimit(int page, int size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Persion> persions = persionRepository.findAll(pageable);
        PageImpl<Persion> page1 = new PageImpl<>(persions.getContent(), pageable, persions.getTotalElements());

        return ResponseResult.success(page1);
    }

    @PostMapping("saveCompany")
    public ResponseResult saveCompany(@RequestBody Company company){
        Company c = companyRepository.save(company);

        System.out.println(c.getStaffList().size());

        return ResponseResult.success("success");
    }
}

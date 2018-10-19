package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.entity.Persion;
import cn.xyh.testjpa.entity.model.PersionModel;
import cn.xyh.testjpa.repository.PersionRepository;
import cn.xyh.testjpa.util.ResponseResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersionController {

    @Autowired
    private PersionRepository persionRepository;

    @PostMapping("addPersion")
    public ResponseResult addPersion (@RequestBody Persion persion) {
        Persion save = persionRepository.save(persion);
        PersionModel model = new PersionModel();
        BeanUtils.copyProperties(save, model);
        return ResponseResult.success(model);
    }

    @GetMapping("getById")
    public ResponseResult getById (Long id) {
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
    public void testAfterThrowing () {
        int i = 1 / 0;
        System.out.println(i);
    }

}

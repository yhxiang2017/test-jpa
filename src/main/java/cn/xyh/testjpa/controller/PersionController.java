package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.entity.Persion;
import cn.xyh.testjpa.entity.model.PersionModel;
import cn.xyh.testjpa.repository.PersionRepository;
import cn.xyh.testjpa.util.ResponseResult;
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

    @GetMapping("testJson")
    public List<Persion> testJson(){
        List<Persion> persions = new ArrayList<Persion>();

        persions.add(new Persion(12, "xiaoming"));
        persions.add(new Persion(13, "dabai"));
        persions.add(new Persion(14, "和哈"));

        return   persions;
    }

    @GetMapping("test")
    public ResponseResult test() {
        Persion persion = new Persion();
        persion.setAge(12);
        persion.setName("hehe");

        ResponseResult responseResult = new ResponseResult("OK",persion);
        return responseResult;
    }
}

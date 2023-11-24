package com.example.TestDeloy.RestController;

import com.example.TestDeloy.Entity.Infor;
import com.example.TestDeloy.Service.InforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RequestMapping("api/infor")
@RestController
public class InforRestController {
    @Autowired
    InforService inforService;

    @GetMapping("get-data")
    public ResponseEntity<?> getData(){
        List<Infor> infors = inforService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(infors);
    }

    @PostMapping("create")
    public ResponseEntity<?> createInfor(@RequestBody Infor infor){
        inforService.create(infor);
        return ResponseEntity.status(HttpStatus.OK).body(infor);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateInfor(@RequestBody Infor infor, @RequestParam String fullname){
        Infor findInfor = inforService.findById(fullname);
        try {
            inforService.create(infor);
            return ResponseEntity.status(HttpStatus.OK).body(infor);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteInfor(@RequestParam String fullname){
        inforService.delete(fullname);
        return ResponseEntity.status(HttpStatus.OK).body("Xóa infor thành công rồi nghe~");
    }
}

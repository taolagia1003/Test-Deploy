package com.example.TestDeloy.Service.ServiceImpl;

import com.example.TestDeloy.DAO.InforDAO;
import com.example.TestDeloy.Entity.Infor;
import com.example.TestDeloy.Service.InforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InforServiceImpl implements InforService {
    @Autowired
    InforDAO inforDAO;

    public List<Infor> findAll() {
        return inforDAO.findAll();
    }

    public void create(Infor infor) {
        inforDAO.save(infor);
    }

    public Infor findById(String fullname) {
        return inforDAO.findById(fullname).get();
    }

    public void delete(String fullname) {
        Infor infor = inforDAO.findById(fullname).get();
        inforDAO.deleteById(infor.getFullname());
    }
}

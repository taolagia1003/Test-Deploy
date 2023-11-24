package com.example.TestDeloy.Service;

import com.example.TestDeloy.Entity.Infor;

import java.util.List;

public interface InforService {
    List<Infor> findAll();

    void create(Infor infor);

    Infor findById(String fullname);

    void delete(String fullname);
}

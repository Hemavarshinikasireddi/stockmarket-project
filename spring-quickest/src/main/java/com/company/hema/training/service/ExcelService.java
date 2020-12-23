package com.company.hema.training.service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.company.hema.training.entity.StockPrice;
import com.company.hema.training.helper.ExcelHelper;
import com.company.hema.training.repository.stockpricerepo;

@Service
public class ExcelService {
  @Autowired
  stockpricerepo repository;

  public void save(MultipartFile file) {
    try {
      List<StockPrice> sps = ExcelHelper.excelTosps(file.getInputStream());
      repository.saveAll(sps);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<StockPrice> getAllsps() {
    return repository.findAll();
  }
}

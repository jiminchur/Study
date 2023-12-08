package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.dao.BasicDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BasicService {

    @Autowired
    private BasicDao basicDao;
    
    // 정상 테스트
    public String test() throws Exception {
        log.info("[BasicService][test] Start!!");
        
        return basicDao.test();
    }

    // Dao 오류 테스트
    public String daoException() throws Exception {
        log.info("[BasicService][daoException] Start!!");
        
        return basicDao.testException();
    }

    // 오류 테스트
    public String testException() throws Exception{
        log.info("[BasicService][testException] Start!!");
        
        throw new Exception("[BasicService][testException] 오류입니다.");
    }
}

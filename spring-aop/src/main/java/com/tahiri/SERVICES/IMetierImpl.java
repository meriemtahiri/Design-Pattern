package com.tahiri.SERVICES;

import com.tahiri.ASPECTS.Log;
import com.tahiri.ASPECTS.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier {
    @Log
    @SecuredByAspect(roles = {"ADMIN", "USER"})
    @Override
    public void process() {
        System.out.println("Business processing ...");
    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double data = 80;
        System.out.println("Business Computing and returning result ....");
        return data;
    }
}

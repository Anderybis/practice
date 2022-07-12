package com.company.myoption.app;

import com.company.myoption.entity.Bill;
import com.company.myoption.entity.Operation;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceControl {

    @Autowired
    private DataManager dataManager;

    public void afterOperationBalance(Operation operation, boolean cancel){
        Bill bill = operation.getBill();
        if(cancel) bill.setBalance(bill.getBalance() + operation.getSum());
        else bill.setBalance(bill.getBalance() - operation.getSum());
        dataManager.save(bill);
    }


}
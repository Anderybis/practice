package com.company.myoption.screen.operation;

import io.jmix.core.DataManager;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UiController("Operation.calculate")
@UiDescriptor("operation-calculate.xml")
@LookupComponent("operationsTable")
public class OperationCalculate extends StandardLookup<Operation> {

    @Autowired
    private ComboBox<String> categoryType;
    @Autowired
    private CollectionLoader<Operation> operationsDl;

    @Subscribe
    public void onInit(InitEvent event) {
//        List<String> list = new ArrayList<>();
//        list.add();
//        categoryType.setOptionsList(list);

    }

    @Subscribe("categoryType")
    public void onCategoryTypeValueChange(HasValue.ValueChangeEvent<String> event) {
        //getScreenData().loadAll();
    }




}
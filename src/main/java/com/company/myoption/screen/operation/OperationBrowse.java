package com.company.myoption.screen.operation;

import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.Screens;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;
import io.jmix.ui.screen.LookupComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Objects;
import java.util.Set;

@UiController("Operation.browse")
@UiDescriptor("operation-browse.xml")
@LookupComponent("operationsTable")


public class OperationBrowse extends StandardLookup<Operation> {


    @Autowired
    private ScreenBuilders screenBuilders;


    @Subscribe("cancellationBtn")
    public void onCancellationBtnClick(Button.ClickEvent event) {
        OperationEdit screen = (OperationEdit) screenBuilders.editor(Operation.class, this)
                .newEntity()
                .withInitializer(operation -> {

                    operation.setBill(operationsTable.getSingleSelected().getBill());
                    operation.setType("Возврат");
                    operation.setSum(operationsTable.getSingleSelected().getSum());
                    operation.setDate(operationsTable.getSingleSelected().getDate());
                    operation.setCategory(operationsTable.getSingleSelected().getCategory());
                    operation.setComment("Возврат от " + operationsTable.getSingleSelected().getDate().toString());
                })
                .withOpenMode(OpenMode.DIALOG)
                .build();
        screen.setCancel(true);
        screen.show();
    }



    @Install(to = "operationsTable.cancellation", subject = "enabledRule")
    private boolean operationsTableCancellationEnabledRule() {
        Operation selected = operationsTable.getSingleSelected();
        if(selected == null) return false;
        return !selected.getType().equals("Возврат");
    }




    @Autowired
    private GroupTable<Operation> operationsTable;

    @Install(to = "operationsTable.cancellation", subject = "enabledRule")
    private boolean cancellationEnabledRule() {
        Set<Operation> operation = operationsTable.getSelected();
        return !operation.isEmpty();
    }



}
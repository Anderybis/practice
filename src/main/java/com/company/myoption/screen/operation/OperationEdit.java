package com.company.myoption.screen.operation;

import com.company.myoption.app.BalanceControl;
import com.company.myoption.entity.Bill;
import io.jmix.core.DataManager;
import io.jmix.core.EntityInitializer;
import io.jmix.ui.action.entitypicker.EntityLookupAction;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import javax.inject.Named;
import java.util.Date;

@UiController("Operation.edit")
@UiDescriptor("operation-edit.xml")
@EditedEntityContainer("operationDc")

public class OperationEdit extends StandardEditor<Operation> {

    private boolean cancel = false;

    public void setCancel(boolean value) {
        cancel = value;
    }

    @Autowired
    private TextField<Integer> sumField;
    @Autowired
    private EntityPicker<Bill> billField;
    @Autowired
    private TextField<String> commentField;
    @Autowired
    private DateField<Date> dateField;
    @Autowired
    private TextField<String> categoryField;
    @Autowired
    private TextField<String> typeField;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        if (cancel) {
            sumField.setEditable(false);
            billField.setEditable(false);
            commentField.setEditable(false);
            dateField.setEditable(false);
            categoryField.setEditable(false);
            typeField.setEditable(false);


        }
    }




    @Autowired
    private BalanceControl balanceControl;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        balanceControl.afterOperationBalance(getEditedEntity(),cancel);
    }





}
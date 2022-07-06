package com.company.myoption.screen.operation;

import io.jmix.ui.Dialogs;
import io.jmix.ui.action.Action;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.Null;
import java.util.Set;

@UiController("Operation.browse")
@UiDescriptor("operation-browse.xml")
@LookupComponent("operationsTable")


public class OperationBrowse extends StandardLookup<Operation> {
    @Autowired
    private Dialogs dialogs;
   @Subscribe("cancellationBtn")
    public void onCancellationBtnClick(Button.ClickEvent event) {
        dialogs.createInputDialog(this)
                .withCaption("Get values")
                .withParameters(
                        InputParameter.dateTimeParameter("deliveryTime")
                                .withCaption("Delivery Time")
                                .withRequired(true),
                        InputParameter.intParameter("sum")
                                .withCaption("Sum")
                                .withDefaultValue(1)
                )
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        String name = closeEvent.getValue("name");
                        Double quantity = closeEvent.getValue("quantity");
                        // process entered values...
                    }
                })
                .show();
    }






    @Autowired
    private GroupTable<Operation> operationsTable;

    @Install(to = "Cancellation", subject = "enabledRule")
    private boolean cancellationEnabledRule() {
        Set<Operation> operation = operationsTable.getSelected();
        return true;
    }



}
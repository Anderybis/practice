package com.company.myoption.screen.operation;

import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;
import org.springframework.context.event.EventListener;

@UiController("Operation.edit")
@UiDescriptor("operation-edit.xml")
@EditedEntityContainer("operationDc")

public class OperationEdit extends StandardEditor<Operation> {
}
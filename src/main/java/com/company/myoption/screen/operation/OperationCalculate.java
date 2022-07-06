package com.company.myoption.screen.operation;

import io.jmix.ui.screen.*;
import com.company.myoption.entity.Operation;

@UiController("Operation.calculate")
@UiDescriptor("operation-calculate.xml")
@LookupComponent("operationsTable")
public class OperationCalculate extends StandardLookup<Operation> {
}
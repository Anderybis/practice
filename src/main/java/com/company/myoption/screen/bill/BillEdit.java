package com.company.myoption.screen.bill;

import io.jmix.ui.screen.*;
import com.company.myoption.entity.Bill;
import org.springframework.context.event.EventListener;

@UiController("Bill.edit")
@UiDescriptor("bill-edit.xml")
@EditedEntityContainer("billDc")
public class BillEdit extends StandardEditor<Bill> {
}
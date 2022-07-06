package com.company.myoption.screen.bill;

import io.jmix.ui.screen.*;
import com.company.myoption.entity.Bill;

@UiController("Bill.browse")
@UiDescriptor("bill-browse.xml")
@LookupComponent("billsTable")
public class BillBrowse extends StandardLookup<Bill> {
}
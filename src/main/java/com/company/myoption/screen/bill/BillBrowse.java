package com.company.myoption.screen.bill;

import com.company.myoption.entity.Operation;
import io.jmix.core.DeletePolicy;
import io.jmix.core.EntityInitializer;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.ui.action.Action;
import io.jmix.ui.screen.*;
import com.company.myoption.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@UiController("Bill.browse")
@UiDescriptor("bill-browse.xml")
@LookupComponent("billsTable")
public class BillBrowse extends StandardLookup<Bill> {




    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "name")
    private List<Bill> bills;



}
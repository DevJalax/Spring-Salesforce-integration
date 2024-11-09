({
    fetchAccounts : function(component, event, helper) {
        let action = component.get("c.getAccounts");
        action.setCallback(this, function(response) {
            let state = response.getState();
            if (state === "SUCCESS") {
                component.set("v.accounts", response.getReturnValue());
            }
        });
        $A.enqueueAction(action);
    }
})

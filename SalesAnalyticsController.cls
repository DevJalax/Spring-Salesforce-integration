@RestResource(urlMapping='/SalesAnalytics/*')
global with sharing class SalesAnalyticsController {

    @HttpGet
    global static List<Account> getAccounts() {
        return [SELECT Id, Name, AnnualRevenue FROM Account LIMIT 10];
    }

    @HttpPost
    global static String updateAccountRevenue(String accountId, Decimal revenue) {
        Account acc = [SELECT Id, AnnualRevenue FROM Account WHERE Id = :accountId LIMIT 1];
        acc.AnnualRevenue = revenue;
        update acc;
        return 'Account revenue updated successfully';
    }
}

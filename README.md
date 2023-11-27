# Customer Support Service

This microservice exposes four APIs as follows:

1. Create Ticket  - POST /api/v1.0/support/create
2. Close Ticket - POST /api/v1.0/support/close/{id}
3. View Open Tickets GET api/v1.0/support/view/{assignee}
4. Update Account - POST /api/v1.0/support/update-account-type



##### 1. Create Tickets

Create a Ticket, sample payload:

```json

  {     "description": "Test2",
        "assignee": "john"
    }
```

##### 2. Close Tickets

Closes a ticket given it's id.


##### 3. View Open Tickets

This APIs requires the assignee name and it will return OPEN tickets for that assignee.

##### 4. Update Account Type
This API makes an HTTP call to the Account Manager Service to update an account from 
either SAVINGS account to CURRENT account or vice vesa.

Sample payload:

```json
{
    "accountNumber": "44086004870364",
    "accountType": "SAVINGS"
}
```
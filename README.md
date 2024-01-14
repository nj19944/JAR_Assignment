# Transaction API Documentation

## Overview

This API allows users to retrieve and create transactions.

## Base URL
http://localhost:4000/transaction

## Endpoints

### 1. Get Transactions

#### Request

- Method: `GET`
- Path: `/transaction`

#### Response

- Status: `200 OK`
- Body:


[
    {
        "id": "10001",
        "amount": 0.6847640167876641,
        "createdAt": "2024-01-14",
        "transactionType": "UPI",
        "currencyType": "USD"
    },
    {
        "id": "10002",
        "amount": 156.677,
        "createdAt": "2024-01-14",
        "transactionType": "CREDIT_CARD",
        "currencyType": "USD"
    },
    {
        "id": "10004",
        "amount": 6.725697876974901,
        "createdAt": "2024-01-14",
        "transactionType": "UPI",
        "currencyType": "USD"
    }
]

# Note: The get transaction response will be used for reporting purpose and all the amount will be in USD
# If the currencyType is INR, we will be using the conversion rate given in the API: https://api.fxratesapi.com/latest.

### 2. Create Transaction
#   Request
#   Method: POST
#   Path: /transaction
#   Body:

#   {
   "id": "46e787c8-06c8-42ba-974e-78a699fd932f",
   "amount": 65656.0,
   "createdAt": "2024-01-14T12:08:50.310+00:00",
   "transactionType": "CASH",
   "currencyType": "INR"
   }
 
3. H2 database is being used to store the information of the transaction and a initial data.sql file will run 
   on starting the server which store dummy information in the database for testing of the api.




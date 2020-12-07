Drugstore microservices application

Report on Drugstore microservices

Drugstore microservivice is designed to build a drugstore system with users buy medicine, but this process has to be checked several times
and check for all dependencies like balance or prescription.
1. Customer
Customer has data about users their name balance and prescription and only doctor can give him prescription to buy medicine

2. Doctor
Doctor has data about doctors their name and this microservice will be connected with Customer to gain access to buy medicine

3.Customer-Doctor 
CustDoc contains customers and their doctors and in this microservice doctors can give prescription to individual customer

4.medicine
Medicine has info of medicine and their parameters like quantity or requirement of prescription

5.Cashier
Cashier (or Customer-Medicine) is a main idea of this system, to let customer buy medicine and check all data and give response.

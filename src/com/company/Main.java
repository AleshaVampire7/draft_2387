package com.company;

import DatabaseRepository.DatabaseRepository;
import com.company.DatabaseController.DatabaseController;
import com.company.Validator.Validator;
import com.company.data.DBManager;
import com.company.entities.Employee;

public class Main {

    public static void main(String[] args) {

        DBManager dbManager=new DBManager();
        DatabaseRepository databaseRepository=new DatabaseRepository(dbManager);
        DatabaseController databaseController=new DatabaseController(databaseRepository);
        MyApplication myApplication=new MyApplication(databaseController);




        myApplication.start();

    }
}

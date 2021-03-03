package com.company.DatabaseController;

import DatabaseRepository.DatabaseRepository;
import com.company.entities.Employee;

import java.time.LocalDate;

public class DatabaseController {
private DatabaseRepository databaseRepository;
public DatabaseController(DatabaseRepository databaseRepository){
    this.databaseRepository=databaseRepository;

}
    public String signIn(String name,int age,int status1,String accname,String password){
        LocalDate dateofregistration = LocalDate.now();
        String status;
        if (status1==1){
            status="Jailed";
        }else{
             status="Freedom";
        }

        boolean response=databaseRepository.signIn(new Employee(name,age,dateofregistration,status,accname,password));

        if (response){
            return  "You've been succesfully registered";
        }else {
            return "Technical issues, try again!";

        }

    }
    public String logIn(String accname){
    String status=null;

    status=databaseRepository.logIn(accname);


    return  status;
    }
    public String getEmployeeById(int id) {
        String result = databaseRepository.getEmployeeById(id).toString();

        return result;
    }
}

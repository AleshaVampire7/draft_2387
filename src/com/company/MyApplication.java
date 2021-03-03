package com.company;

import com.company.DatabaseController.DatabaseController;
import com.company.Validator.Validator;

import java.util.Scanner;


public class MyApplication {

    protected int option;
    public Scanner sc;
    public Scanner scanner;

    Validator validator=new Validator();


    private DatabaseController  databaseController;
    public MyApplication(DatabaseController databaseController){
        this.databaseController=databaseController;

    }
    public  void start(){

        sc=new Scanner(System.in);
        scanner=new Scanner(System.in);

       while(true){
           System.out.println("Enter the otion that you need!");
           System.out.println("1)Sign In \n2)Log in \n3)Quit");
           option=sc.nextInt();
           if (option==1){
               signInMenu();

       } else if (option==2){
               logInMenu();
       } else if (option==3) break;
           else if(option==4){

       } else {
           System.out.println("We do not have such option! Please enter again");
       }
           System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
       }


    }
    public void signInMenu(){

        boolean checkpassword=false;
        String password="000";
        System.out.println("Write your name");
        String name = sc.next();
        System.out.println("Write your age");
        int age = sc.nextInt();
        System.out.println("Are you married? \n1)true \n2)false");
        int status=sc.nextInt();
        System.out.println("Write your account name");
        String accname=sc.next();




        System.out.println("Enter your password for your account");
        System.out.println("Password must to contain at least \n1 uppercase letter, \n1 lowercase letter, \n1 digit, \n1 special symbol(@,$) and length more or equal to 8.");
        password=scanner.nextLine();

        validator.checkPassword(password);





        String result=databaseController.signIn(name,age,status,accname,password);


        System.out.println(result);



    }
    public void logInMenu (){
        String accname=null;
        boolean checkpassword;
        String password;
        checkpassword=false;
        String realPassword=null;

        System.out.println("Enter your account name");
        accname=sc.nextLine();
        realPassword=databaseController.logIn(accname);

        while (realPassword==null){
            accname=sc.nextLine();
            realPassword=databaseController.logIn(accname);


            if (realPassword!=null){
                break;
            }else {
                System.out.println("Wrong account name, Enter again");
            }
        }


        System.out.println("Enter password");
        password=sc.nextLine();

        while(checkpassword==false){

            checkpassword=validator.checkPasswordLogIn(password,realPassword);


            if (checkpassword==true){
                break;
            }else{
                System.out.println("Wrong password! ENTER AGAIN");
                password=sc.nextLine();
            }

        }
        System.out.println("You entered!");
        int i;
        while (true){
            System.out.println("Enter option");
            System.out.println("1)Search by id(only public information) \n0)quit by entering 0");
            i=scanner.nextInt();
            String response=null;

            if (i==0){break;}else if(i==1) {
                while (response==null){
                    System.out.println("Enter id");
                    int option2=sc.nextInt();
                    response=databaseController.getEmployeeById(option2);
                    if (response!=null){break;}
                    System.out.println("Enter again!");

                }
                System.out.println(response);
            }

        }
    }


}

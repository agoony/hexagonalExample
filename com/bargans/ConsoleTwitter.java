package com.bargans;

import com.bargans.dao.PostDaoMock;
import com.bargans.inputports.ApiInterface;
import com.bargans.inputports.cliPort;
import com.bargans.services.postDaoInterface;
import com.bargans.services.postService;

import java.util.Scanner;

import static java.lang.System.exit;

public class ConsoleTwitter {
    public static void printStart(String[] options){
        for (String option : options){
            System.out.println(option);
        }

    }
    private static ApiInterface service;
    private static String[] options = {"ConsoleTwitter version 1.0",
            "copyright 2022 by jordi bargans",
            "usage: <username> <command> <targetuser>",
            "commands: follows wall read subscribe",
    };
    public static void main(String[] args) {

        printStart(options);
        //setting the ports 
        postDaoInterface postDaoInterface = new PostDaoMock();
        postService postService = new postService(postDaoInterface);
        cliPort service = new cliPort(postService);

        Scanner scanner = new Scanner(System.in);        String command  = "";
        while (!command.equals("exit")){
            System.out.print(">");
            try {
                command = scanner.nextLine();
                String[] subcomands = command.split(" ");

                String myCom = subcomands.length >1 ?subcomands[1] : "";
                switch (myCom){
                    case "->":
                        service.posting(subcomands[0],command.substring(command.indexOf("->")+3));
                    break;
                    case "wall": service.wall(subcomands[0]);break;
                    case "follows":  service.following(subcomands[0],command.substring(command.indexOf("->")+3));break;
                    default: service.reading(subcomands[0]);break;

                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    // Options
    private static void sum(int number1, int number2) {
        int result = number1 + number2;
        System.out.println("The sum is " + result);
    }
    private static void multiply(int number1, int number2) {
        int result = number1 * number2;
        System.out.println("The result is " + result);
    }

}
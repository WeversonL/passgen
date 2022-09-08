package com.security.passgen;

import com.security.passgen.model.Account;
import com.security.passgen.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

import static com.security.passgen.utils.Statics.DASHED;
import static com.security.passgen.utils.Utilities.clearScreen;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@SpringBootApplication
@RequiredArgsConstructor
public class PassgenApplication implements CommandLineRunner {

    private final Scanner sc = new Scanner(System.in);
    private final AccountServiceImpl accountService;

    public static void main(String[] args) {
        SpringApplication.run(PassgenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        boolean loop = true;
        clearScreen();

        while (loop) {
            System.out.println(DASHED);
            System.out.println("1. Create new password");
            System.out.println("2. Save exists account");
            System.out.println("3. Get your saved accounts");
            System.out.println("4. Get your saved account by service");
            System.out.println("5. Exit");

            System.out.print("\nYour choise: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    clearScreen();
                    System.out.print("Enter the password length: ");
                    String length = sc.nextLine();
                    String password = accountService.generatePassword(length);

                    clearScreen();
                    System.out.println(DASHED);
                    System.out.println(password);
                    System.out.println(DASHED);

                    System.out.print("Do you want to save the password? [Y/n]: ");
                    String saveOption = sc.nextLine();

                    if (isBlank(saveOption) || (isNotBlank(saveOption) && saveOption.toUpperCase(Locale.ROOT).charAt(0) == 'Y')) {
                        clearScreen();
                        Account account = getAccount(password);
                        accountService.saveAccount(account);
                    }

                    break;

                case "2":
                    clearScreen();
                    Account account = getAccount();
                    accountService.saveAccount(account);
                    break;

                case "3":
                    clearScreen();
                    accountService.getAccounts();
                    break;

                case "4":
                    clearScreen();
                    System.out.print("Enter the service to search: ");
                    String serviceName = sc.nextLine();
                    accountService.getAccountByService(serviceName);
                    break;

                default:
                    loop = false;
                    break;
            }
        }
    }

    private Account getAccount() {
        System.out.print("Enter the service name: ");
        String serviceName = sc.nextLine();

        System.out.print("Enter the service URL (Optional): ");
        String serviceURL = sc.nextLine();

        System.out.print("Enter the username: ");
        String userName = sc.nextLine();

        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        return new Account(serviceName, serviceURL, userName, password);
    }

    private Account getAccount(String password) {
        System.out.print("Enter the service name: ");
        String serviceName = sc.nextLine();

        System.out.print("Enter the service URL (Optional): ");
        String serviceURL = sc.nextLine();

        System.out.print("Enter the username: ");
        String userName = sc.nextLine();

        return new Account(serviceName, serviceURL, userName, password);
    }

}

package org.example.virtualkey.screens;

import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome to VirtualKey!";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println();
		System.out.println("|*************************************|");
		System.out.println("|****** Welcome TO LockedMe.com ******|");
		System.out.println("|*************************************|");
		System.out.println("|-------------------------------------|");
		System.out.println("|------------Developed By-------------|");
		System.out.println("|-------------------------------------|");
		System.out.println("|--------------Sunita-----------------|");
		System.out.println("|*************************************|");
		System.out.println();
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {
        System.out.println("List of Files: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}

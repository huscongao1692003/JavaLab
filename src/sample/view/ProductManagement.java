package sample.view;

import sample.controllers.ProductList;
import sample.controllers.Menu;
import sample.utils.Tools;
import sample.dtos.CdInformation;

public class ProductManagement {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem("1. Print ");
        menu.addItem("2. Create a Product");
        menu.addItem("3. Check exits Product");
        menu.addItem("4. Search Product’ information by Name ");
        menu.addItem("5. Update Product");
        menu.addItem("6. Save Products to file");
        menu.addItem("7. Print list Products from the file.");
        menu.addItem("Others. Quit");
        ProductList productMap = new ProductList();
        int choice;
        do {
            menu.showMenu();
            choice = Tools.getInt("Select your choice: ", -100, 100);

            switch (choice) {
                case 1:
                     productMap.showInfor();

                    String choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                    if ("Y".equalsIgnoreCase(choiceBack)) {
                        break;
                    } else if ("N".equalsIgnoreCase(choiceBack)) {
                        choice = 7;
                    }
                    break;

                 
                case 2:
                   if (productMap.add()) {
                        System.out.println("Successful!");
                        choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                        if ("Y".equalsIgnoreCase(choiceBack)) {
                            break;
                        } else if ("N".equalsIgnoreCase(choiceBack)) {
                            choice = 7;
                        }
                    } else {
                        System.out.println("Unsuceessful!");
                    }
                    break;

                case 3:
            
                    
                    break;

                case 4:
                    String titles = Tools.getString("Enter title to search", false);
                    CdInformation temp = productMap.searchId(titles);
                    if (temp != null) {
                        temp.showProfile();
                        choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                        if ("Y".equalsIgnoreCase(choiceBack)) {
                            break;
                        } else if ("N".equalsIgnoreCase(choiceBack)) {
                            choice = 7;
                            break;
                        }
                    } else {
                        System.out.println("Not found anothers!");
                         choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                        if ("Y".equalsIgnoreCase(choiceBack)) {
                            break;
                        } else if ("N".equalsIgnoreCase(choiceBack)) {
                            choice = 7;

                        }
                    }
                    break;
                   
                case 5:
                     int updateChoice = Tools.getInt("Select your choice(Update-Delete): ", 1, 2);
                    if (updateChoice == 1) {

                        if (productMap.update()) {
                            System.out.println("Successful!");
                            choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                            if ("Y".equalsIgnoreCase(choiceBack)) {
                                break;
                            } else if ("N".equalsIgnoreCase(choiceBack)) {
                                choice = 7;
                                break;
                            }
                        } else {
                            System.out.println("Unsuceessful!");

                        }
                        break;
                    } else if (updateChoice == 2) {

                        if (productMap.delete()) {
                            System.out.println("Successful!");
                            choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                            if ("Y".equalsIgnoreCase(choiceBack)) {
                                break;
                            } else if ("N".equalsIgnoreCase(choiceBack)) {
                                choice = 7;
                                break;
                            }

                        } else {
                            System.out.println("Unsuceessful!");

                        }

                    }
                    
                case 6:
                    productMap.saveToFile();
                    choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                    if ("Y".equalsIgnoreCase(choiceBack)) {
                        break;
                    } else if ("N".equalsIgnoreCase(choiceBack)) {
                        choice = 7;
                    }
                    break;
                    
                case 7:
                    productMap.readFromFile();
                    choiceBack = Tools.getString("Do u want to go back to menu?(Y/N)", false);
                    if ("Y".equalsIgnoreCase(choiceBack)) {
                        break;
                    } else if ("N".equalsIgnoreCase(choiceBack)) {
                        choice = 7;
                    }
                    break;
                     
            }

        } while (choice > 0 && choice < 8);
    }

}

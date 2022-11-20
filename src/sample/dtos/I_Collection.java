package sample.controllers;

import sample.dtos.CdInformation;

public interface I_Collection {

    public boolean add();

    public boolean delete();

    public boolean update();

    public CdInformation search(String id);

    public CdInformation searchId(String title);
    
    public CdInformation searchName(String title);
            
    public void showInfor();

    public void saveToFile();
    
    public void readFromFile();
    
    public void checkProduct();

   
}

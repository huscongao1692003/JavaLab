package sample.controllers;


import java.util.HashMap;
import sample.dtos.CdInformation;
import sample.dtos.InfomationSub;
import sample.utils.Tools;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class ProductList extends HashMap<String, CdInformation> implements I_Collection {

    @Override
    public boolean add() {
        int count = 0;


        boolean result = false;
        CdInformation tempPro = null;
        int type = candidateType();
        String id = Tools.getString("Enter id: ", false);
        if (this.search(id) != null) {
            System.out.println("ID has exist!");
            return false;
        }
       

    
    

        tempPro = new InfomationSub(type, id);
        if (tempPro.setInformation()) {
            this.put(id, tempPro);
            result = true;

        }
        for (String element : this.keySet()) {
            count++;
           

        }
        System.out.println("number of Products: " + count);
        return result;
    }

    @Override
    public boolean delete() {
        boolean result = false;
        String id = Tools.getString("Enter CD id: ", false);
        CdInformation tempCand = this.search(id);
        if (tempCand == null) {
            System.out.println("Not found!");
        } else {
            String choice = Tools.getString("Are you sure?(Y/N)", false);
            if ("N".equalsIgnoreCase(choice)) {
                System.out.println("Continue!");
            } else if ("Y".equalsIgnoreCase(choice)) {
                this.remove(id);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update() {
        boolean result = false;
        String id = Tools.getString("Enter CD id: ", false);
        CdInformation tempCand = search(id);
        if (tempCand == null) {
            System.out.println("Not found!");
        } else {
            tempCand.updateInformation();

            result = true;
        }
        return result;
    }

    @Override
    public CdInformation search(String id) {
        CdInformation tempCan = null;
        if (this.containsKey(id)) {
            tempCan = this.get(id);
        }
        return tempCan;
    }

    public CdInformation searchId(String title) {

        for (String e : this.keySet()) {
            if (get(e).getTitle().contains(title)) {
                get(e).showProfile();
            }
        }
        return null;
    }
    public CdInformation searchName(String title) {
           CdInformation tempCand = null;
        for (String e : this.keySet()) {
            if (get(e).getTitle().contains(title)) {
               
            }
        }
        return tempCand;
    }

    public int candidateType() {
        int choice = 1;
        return choice;

    }

    @Override
    public void showInfor() {
        for (String element : this.keySet()) {
            get(element).showProfile();

        }
    }

    @Override
    public void saveToFile() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Product.dat"));
            oos.writeObject(this);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void checkProduct(){
        
    }

    @Override
    public void readFromFile() {
        try {
            //read from file.
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Product.dat"));
            HashMap<String, CdInformation> ia = (HashMap<String, CdInformation>) (ois.readObject());
            this.putAll(ia);
            this.showInfor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

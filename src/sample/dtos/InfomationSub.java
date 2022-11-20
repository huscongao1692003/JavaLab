package sample.dtos;

import sample.utils.Tools;


public class InfomationSub extends CdInformation  {
    
    private int price;
    
    
    public InfomationSub(int type, String id) {
        super(type, id);
    }
    
    public InfomationSub(String id, String title, String address, int type, int price,int cdType) {
        super(id, title, address, type,cdType);
        this.price = price;
        
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public boolean setInformation() {
        super.setInformation();
        price = Tools.getInt("UnitPrice: ", 0, 10000);
        return true;
    }
    
    @Override
    public boolean updateInformation() {
        super.updateInformation();
        String newPrice = Tools.getString("UnitPrice: ", true);
        if (newPrice != null&& !(newPrice.matches("\\s*"))) {
            setPrice(Integer.parseInt(newPrice));
        }else{
//            return false;
        }
        
        return true;
        
    }
    
    @Override
    public void showProfile() {
        System.out.printf("ID: %-5s|Status: %-15s|Quantity: %-15s|ProductName: %-15s|UnitPrice: %-5s|\n", getId(),getCollection(), getCdType(), getTitle(), this.getPrice());
        
    }
    
    
}

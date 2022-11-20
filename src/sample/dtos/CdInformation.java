package sample.dtos;

import sample.utils.Tools;
import java.io.Serializable;

public abstract class CdInformation implements Comparable<CdInformation>,Serializable {

    private String id;
    private String title;
    private String collection;
    private int type;
    private int cdType;

    

    public CdInformation(int type, String id) {
        this.type = type;
        this.id = id;
    }
    public CdInformation(String title) {
        
        this.title = title;
    }

    public CdInformation(String id, String title, String collection, int type, int cdType) {
        this.id = id;
        this.title = title;
        this.collection = collection;
        this.type = type;
        this.cdType = cdType;
    }
   

    public int getCdType() {
        return cdType;
    }

    public void setCdType(int cdType) {
        this.cdType = cdType;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public int getType() {
        return type;
    }

    public boolean setInformation() {
        title = Tools.getString("ProductName: ", false);
        cdType = Tools.getInt("Quantity: ", 0, 1000);
        collection = Tools.getString("Status:(Available or Not Available)-A/NA: ", false);
        if (title != null&& !(title.matches("\\s*"))) {
             setTitle(title);
//            if(title == getTitle()){
//                System.out.println("ProductName has exits");
//            }else{
//                setTitle(title);
//            }
        }
        
        if (collection != null&& !(collection.matches("\\s*"))&&collection!=("\\d+")) {
            if ("A".equalsIgnoreCase(collection)) {
                            setCollection("Available");
                        } else if ("NA".equalsIgnoreCase(collection)) {
                            setCollection("Not Available");
                        }
            
        }else{
            return false;
//         
        }
        return true;
    }

    public boolean updateInformation() {
        String newTitle = Tools.getString("ProductName: ", true);
        String newCdType = Tools.getString("Quantity: ", true);
        String newCollection = Tools.getString("Status:(Available or Not Available)-A/NA: ", true);
        if (newTitle != null&& !(newTitle.matches("\\s*"))) {
            setTitle(newTitle);
        }
        if (newCdType != null&& !(newCdType.matches("\\s*"))&&newCdType!=("\\d+")) {
            setTitle(newCdType);
        }else{
//           
        }
        if (newCollection != null&& !(newCollection.matches("\\s*"))&&newCollection!=("\\d+")) {
            if ("A".equalsIgnoreCase(collection)) {
                            setCollection("Available");
                        } else if ("NA".equalsIgnoreCase(collection)) {
                            setCollection("Not Available");
                        }
            
        }else{
            return false;
//         
        }
        return true;

    }

    public abstract void showProfile();
   

    @Override
    public String toString() {
        return " Products : {" + "id=" + id + ", ProductName=" + title + ", Status=" + collection + ",Price=" + type + ",  Quantity=" + cdType + "}"+"\n";
    }

    
    @Override
    public int compareTo(CdInformation o) {
        return o.title.compareTo(this.title);
    }

}

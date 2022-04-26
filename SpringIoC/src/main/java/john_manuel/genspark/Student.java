package john_manuel.genspark;

import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    public Student(int newId, String newName, List<Phone> newPh, Address newAddress){
        id = newId;
        name = newName;
        ph = newPh;
        add = newAddress;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public List<Phone> getPh() {return ph;}
    public Address getAdd(){return add;}

    public void setId(int newId){id = newId;}
    public void setName(String newName){name = newName;}
    public void setPh(List<Phone> newPh){ph = newPh;}
    public void setAdd(Address newAdd){add = newAdd;}

    @Override
    public String toString(){
        return "Student: " + id
                + " " + name
                + " " + ph
                + " " + add;
    }
}

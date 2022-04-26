package john_manuel.genspark;

public class Phone {

    private String mob;

    public Phone(String mob){
        this.mob = mob;
    }

    public String getMob(){return mob;}

    public void setMob(String newMob){mob = newMob;}

    @Override
    public String toString(){
        return "Phone: " + mob;
    }
}

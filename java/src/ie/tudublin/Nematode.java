package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

//Class holding the nematode data

public class Nematode {

    private String name;
    private Integer length;
    private Integer limbs;
    private String gender;
    private Integer eyes;
    private float tempy;

    public Nematode(TableRow r) 
    {
        this(r.getString("name"), 
        r.getInt("length"), 
        r.getInt("limbs"), 
        r.getString("gender"), 
        r.getInt("eyes"));
    }
    

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(String name, Integer length, Integer limbs, String gender, Integer eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getLength() {
        return length;
    }


    public void setLength(Integer length) {
        this.length = length;
    }


    public Integer isLimbs() {
        return limbs;
    }


    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public Integer isEyes() {
        return eyes;
    }


    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }
  
    public void render(NematodeVisualiser wormies){
        
        float y = wormies.height / 4;
        float x = wormies.width / 2;

        //Displays name of nematoad
        wormies.text(name, x-10, y - 100);


        wormies.stroke(255);
        wormies.noFill();

        //Makes the body of the dude
        for (int i = 0; i < length; i++)
        {
            tempy = y + (i*40);
            wormies.circle(x, tempy, 40);
            
        }

    }


    
  

}

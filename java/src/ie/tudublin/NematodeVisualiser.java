package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematode = new ArrayList<Nematode>();

	 int currentWorm = 0;

	void printNematodes(){
		for(Nematode n:nematode)
        {
            System.out.println(n);
        }
	}

	
    public void keyPressed()
    {
        if (keyCode == LEFT)
        {
			currentWorm = currentWorm - 1;
			if( currentWorm < 0 )
			{
				currentWorm = nematode.size() -1;
			}
        }

		if (keyCode == RIGHT)
		{
			currentWorm = currentWorm + 1;
			if( currentWorm > nematode.size()-1 )
			{
				currentWorm = 0;
			}
		}
    }


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();
		printNematodes();	
		drawNematodes();		
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows()){
			Nematode n = new Nematode(r);
			nematode.add(n);
		}
	}


	public void drawNematodes()
	{	
		background(0);
		nematode.get(currentWorm).render(this);
	}

	public void draw() {
        background(0);
        drawNematodes();
    }


}

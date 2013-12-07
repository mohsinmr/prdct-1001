package uz.main.hashchat;

import java.util.ArrayList;

public class Model {
	public ArrayList<Item> Items;
	
	public Model()
	{
		 Items = new ArrayList<Item>();
	}

    public void LoadModel() {

       Item itm = new Item();
       itm.setIconFile("ic_action_alarm_2.png");
       itm.setName("Alarm");
       itm.setDesc("Alaram clock picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_calculator.png");
       itm.setName("Calculator");
       itm.setDesc("Calculator  picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_google_play.png");
       itm.setName("Play");
       itm.setDesc("Play sign for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_line_chart.png");
       itm.setName("Line Chart");
       itm.setDesc("Line Chart picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_location_2.png");
       itm.setName("Location");
       itm.setDesc("Location picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_news.png");
       itm.setName("News");
       itm.setDesc("News picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_stamp.png");
       itm.setName("Stamp");
       itm.setDesc("Stamp picture for testing");
       Items.add(itm);
      
       itm = new Item();
       itm.setIconFile("ic_action_alarm_2.png");
       itm.setName("Alarm");
       itm.setDesc("Alaram clock picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_calculator.png");
       itm.setName("Calculator");
       itm.setDesc("Calculator  picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_google_play.png");
       itm.setName("Play");
       itm.setDesc("Play sign for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_line_chart.png");
       itm.setName("Line Chart");
       itm.setDesc("Line Chart picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_location_2.png");
       itm.setName("Location");
       itm.setDesc("Location picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_news.png");
       itm.setName("News");
       itm.setDesc("News picture for testing");
       Items.add(itm);
       
       itm = new Item();
       itm.setIconFile("ic_action_stamp.png");
       itm.setName("Stamp");
       itm.setDesc("Stamp picture for testing");
       Items.add(itm);        
       

    }
    
    public void LoadMenuGridModel() {

        Item itm = new Item();
        itm.setIconFile("ic_chat.png");
        itm.setName("Chat");
        itm.setDesc("Tap to chat !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_msg.png");
        itm.setName("Message");
        itm.setDesc("Tap to message !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_voice.png");
        itm.setName("Voice");
        itm.setDesc("Tap to send voice message !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_tag.png");
        itm.setName("Tag");
        itm.setDesc("Tag contact !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_search.png");
        itm.setName("Search");
        itm.setDesc("Search friends !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_favourite.png");
        itm.setName("Favourite");
        itm.setDesc("Tap to set favourite contact !");
        Items.add(itm);
        
        itm = new Item();
        itm.setIconFile("ic_settings.png");
        itm.setName("Settings");
        itm.setDesc("Settings !");
        Items.add(itm);
       
                

     }

    public  Item GetbyId(int id){

    	return Items.get(id);
     

    }

	

}

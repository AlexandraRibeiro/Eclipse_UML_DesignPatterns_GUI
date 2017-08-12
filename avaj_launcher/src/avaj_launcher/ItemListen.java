package avaj_launcher;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListen implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getStateChange() == ItemEvent.SELECTED
                ? "SELECTED" : "DESELECTED");
	}

	
	
}

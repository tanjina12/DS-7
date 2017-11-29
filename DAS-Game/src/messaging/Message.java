package messaging;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by giogge on 28/11/2017.
 */

/**
 * @author : tanjina
 * Creation Date : 28-11-17
 */
public class Message implements Serializable {

    HashMap<String, Serializable> messageMapping;
    
    public Message(){	
    	messageMapping = new HashMap<String, Serializable>();
    }
    
    public static Message deserialize(byte [] input){
		return (Message)(SerializationUtils.deserialize(input));
	}    

    public void put(String key, Serializable val) {
        messageMapping.put(key, val);
    }

    public Serializable get(String key) {
        return messageMapping.get(key);
    }
    
    public byte[] serialize() {
		return SerializationUtils.serialize(this);
	}

    public void debugPrintMessage() {
    	System.out.println("Printing message content:");
    			
    	for (Map.Entry<String, Serializable> entry : messageMapping.entrySet()) {
    	    System.out.println(" > " + entry.getKey()+" : "+entry.getValue());
    	}
    	
    }
}

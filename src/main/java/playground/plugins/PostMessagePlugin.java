package playground.plugins;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import playground.logic.ActivityEntity;

@Component
public class PostMessagePlugin implements Plugin {
	
	private ObjectMapper jackson;
	
	public PostMessagePlugin() {
		
	}
	
	@PostConstruct
	public void init() {
		jackson = new ObjectMapper();
	}
	
	@Override
	public Object execute(ActivityEntity command) throws Exception {
		MovieMessage rv = jackson.readValue(command.getAttributesJson(), MovieMessage.class);
		return rv;
	}
}
package com.atps.usermanagement.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data //to get setters and getters
@Component //to get scanned by the @ComponentScan
@EnableConfigurationProperties   //enabling configuration for propertiers/yml  file
/**
 * the value of prefix should be same as the starting tag of the messages
 * @author user
 *
 */
@ConfigurationProperties(prefix="formapp")  //loading the succes messages from yml file

/**
 * this class is used to read the messages from the properties file
 * in this proj it is acting as the CACHE
 */
public class AppProperties {
	
/**
 * this map collection will store the messages in key value format from the yml file
 */
	private Map<String,String> messages=new HashMap();

}

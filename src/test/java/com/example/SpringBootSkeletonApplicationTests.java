package com.example;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.example.dto.User;



public class SpringBootSkeletonApplicationTests {

	public static final String REST_SERVICE_URI = "http://localhost:8080/api/";
	
	/* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
          
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/users/", List.class);
          
        if (usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("username")+", Password="+map.get("password"));;
            }
        } else{
            System.out.println("No user exist----------");
        }
    }
    
    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/users/1", User.class);
        System.out.println(user);
    }
    
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setUsername("TylerTestingAccout");
        user.setPassword("ThisIsMyTestingPassword");
        restTemplate.postForLocation(REST_SERVICE_URI+"/users/", user, User.class);
        System.out.println(user);
    }
  
    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User();
        user.setId(1L);
        user.setPassword("TylerUpdateThisPassword");
        restTemplate.put(REST_SERVICE_URI+"/users/1", user);
        System.out.println(user);
    }
  
    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/users/40");
    }
    
    public static void main(String args[]){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
    }

}

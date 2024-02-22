package main.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CredentialsController{
    
    public boolean checkCredentials(String mail, String password, String name) {

        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("src\\data\\Datos.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray array = (JSONArray) jsonObject.get("Datos");

            for(int i = 0; i < array.size();i++){
                JSONObject jsonObject2 = (JSONObject) array.get(i);
                if (jsonObject2.get("mail").equals(mail) && jsonObject2.get("password").equals(password)) {
                    name = (String) jsonObject2.get("name");
                    return true;
                }
            }

        }catch(FileNotFoundException e){ }
        catch(IOException e){}
        catch(ParseException e){}
        return false;
    }    
}
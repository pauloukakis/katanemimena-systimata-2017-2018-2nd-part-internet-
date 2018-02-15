package gr.hua.dit.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.CarList;


@Controller
@RequestMapping("/car")
public class CarController {
	
	// inject the customer service
	@Autowired
	
	
	@GetMapping("/carlist")
	public String listCars(Model model) {
		ArrayList<Car> cars= new ArrayList<Car>();
		
		String inline = "";
		
		try
		{
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
			//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			//Iterating condition to if response code is not 200 then throw a runtime exception
			//else continue the actual process of getting the JSON data
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format"); 
				System.out.println(inline);
				//Close the stream when reading the data has been finished
				sc.close();
			}
			
			//JSONParser reads the data from string object and break each data into key value pairs
			JSONParser parse = new JSONParser();
			//Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject)parse.parse(inline);
			//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("cars");
			//Get data for Results array
			
			for(int i=0;i<jsonarr_1.size();i++)
			{
				//Store the JSON objects in an array
				//Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				cars.get(i).setCarModel((String) jsonobj_1.get("carModel"));
				cars.get(i).setId(Integer.parseInt((String) jsonobj_1.get("id")));
				cars.get(i).setCarModel((String) jsonobj_1.get("carModel"));
				cars.get(i).setOwnerName((String) jsonobj_1.get("ownerName"));
				cars.get(i).setLastDate((String) jsonobj_1.get("lastDate"));
				cars.get(i).setCarType((String) jsonobj_1.get("carType"));
				cars.get(i).setKteoPrice(Integer.parseInt((String) jsonobj_1.get("kteoPrice")));
				
				
			}
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// get customers from the service
		
		
		// add the customers to the model
		model.addAttribute("cars",cars);
		
		// add page title
		model.addAttribute("pageTitle", "List Cars");
		return "list-cars";
	}
	
	/*@GetMapping("/{id}")
	public String getCar(Model model, @PathVariable("id") int id) {
		// get the car
		Car car = carService.getCar(id);
		
		model.addAttribute("car", car);
		
		return "car-form";
	}
	*/
	

}

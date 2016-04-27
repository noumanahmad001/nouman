package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;


@RestController
@RequestMapping("/api/menu")
public class MenuController {

		@Autowired
		SalonMenuRepository salonMenuRepo;
	 	@RequestMapping("/add")
	    public String add(@RequestParam(value="key") String key,@RequestParam(value="name") String name,@RequestParam(value="price") String price,@RequestParam(value="description") String description,@RequestParam(value="type") String type) {
	          try{
	        	  salonMenuRepo.save(new SalonMenu(name,Integer.parseInt(type),price,description));
	          } catch (Exception e)
	          {
	        	  return returnJsonObject("0", e.getMessage());
	          }
	          return returnJsonObject("1", "success");
	 	}

	 	@RequestMapping("/get_all")
	    public String getAll(@RequestParam(value="key") String key) {
	 		List<SalonMenu> arrSaloonMenu ;  
	 		try{
	        	  arrSaloonMenu = (List<SalonMenu>) salonMenuRepo.findAll();
	          } catch (Exception e)
	          {
	        	  return returnJsonObject("0", e.getMessage());
	          }
	 		  
	          return returnJsonObject("1", new com.amazonaws.util.json.JSONArray(arrSaloonMenu));
	 	}
	 	
	 	@RequestMapping("/get_items_by_type")
	    public String getAllByType(@RequestParam(value="key") String key,@RequestParam(value="type") String type) {
	 		List<SalonMenu> arrSaloonMenu ;  
	 		try{
	        	  arrSaloonMenu = salonMenuRepo.findByType(Integer.parseInt(type));
	          } catch (Exception e)
	          {
	        	  return returnJsonObject("0", e.getMessage());
	          }
	          return returnJsonObject("1", new com.amazonaws.util.json.JSONArray(arrSaloonMenu));
	 	}
	 	
	 	
		@SuppressWarnings("unchecked")
		private String returnJsonObject(String respCode,String message){
	 		JSONObject jObj = new JSONObject();
	 		try {
				jObj.put("code", respCode);
				jObj.put("resp", message);
	 		} catch (JSONException e) {
	 			return e.getMessage();
			}
	 	
	 		return jObj.toString();
	 	}
		
		@SuppressWarnings("unchecked")
		private String returnJsonObject(String respCode,com.amazonaws.util.json.JSONArray jArray){
	 		JSONObject jObj = new JSONObject();
	 		try {
				jObj.put("code", respCode);
				jObj.put("resp", jArray);
			} catch (JSONException e) {
				return e.getMessage();
			}
	 		
	 		return jObj.toString();
	 	}
}

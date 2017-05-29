package net.sanjeet.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import net.sanjeet.spring.dao.CustomerDAO;
import net.sanjeet.spring.model.Customer;

@RestController
public class CustomerRestController {


	@Autowired
	private CustomerDAO customerDAO;


	@SuppressWarnings("rawtypes")
	@GetMapping("/customers")
	public List getCustomers() {
		return customerDAO.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}

	/*@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/customerCreate")
	public ResponseEntity createCustomer() {
		String  jsonString="{\"id\":11010,\"firstName\":\"sanjeet\",\"lastName\":\"sanju\",\"email\":\"djohn@gmail.com\",\"mobile\":\"121-232-3435\"}";
		Gson gsonObj = new Gson();
		Customer customer = gsonObj.fromJson(jsonString, Customer.class);
		customerDAO.create(customer);
		return new ResponseEntity(customer, HttpStatus.OK);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/customersUpdate/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id) {
		String  jsonString="{\"id\":1111,\"firstName\":\"sanjeet\",\"lastName\":\"sanju\",\"email\":\"djohn@gmail.com\",\"mobile\":\"121-232-3435\"}";
		Gson gsonObj = new Gson();
		Customer customer1 = gsonObj.fromJson(jsonString, Customer.class);
		Customer customer = customerDAO.update(id, customer1);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}
	@SuppressWarnings({ })
	@GetMapping(value = "/customerCreateDOB")
	public @ResponseBody Customer createCustomerWithDOB() throws JSONException, ParseException {
		String  jsonString="{\"id\":11010,\"firstName\":\"sanjeet\",\"lastName\":\"sanju\",\"email\":\"djohn@gmail.com\",\"mobile\":\"121-232-3435\",\"dateOfBirth\":\"7-Jun-2013\"}";
		JSONObject jsonObj=new JSONObject(jsonString);
		Customer customer=new Customer();
		customer.setId(jsonObj.getLong("id"));
		customer.setFirstName(jsonObj.getString("firstName"));
		customer.setLastName(jsonObj.getString("lastName"));
		customer.setEmail(jsonObj.getString("email"));
		customer.setMobile(jsonObj.getString("mobile"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		customer.setDateOfBirth(formatter.parse(jsonObj.getString("dateOfBirth")));
		return customer;
	}
	//calling Rest API By browser
	//http://localhost:8080/springrest/Regcustomer/?data={id:1111,firstName:sanjeet,lastName:sanju,email:djohn@gmail.com,mobile:121-232-3435,dateOfBirth:7-Jun-2013}
	@GetMapping(value = "/Regcustomer")
	public @ResponseBody Customer createCustomerBrowser(HttpServletRequest request,HttpServletResponse res,ModelAndView model) throws JSONException, ParseException {
		//String  jsonString="{\"id\":11010,\"firstName\":\"sanjeet\",\"lastName\":\"sanju\",\"email\":\"djohn@gmail.com\",\"mobile\":\"121-232-3435\",\"dateOfBirth\":\"7-Jun-2013\"}";
		String data = request.getParameter("data");
		JSONObject jsonObj=new JSONObject(data);
		Customer customer=new Customer();
		customer.setId(jsonObj.getLong("id"));
		customer.setFirstName(jsonObj.getString("firstName"));
		customer.setLastName(jsonObj.getString("lastName"));
		customer.setEmail(jsonObj.getString("email"));
		customer.setMobile(jsonObj.getString("mobile"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		customer.setDateOfBirth(formatter.parse(jsonObj.getString("dateOfBirth")));
		return customer;
	}
	
	
	
	
	
	
	
	
	

}
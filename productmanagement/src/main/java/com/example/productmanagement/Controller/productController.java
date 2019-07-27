package com.example.productmanagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.productmanagement.model.product;
import com.example.productmanagement.service.SupplyServiceProxy;
import com.example.productmanagement.service.impl.productserviceimpl;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;



@RestController

public class productController {
	@Autowired
	private productserviceimpl psi;
	@Autowired
	private SupplyServiceProxy ssp;
	@Autowired 
	private EurekaClient e;
//	@Autowired
//	private RestTemplate rt;
	
	@PostMapping(value ="/addproduct/")
	public ResponseEntity<product> addProduct(@RequestBody product p)
	{
		product pr=psi.addProduct(p);
		return new ResponseEntity<product>(pr,HttpStatus.OK);
		
		
		
	}

	@GetMapping(value="/viewallproducts/")
	
	public ResponseEntity<List<product>> getAllProducts()
	{
		List<product> l=psi.getAllProducts();
		return new ResponseEntity<List<product>>(l,HttpStatus.OK);
	
	}
	@GetMapping(value="/viewproductbyid/{id}")
	
	public  ResponseEntity<product> getProductById(@PathVariable("id") String id )
	{
		product l=psi.getProductById(id);
		return new ResponseEntity<product>(l,HttpStatus.OK);
	}
	@GetMapping(value="/checkproductexistencebyid/{id}")
	public ResponseEntity<Boolean> checkProductExistenceById(@PathVariable("id") String id)
	{
		boolean result=false;
		result=psi.checkProductExistenceById(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@PutMapping(value="/updateProduct/{id}")
	public ResponseEntity<product> updateproduct(@PathVariable("id") String id,@RequestBody product p)
	{
		product pr=psi.updateproduct(p,id);
		return new ResponseEntity<product>(pr,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteProduct/{id}")
	public ResponseEntity<Boolean> deleteproduct(@PathVariable("id") String id)
	{
		boolean result=false;
		//System.out.println()
		
//		Application app = e.getApplication("zuulgateway");
//		InstanceInfo instanceInfo = app.getInstances().get(0);
//	
//        String url = "http://localhost:8089/supplyservice/checkproductentry/"+id;
//	
//		System.out.println(rt.getForObject(url,boolean.class));
//		//ResponseEntity<String> ans=rt.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<String>());
//		boolean ans = rt.getForObject(url,boolean.class);
		ResponseEntity<Boolean> res =ssp.checkProductExistenceById(id);
		boolean ans=res.getBody();
		if(ans==false)
		{
		result=psi.deleteproduct(id);
		}
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	
}

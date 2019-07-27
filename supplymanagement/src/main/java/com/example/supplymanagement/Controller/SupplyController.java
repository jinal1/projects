package com.example.supplymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplymanagement.model.supply;
import com.example.supplymanagement.service.ProductServiceProxy;
import com.example.supplymanagement.service.VenderServiceProxy;
import com.example.supplymanagement.service.impl.SupplyServiceImpl;



@RestController
public class SupplyController {
	@Autowired
	private SupplyServiceImpl psi;
	@Autowired
	private ProductServiceProxy psp;
	@Autowired
	private VenderServiceProxy vsp;
	
	@PostMapping(value ="/addsupply/")
	public ResponseEntity<supply> addSupply(@RequestBody supply p)
	{
		String pId=p.getProductId();
		
		boolean pexist=psp.checkProductExistenceById(pId).getBody();
		String vId=p.getVendorId();
		boolean vexist=vsp.checkVendorExistenceById(vId).getBody();
		supply pr=null;
		if(pexist && vexist)
		{
			 pr=psi.addSupply(p);
		}
		
		return new ResponseEntity<supply>(pr,HttpStatus.OK);
		
		
		
	}
	@GetMapping(value="/viewallsupply/")
	public ResponseEntity<List<supply>> getAllSupply()
	{
		List<supply> l=psi.getAllSupply();
		return new ResponseEntity<List<supply>>(l,HttpStatus.OK);
	
	}
	@GetMapping(value="/viewsupplybyid/{id}")
	
	public  ResponseEntity<supply> getSupplyById(@PathVariable("id") String id )
	{
		supply l=psi.getSupplyById(id);
		return new ResponseEntity<supply>(l,HttpStatus.OK);
	}
	@GetMapping(value="/checkproductentry/{id}")
	public ResponseEntity<Boolean> checkProductExistenceById(@PathVariable("id") String id)
	{
		boolean result=false;
		result=psi.checkProductExistenceById(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@GetMapping(value="/checkvendorentry/{id}")
	public ResponseEntity<Boolean> checkVendorExistenceById(@PathVariable("id") String id)
	{
		boolean result=false;
		result=psi.checkVendorExistenceById(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteSupply/{id}")
	public ResponseEntity<Boolean> deleteSupply(@PathVariable("id") String id)
	{
		boolean result=true;
		result=psi.deleteSupply(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
}

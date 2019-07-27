package com.example.vendermanagement.Controller;

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

import com.example.vendermanagement.model.vendor;
import com.example.vendermanagement.service.impl.VendorServiceImpl;



@RestController
public class vendorController {
	@Autowired
	private VendorServiceImpl vsi;
	@Autowired
	private com.example.vendermanagement.service.SupplyServiceProxy ssp;
	@PostMapping(value ="/addvendor/")
	public ResponseEntity<vendor> addVendor(@RequestBody vendor p)
	{
		vendor pr=vsi.addVendor(p);
		return new ResponseEntity<vendor>(pr,HttpStatus.OK);
		
		
		
	}
	@GetMapping(value="/viewallvendors/")
	public ResponseEntity<List<vendor>> getAllVendors()
	{
		List<vendor> l=vsi.getAllVendors();
		return new ResponseEntity<List<vendor>>(l,HttpStatus.OK);
	
	}
	@GetMapping(value="/viewvendorbyid/{id}")
	
	public  ResponseEntity<vendor> getVendorById(@PathVariable("id") String id )
	{
		vendor l=vsi.getVendorById(id);
		return new ResponseEntity<vendor>(l,HttpStatus.OK);
	}
	@GetMapping(value="/checkvendorexistencebyid/{id}")
	public ResponseEntity<Boolean> checkVendorExistenceById(@PathVariable("id") String id)
	{
		boolean result=false;
		result=vsi.checkVendorExistenceById(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@PutMapping(value="/updateVendor/{id}")
	public ResponseEntity<vendor> updatevendor(@PathVariable("id") String id,@RequestBody vendor p)
	{
		vendor pr=vsi.updatevendor(p,id);
		return new ResponseEntity<vendor>(pr,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteVendor/{id}")
	public ResponseEntity<Boolean> deletevendor(@PathVariable("id") String id)
	{
		boolean result=false;
		ResponseEntity<Boolean> res =ssp.checkVendorExistenceById(id);
		boolean ans=res.getBody();
		if(!ans)
		{
		result=vsi.deletevendor(id);
		}
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
}

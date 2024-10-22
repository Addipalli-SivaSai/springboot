package ltts.com.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ltts.com.DTO.ProductDTO;
import ltts.com.Exception.ProductNotFoundException;
import ltts.com.Model.Product;
import ltts.com.Service.ProductService;

@RestController

public class ProductContoller {

	
	  private ProductService productService;
	    public ProductContoller(ProductService productService) {
	        this.productService=productService;
	    }
	    @GetMapping("/")
	    public ResponseEntity<List<Product>> Greet(){
	    	
	    	
	    	return new ResponseEntity<>(productService.getProduct(),HttpStatus.FOUND);
	    }
	    @GetMapping("/{productId}")
	    public ResponseEntity<Optional> GeyById(@PathVariable int productId){
	    	
	    	return new ResponseEntity<>(productService.getProductbyId(productId),HttpStatus.OK);
	    }
	   
	    
	    @PostMapping("/addProducts")
	    public Product AddProduct(@RequestBody Product product)
	    {
	    	return productService.createProduct(product);
	    }
	    
	    
	    @DeleteMapping("/delete/{pId}")
	    public ResponseEntity<String>  DeleteProduct(@PathVariable int pId)
	    {
	    	boolean response=productService.deleteProduct(pId);
	    	
	    	if(response)
	    	{
	    		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
	    	}
	    	else {
	    		return new ResponseEntity<>("No records deletes",HttpStatus.BAD_REQUEST);
	    	}
	    }
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> UpdateProduct(@RequestBody Product product,@PathVariable int id)
	    {
	    	try {
	    		
	    		var product1=productService.updateProduct(product,id);
	    		if(product1==null)
	    		{
		    		return new ResponseEntity<>("no records found",HttpStatus.NOT_FOUND);

	    		}
	    		return new ResponseEntity<>(product1,HttpStatus.BAD_REQUEST);

	    		
	    	}
	    	catch(Exception ex)
	    	{
	    		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    	}
	    	
		
	    	
	    }
	    
	    @GetMapping("/searchProduct")
	    public ResponseEntity<List<Product>> SearchProduct(@RequestParam String searchItem)
	    {
	         
	    	return new ResponseEntity<>(productService.searchProduct(searchItem),HttpStatus.OK);
	    	
	    }
	    @GetMapping("/getprod")
	    public ResponseEntity<List<String>> getString()
	    {
	         
	    	List<String> name=new ArrayList<String>();
	    	name.add("siva");
	    	name.add("sai");
	    	name.add("4001");
	    	return new ResponseEntity<>(name,HttpStatus.OK);
	    	
	    }
	    
	    @GetMapping("/productdto/{p_Id}")
	    public ResponseEntity<ProductDTO> GeyByIdUsingDto(@PathVariable int p_Id){
	    	
	    	var response=productService.getProductbyIdusingDTO(p_Id);
	    	System.out.println("wsderfv"+response);
	    	if(response==null)
	    	{
	    	 throw new ProductNotFoundException("Produc with this Id "+p_Id+" is not found");
	    	}
	    	else {
	    	
	    	return new ResponseEntity<ProductDTO>(response,HttpStatus.OK);
	    	}
	    }
	    
}

package ltts.com.Practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import ltts.com.Model.Product;
import ltts.com.Repositry.ProductRepo;
import ltts.com.Service.ProductService;

@SpringBootTest
class PracticeApplicationTests {


	   @Mock
	   private ProductRepo productRepo;
	  
	     @InjectMocks
	   private ProductService productService;
	     
	   @Test
	   
	   public void FirstTest()
	   {
		   List<Product> TestProduct=new ArrayList();
		   
		   TestProduct.add(new Product(101,"Nike Jordons",8000.00));
		    
		   when(productRepo.findAll()).thenReturn(TestProduct);
		   
		   assertEquals(1,productService.getProduct().size());
	   }
	     
	   @Test
	   public void SecondTest()
	   {
			 List<Product> TestProduct=new ArrayList();

			TestProduct.add(new Product(101,"Nike Jordons",8000.00));  
           TestProduct.add(new Product(102,"Nike Jordons 201",9000.00));  
    	   TestProduct.add(new Product(103,"Addidas",8000.00));  

		   int productID=102;
		   Optional<Product> expected_list=TestProduct.stream().filter(p->p.getProductId()==productID).findFirst();
		   
		   when(productRepo.findById(productID)).thenReturn(expected_list); 
//		   Product fin=productService.getProductbyId(productID).get();
//           assertEquals(101,productService.getProductbyId(productID).get().getProductId());
	       assertEquals("Nike Jordons 201",productService.getProductbyId(productID).get().getProductName());
	       assertEquals(9000.00,productService.getProductbyId(productID).get().getProductPrice());
	      

	       
	   }
	   
	   
	 @Test

	   
	   public void ThirdTest()
	   { 
		 List<Product> TestProduct=new ArrayList();
	   
	   TestProduct.add(new Product(101,"Nike Jordons",8000.00));  
	   TestProduct.add(new Product(102,"Nike Jordons 201",9000.00));  
	   TestProduct.add(new Product(103,"Addidas",8000.00));  

       String product_name="Nike Jordons";

	    List<Product> expected_list=TestProduct.stream().filter(p->p.getProductName().contains(product_name)).
	    		collect(Collectors.toList());
	    
          when(productRepo.searchByProductName(product_name)).thenReturn(expected_list);
          
          
           assertEquals(2, productService.searchProduct(product_name).size());
          
          
		  
	   }
	 
	 
	 @Test 
	 
	 public void Testfour()
	 {
		 
	 }

}

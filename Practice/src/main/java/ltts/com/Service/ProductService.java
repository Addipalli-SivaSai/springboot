package ltts.com.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltts.com.DTO.ProductDTO;
import ltts.com.Model.Product;
import ltts.com.Repositry.ProductRepo;
import ltts.com.Exception.ProductNotFoundException;


@Service
public class ProductService {
	
	private ProductRepo productRepo;
	   @Autowired
	    private ModelMapper modelMapper;
	
	public ProductService(ProductRepo productRepo)
	{
		this.productRepo=productRepo;
	}

	public List<Product> getProduct() {
		
//	System.out.println(productRepo.findAll().size());
	
		// TODO Auto-generated method stub
		return productRepo.findAll();
		
	}

	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	public boolean deleteProduct(int pId) {
		
//		if(!(productRepo.findById(pId).isEmpty()))
//		{
//			productRepo.deleteById(pId);
//		}
//		return true;
		
       var product=	productRepo.findById(pId);
       
//       System.out.println(product);
       
       if(!(product.isEmpty()))
       {
    	   productRepo.deleteById(pId);
    	   return true;
       }
       else {
    	   return false;
       }
		
		
	}

	public Product updateProduct(Product product, int id) {
		
//		System.out.println(product.getProductName()+" "+id);

		if(product.getProductId()==id)
		{
		    Optional<Product> p1=productRepo.findById(id);
		    Product p2=p1.get();
			p2.setProductName(product.getProductName());
			p2.setProductPrice(product.getProductPrice());
			
			return productRepo.save(p2);
		}
		else
		{
			return null;
		}
	}

	public List<Product> searchProduct(String ProductName) {
		
		return productRepo.searchByProductName(ProductName);
	}

	public Optional<Product> getProductbyId(int productId) {
		
		return productRepo.findById(productId);
	}

	public ProductDTO getProductbyIdusingDTO(int p_Id) {
	
		 Product p1 = productRepo.findById(p_Id).orElseThrow(()->new ProductNotFoundException("Product is not founf for this ID "+p_Id));
		
	        ProductDTO productDto =modelMapper.map(p1, ProductDTO.class);
	        return productDto;
		
	
	}
       
}

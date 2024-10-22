package ltts.com.DTO;

public class ProductDTO {
	   private String product_Name;

	    private double product_Price;
	    
	    public ProductDTO() {
		      
		    }



		public String getProductName() {
			return product_Name;
		}

		public void setProductName(String productName) {
			this.product_Name = productName;
		}

		public double getProductPrice() {
			return product_Price;
		}

		public void setProductPrice(double productPrice) {
			this.product_Price = productPrice;
		}
}

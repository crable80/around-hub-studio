package studio.thinkground.aroundhub.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import studio.thinkground.aroundhub.data.dto.ProductDto;
import studio.thinkground.aroundhub.data.entity.ProductEntity;
import studio.thinkground.aroundhub.data.handler.impl.ProductDataHandlerImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {
	
	@MockBean
	ProductDataHandlerImpl productDataHandler;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Test
	public void getProductTest() {
		//given
		Mockito.when(productDataHandler.getProductEntity("123"))
			.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.getProduct("123");
		
		assertEquals(productDto.getProductId(), "123");
		assertEquals(productDto.getProductName(), "pen");
		assertEquals(productDto.getProductPrice(), 2000);
		assertEquals(productDto.getProductStock(), 3000);
		
		//verify(productDataHandler).getProductEntity("123");
			
	}
	
	@Test
	public void saveProductEntity() {
		//given
		Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
			.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);
		
		assertEquals(productDto.getProductId(), "123");
		assertEquals(productDto.getProductName(), "pen");
		assertEquals(productDto.getProductPrice(), 2000);
		assertEquals(productDto.getProductStock(), 3000);
		
		//verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);
	}
	
}

package Proj;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class test {
   @InjectMocks 
   calculator calc= new calculator();
   @Mock
   services service;
   @Test
   public void testAdd(){

      //Assert function called
      when(service.add(30,40)).thenReturn(70);
      Assert.assertEquals(calc.add(5, 20),25,0);

      Assert.assertEquals(calc.subtract(15, 25),40,0);

      Assert.assertEquals(calc.multiply(10, 20),200,0);
      
      Assert.assertEquals(calc.divide(16, 22),2,0);
   }
}
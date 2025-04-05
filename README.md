
John McGinnes


C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.


-Modified mainscreen.html Line 28, changed to <h1>John's Computer Shop</h1>

-Modified mainscreen.html Line 23, <title>John's Computer Shop</title>

-Modified mainscreen.html Line 13 - 22, added a style section to modify the formatting for elements on the page with the following code:

  <style>
        h1, h2, form {
            text-align: center;
            padding: 20px;
        }
        .center-container {
            text-align: center;
            padding: 20px;
        }
    </style>



D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.


-Created about.html file in the "templates" folder to include the following on lines 1-35 - 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Our Company</title>
    <style>
        h1, p{
            text-align: center;
            padding: 20px;
        }
        p{
            border: 2px solid #000;
            margin-left: 80px;
            margin-right: 80px;
        }
        .center-container {
            text-align: center;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>
    About Our Company
</h1>
<p>
  Welcome to John's Computer Shop! We strive to be your destination for computer parts and custom-built PC's.
  We are passionate about providing the highest quality components at a reasonable price. Whether you are upgrading,
  building a PC from scratch, or just seeking advice on the latest technology, we are here to help!
</p>
<div class = "center-container">
<a href="http://localhost:8080/"> Return Home</a>
</div>
</body>
</html>

-Modified mainscreen.html Lines 29-31, added the following code:

 <div class = "center-container">
        <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About Our Company</a>
    </div>

-Modified MainScreenControllerr.java Line 57-60, added the following code:

@GetMapping("/about")
public String about() {
return "about";
}


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

-Modified BootStrapData.java Lines 70-131, added sample inventory with the following code:

    if(partRepository.count() == 0) {
            InhousePart superRam = new InhousePart();
            superRam.setName("24 GB RAM");
            superRam.setPrice(70.00);
            superRam.setInv(5);

            InhousePart superGPU = new InhousePart();
            superGPU.setName("Super-Deluxe GPU");
            superGPU.setPrice(400.00);
            superGPU.setInv(5);

            InhousePart basicGPU = new InhousePart();
            basicGPU.setName("Basic GPU");
            basicGPU.setPrice(200.00);
            basicGPU.setInv(5);

            InhousePart speakers = new InhousePart();
            speakers.setName("Speakers");
            speakers.setPrice(20.00);
            speakers.setInv(5);

            InhousePart basicRam= new InhousePart();
            basicRam.setName("8 GB RAM");
            basicRam.setPrice(30.00);
            basicRam.setInv(5);

            partRepository.save(superRam);
            partRepository.save(superGPU);
            partRepository.save(basicGPU);
            partRepository.save(speakers);
            partRepository.save(basicRam);
            }
        if(outsourcedPartRepository.count() == 0) {
            OutsourcedPart superCpu = new OutsourcedPart();
            superCpu.setName("Quad Core CPU");
            superCpu.setPrice(700.00);
            superCpu.setInv(5);

            OutsourcedPart basicCpu = new OutsourcedPart();
            basicCpu.setName("Dual Core CPU");
            basicCpu.setPrice(400.00);
            basicCpu.setInv(5);

            outsourcedPartRepository.save(superCpu);
            outsourcedPartRepository.save(basicCpu);
        }

        if(productRepository.count() == 0) {
            Product gamingPC = new Product("Gaming PC", 1000.00, 10);
            Product mediaPC = new Product("Media PC", 400.00, 10);
            Product basicPC = new Product("Basic PC", 200.00, 10);
            Product serverPC = new Product("Server PC", 300.00, 10);
            Product deluxeGamingPC = new Product("Deluxe Gaming PC", 2000.00, 10);

            productRepository.save(gamingPC);
            productRepository.save(mediaPC);
            productRepository.save(basicPC);
            productRepository.save(serverPC);
            productRepository.save(deluxeGamingPC);


        }


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


-Created PurchaseSuccess.html with the following code on lines 1-25:

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Purchase Successful!</title>
  <style>
    h1{
      text-align: center;
      padding: 20px;
    }
     .center-container {
      text-align: center;
      padding: 20px;
    }
  </style>
</head>
<body>
<h1>
  Purchase Successful!
</h1>
<div class = "center-container">
  <a href="http://localhost:8080/"> Return Home</a>
</div>
</body>
</html>

Created PurchaseError.html with the following code on lines 1-25:

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Purchase Error</title>
    <style>
        h1{
            text-align: center;
            padding: 20px;
        }
        .center-container {
            text-align: center;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>
    Purchase Error. Inventory Insufficient.
</h1>
<div class = "center-container">
    <a href="http://localhost:8080/"> Return Home</a>
</div>
</body>
</html>

-Modified mainscreen.html Line 103, added button to purchase product:

<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>

-AddProductController.java Lines 177-192, added the following code:

@Autowired
private ProductService productService;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId, Model theModel ){
        Product product2 = productService.findById(theId);

        boolean purchaseConfirmation = product2.buyProduct();
        if(purchaseConfirmation) {
            productService.save(product2);
            theModel.addAttribute("message", "Purchase successful!");
            return "PurchaseSuccess";
        }
        theModel.addAttribute("message", "Purchase failed!");
        return "PurchaseError";
    }

-Product.java Lines Lines 108-115, added the following code:

public boolean buyProduct() {
if (this.inv >= 1) {
this.inv--;
return true;
} else {
return false;
}
}


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.

-Modified mainscreen.html Lines 53-54, added the following code:

<th>Minimum</th>
<th>Maximum</th>

-Modified mainscreen.html Lines 64-65, added the following code:

<td th:text="${tempPart.minimum}" > 1 </td>
<td th:text="${tempPart.maximum}" > 1 </td>

•  Modify the sample inventory to include the maximum and minimum fields.

-Modified Part.java Lines 35-37, added the following code:

@Min (value = 0, message = "Minimum must be > 0")
int minimum;
int maximum;

-Modified Part.java Lines 109-120, added the following code:

public void setMinimum(int minimum){
this.minimum = minimum;
}
public void setMaximum(int maximum){
this.maximum = maximum;
}
public int getMinimum(){
return this.minimum;
}
public int getMaximum(){
return this.maximum;
}

-Modified InhousePart.java Lines 18-19, added the following code:

this.minimum = 0;
this.maximum = 100;

-Modified OutsourcedPart.java Lines 18-19, added the following code:

this.minimum = 0;
this.maximum = 100;

•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

-Modified OutsourcedPartForm.html Lines 25-35, added the following code:

<p> <input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

<p> <input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

 <p>
    <div th:if="${#fields.hasAnyErrors()}">
        <ul> <li th:each="err: ${#fields.allErrors()}" th:text="${err}"> </li> </ul>
    </div>
    </p>

-Modified InhousePartForm.html Lines 26-36, added the following code:

<p> <input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/></p>

<p> <input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/></p>

<p> <input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/></p>

<p> <div th:if="${#fields.hasAnyErrors()}">
<ul> <li th:each="err: ${#fields.allErrors()}" th:text="${err}"> </li> </ul>
</div>
</p>


•  Rename the file the persistent storage is saved to.

-Modified application.properties Line 6, changed code to the following:

spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102

•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

-Modified Part.java Lines 91-98, added the following code:

public void validateLimits(){
if (this.inv < this.minimum){
this.inv = this.minimum;
}
else if (this.inv > this.maximum){
this.inv = this.maximum;
}
}

-Modified OutsourcedPartServiceImpl.java Line 53, added the following code:

thePart.validateLimits();

-Modified InhousePartServiceImpl.java Line 55, added the following code:

thePart.validateLimits();


H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:

-Modified Part.java Lines 21-22, added the following code:

@ValidPartInventory
@ValidPartInventoryMinimum


•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.

-Created PartInventoryMinimumValidator.java and added the following code to lines 1-24:

package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartInventoryMinimumValidator implements ConstraintValidator < ValidPartInventoryMinimum, Part > {
@Autowired
private ApplicationContext context;

public static ApplicationContext myContext;
@Override
public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
ConstraintValidator.super.initialize(constraintAnnotation);
}

@Override
public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
return part.getInv() >= part.getMinimum();
}
}


-Created ValidPartInventoryMinimum.java and added the following code to lines 1-18:

package com.example.demo.validators;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;


@Constraint(validatedBy = {PartInventoryMinimumValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPartInventoryMinimum {
String message() default "Inventory can not be lower than minimum inventory";
Class [] groups() default {};
Class [] payload() default {};

}

•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.

NOTE: This conflicts with section F, as the "Buy Now" button should not change the parts inventory. If the parts that are associated with products were able to change
when the product inventory decreases, I would adjust the buyProduct() method accordingly. No validator required for this case.

•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

-Created PartInventoryValidator.java and added the following code to lines 1-25:

package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartInventoryValidator implements ConstraintValidator < ValidPartInventory, Part > {
@Autowired
private ApplicationContext context;

public static ApplicationContext myContext;

@Override
public void initialize(ValidPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

@Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
return part.getInv() <= part.getMaximum();
    }
}

-Created ValidPartInventory.java and added the following code to lines 1-20:

package com.example.demo.validators;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;


@Constraint(validatedBy = {PartInventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPartInventory {
String message() default "Inventory can not be higher than maximum inventory";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};

}

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

-Modified PartTest.java Lines 160-176, added the following code:

@Test
void getMinimum() {
int minimum = 5;
partIn.setMinimum(minimum);
assertEquals(minimum,partIn.getMinimum());
partOut.setMinimum(minimum);
assertEquals(minimum,partOut.getMinimum());
}

@Test
void getMaximum(){
int maximum=5;
partIn.setMaximum(maximum);
assertEquals(maximum,partIn.getMaximum());
partOut.setMaximum(maximum);
assertEquals(maximum,partOut.getMaximum());
}

J.  Remove the class files for any unused validators in order to clean your code.

DeletePartValidator - 0 Usages (Deleted)
EnufPartsValidator - 1 Usage
PartInventoryMinimumValidator - 1 Usage
PartInventoryValidator - 1 Usage
PriceProductValidator - 1 Usage
ValidDeletePart - 4 Usages
ValidEnufParts - 4 Usages
ValidPartInventory - 4 Usages
ValidPartInventoryMinimum - 4 Usages
ValidProductPrice - 4 Usages
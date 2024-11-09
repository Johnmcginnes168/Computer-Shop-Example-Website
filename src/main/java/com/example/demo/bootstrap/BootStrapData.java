package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */
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
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

package lv.tsi.webshop.resource;

import lv.tsi.webshop.models.Product;
import lv.tsi.webshop.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/product")
    public class ProductController {

        private final ProductRepository repository;

        @Autowired
        public ProductController(ProductRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public ResponseEntity<Iterable<Product>> findProduct() {

            return ResponseEntity.ok(repository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> findProduct(@PathVariable Long id) {
            return ResponseEntity.of(repository.findById(id));
        }


    }

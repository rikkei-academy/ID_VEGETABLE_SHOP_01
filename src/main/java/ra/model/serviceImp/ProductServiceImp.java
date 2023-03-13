package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.repository.ProductRepository;
import ra.model.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> finAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product finByProductId(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> searchByProductNameContainingOrProductID(String productName, int productId) {
        return productRepository.searchByProductNameContainingOrProductID(productName,productId);
    }

    @Override
    public List<Product> sortByProductName(String productName) {
        if (productName.equals("asc")){
            return productRepository.findAll(Sort.by("productName").ascending());
        }else {
            return productRepository.findAll(Sort.by("productName").descending());
        }
    }

    @Override
    public List<Product> sortByNameAndId(String sendirectName, String sendirectId) {
        return null;
    }

    @Override
    public Page<Product> getPaggingProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}

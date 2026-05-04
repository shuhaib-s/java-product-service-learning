package com.practieceproject.todoproject.service;

 import com.practieceproject.todoproject.Dto.FakestoreDto;
 import com.practieceproject.todoproject.Expections.ProductNotFoundException;
 import com.practieceproject.todoproject.model.Category;
 import com.practieceproject.todoproject.model.Product;
 import org.springframework.core.ParameterizedTypeReference;
 import org.springframework.http.HttpMethod;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;
 import org.springframework.web.client.RestTemplate;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    private String baseUrl = "https://fakestoreapi.com/products";
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, Category category) {
        FakestoreDto newProduct = new FakestoreDto();

        newProduct.setId(id);
        newProduct.setTitle(title);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setImage(imageUrl);
        newProduct.setCategory(category.getName());
        FakestoreDto pr = restTemplate.postForObject(baseUrl, newProduct, FakestoreDto.class);
        return  pr.getProduct();


    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        ResponseEntity<FakestoreDto> f = restTemplate.getForEntity(baseUrl+"/"+id, FakestoreDto.class);
        if(f.getBody() == null){
           throw new ProductNotFoundException("Product not found "+ id);
        }
        return f.getBody().getProduct();

    }


    @Override
    public List<Product> getAllProduct() {
        ResponseEntity<List<FakestoreDto>> result = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FakestoreDto>>() {
                });
        List<Product> p = new ArrayList<>();
        if(result.getBody() == null){
            return  null;
        }
//        for(FakestoreDto f: result.getBody()){
//            p.add(f.getProduct());
//        }
        return result.getBody().stream().map(FakestoreDto::getProduct).toList();
    }

    @Override
    public Product updateProduct(Long id,String title, String description, Double price, String imageUrl, Category category) {
        FakestoreDto newProduct = new FakestoreDto();

        newProduct.setId(id);
        newProduct.setTitle(title);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setImage(imageUrl);
        newProduct.setCategory(category.getName());
        restTemplate.put(baseUrl+"/"+id,newProduct,FakestoreDto.class);
        return newProduct.getProduct();
    }

    @Override
    public String deleteProduct(Long id) {
       restTemplate.delete(baseUrl +"/"+id);
       return "deleted sucessfully";
    }
    public String sample(){
        return "this is probblem";
    }
}

package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;
import ra.model.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @GetMapping
    public List<Catalog> getAllCatalog(){
        return catalogService.findAllCatalog();
    }

    @GetMapping("/{catalogId}")
    public Catalog getCatalogById(@PathVariable("catalogId") int catalogId){
        return catalogService.findCatalogById(catalogId);
    }

    @PostMapping("/createCatalog")
    public Catalog saveAndUpdate(@RequestBody  Catalog catalog){
        Catalog catalogNew =new Catalog();
        LocalDate time =LocalDate.now();
        catalogNew.setCreateDate(time);
        catalogNew.setCatalogName(catalog.getCatalogName());
        catalogNew.setDecription(catalog.getDecription());
        catalogNew.setStatus(true);
        catalogNew.setParentID(catalog.getParentID());
        return catalogService.saveAndUpdate(catalogNew);
    }


    @PutMapping("/update/{catalogId}")
    public Catalog updateCatalog(@PathVariable("catalogId")int catalogId,@RequestBody Catalog catalog) {
        Catalog catalogUpdate = catalogService.findCatalogById(catalogId);
        LocalDate time =LocalDate.now();
        catalogUpdate.setCatalogName(catalog.getCatalogName());
        catalogUpdate.setCreateDate(time);
        catalogUpdate.setStatus(catalog.isStatus());
        catalogUpdate.setDecription(catalog.getDecription());
        catalogUpdate.setParentID(catalog.getParentID());
    return catalogService.saveAndUpdate(catalogUpdate);
    }
     @DeleteMapping("/delete/{catalogId}")
     public ResponseEntity<?> deleteCatelog(@PathVariable("catalogId")int catalogId){
        Catalog catalog = catalogService.findCatalogById(catalogId);
        catalog.setStatus(false);
        catalogService.saveAndUpdate(catalog);
        return ResponseEntity.ok("???? x??a th??nh c??ng");
     }

     @GetMapping("/search")
    public ResponseEntity<List<Catalog>>SearchByNameOrId(@RequestParam("catalogName")String catalogName,
                                                         @RequestParam("catalogId")int catalogId){
                 List<Catalog>catalogList=catalogService.searchByNameOrId(catalogName,catalogId);
                 return new ResponseEntity<>(catalogList, HttpStatus.OK);

     }
     @GetMapping("/sort")
    public ResponseEntity<List<Catalog>>sortByName(@RequestParam("catalogName")String catalogName){
        List<Catalog> catalogList =catalogService.sortByCatalogName(catalogName);
        return new ResponseEntity<>(catalogList,HttpStatus.OK);
     }
     @GetMapping("/pagging")
   public ResponseEntity<Map<String,Object>>getPagging(@RequestParam(defaultValue = "0")int page,
                                                       @RequestParam(defaultValue = "3")int size){
        Pageable pageablePagging=PageRequest.of(page,size);
        Page<Catalog> catalogPage = catalogService.getPaggingCatalog(pageablePagging);
        Map<String,Object> data= new HashMap<>();
        data.put("catalogName",catalogPage.getContent());
        data.put("size",catalogPage.getSize());
        data.put("iteml",catalogPage.getTotalElements());
        data.put("page",catalogPage.getTotalPages());
        return new ResponseEntity<>(data,HttpStatus.OK);
   }



}

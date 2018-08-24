package spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_rest.dao.AppCategoriesDao;
import spring_rest.model.AppCategory;

import java.util.Arrays;
import java.util.List;

import static spring_rest.controller.Endpoints.*;

@RestController
//@RequestMapping("/sities")
public class CategoriesController {

    private static final String VERSION = VERSION_1_URL;

    @Autowired
    private AppCategoriesDao appCategoriesDao;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<String> findCities() {
        return Arrays.asList("Odessa", "Kiyv");
    }

    @GetMapping("/" + VERSION + "/" + CATEGORIES_URL)
    public List<AppCategory> getAppCategories() {
        return appCategoriesDao.list();
    }

    @GetMapping("/" + VERSION + "/" + CATEGORIES_URL + "/{id}")
    public ResponseEntity getAppCategory(@PathVariable("id") Long id) {

        AppCategory category = appCategoriesDao.get(id);
        if (category == null) {
            return new ResponseEntity<>("No AppCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping(value = "/" + VERSION + "/" + CATEGORIES_URL)
    public ResponseEntity createAppCategory(@RequestBody AppCategory category) {

        appCategoriesDao.create(category);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/" + VERSION + "/" + CATEGORIES_URL + "/{id}")
    public ResponseEntity deleteAppCategory(@PathVariable Long id) {

        if (null == appCategoriesDao.delete(id)) {
            return new ResponseEntity<>("No AppCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PutMapping("/" + VERSION + "/" + CATEGORIES_URL + "/{id}")
    public ResponseEntity updateAppCategory(@PathVariable Long id, @RequestBody AppCategory category) {

        category = appCategoriesDao.update(category);

        if (null == category) {
            return new ResponseEntity<>("No AppCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }



}

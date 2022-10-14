package com.usa.palcosappfinal1.controller;

import com.usa.palcosappfinal1.model.Box;
import com.usa.palcosappfinal1.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getAll();

    }
    @GetMapping("/{idBox}")
    public Optional<Box> getById(@PathVariable("idBox") Integer id){
        return boxService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save (@RequestBody Box box){
        return boxService.save(box);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update(@RequestBody Box box){
        return boxService.update(box);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer id){
        return boxService.delete(id);
    }
}

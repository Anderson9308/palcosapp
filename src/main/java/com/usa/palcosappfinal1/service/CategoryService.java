package com.usa.palcosappfinal1.service;

import com.usa.palcosappfinal1.model.Category;
import com.usa.palcosappfinal1.repository.CategoryRepository;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){return categoryRepository.getAll();
    }
    public Optional<Category> getById(Integer id){
        return categoryRepository.getById(id);
    }
    public Category save (Category category){
        if (category.getId()==null){
    return categoryRepository.save(category);
        }else{
            Optional<Category> optional = categoryRepository.getById(category.getId());
            if(optional.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    public Category update (Category category) {
        if (category.getId() != null) {
            Optional<Category> optional = categoryRepository.getById(category.getId());
            if (!optional.isEmpty()) {
                if (category.getName() != null) {
                    optional.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    optional.get().setDescription(category.getDescription());
                }
                categoryRepository.save(optional.get());
                return optional.get();
            } else {
                return category;
            }

        } else {
            return category;
        }
    }
    public boolean delete (Integer id){
        Boolean aBoolean=getById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

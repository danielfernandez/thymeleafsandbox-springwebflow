package com.example.demo.database;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.models.RegisterModel;
import org.springframework.stereotype.Component;

@Component
public class RegisterDatabase {

    private final ConcurrentHashMap<String, RegisterModel> registerMap;


    public RegisterDatabase() {
        super();
        this.registerMap = new ConcurrentHashMap<>();
    }


    public void add(@NotNull final RegisterModel registerModel) {
        this.registerMap.put(registerModel.getPersonalInfo().getUsername(), registerModel);
    }

    public boolean contains(@NotEmpty final String userName) {
        return this.registerMap.contains(userName);
    }

    public RegisterModel get(@NotEmpty final String userName) {
        return this.registerMap.get(userName);
    }

    public Collection<RegisterModel> list() {
        return this.registerMap.values();
    }

}

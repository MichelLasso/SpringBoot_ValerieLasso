package com.example.helloworld.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApiController{
    // mensaje inicial
    @GetMapping("/")
    public String saludar(){
        return "Home de campers";
    }
    // endpoint /saludo
    @GetMapping("/saludo") // http://localhost:8080/saludo?Name=%20Valerie&LastName=Lasso
    public String saludo(@RequestParam(name= /* Este es el del host*/"Name", required= true ) String name,
                         @RequestParam(name= "LastName", required= false, defaultValue = "Common last name") String lastName){
        return "Hello, my name is " + name + " " + lastName + " !!";
    }

    // endpoint /search
    @GetMapping("/search") // http://localhost:8080/search
    public Map<String, String> search(
        @RequestParam(name= "name", defaultValue = "") String name
    ){
        Map<String, String> cities= new HashMap<>();
        cities.put("BUC", "Bucaramanga");
        cities.put("NVA", "Neiva");
        cities.put("NYC", "New York");
        cities.put("BOG","Bogota");
        cities.put("LET", "Leticia");
        cities.put("PER", "Pereira");

        // http://localhost:8080/search?name=BUC
        if(cities.containsKey(name)){
            // para retornar el mapa porq el método retorna un mapa// porq el get retorna un string
            return Map.of(name, cities.get(name));
        } else {
            return cities;
        }
    }

    // endpoint /tax
    @GetMapping("/tax") // http://localhost:8080/tax
    public Map<String, Object> calculate(
        @RequestParam(value= "values", defaultValue = "0") double values
    ){
        List<Producto> products= new ArrayList<>(List.of(new Producto(1, "Pan", 2000)));
        products.add(new Producto(2, "Coca-cola", 3000));
        products.add(new Producto(3, "Soup", 3000));

        double total=0;
        double porcentageVat=0;
        double iva=0;
        double totalVat=0;

        for(Producto p : products){
            total+= p.getPrice();
        }
        // http://localhost:8080/tax?values=10
        if (values>0) {
            porcentageVat= values/100;
            iva=  porcentageVat * total;
            totalVat= total + iva;
        }
        return Map.of("Products", products, "total", totalVat, "valor_neto", total);

    }

    // endpoint /tax2
    @GetMapping("/tax2") // http://localhost:8080/tax2
    public Map<String, Object> calculate2(
        @RequestParam(value= "values", defaultValue = "0") double taxes
    ){
        List<Producto> products= new ArrayList<>(List.of(new Producto(1, "Pan", 2000)));
        products.add(new Producto(2, "Coca-cola", 3000));
        products.add(new Producto(3, "Soup", 3000));

        //lamda
        double prices = products.stream().map(p-> p.getPrice()).reduce(0.0, (PrecioA, PrecioB) -> PrecioA + PrecioB);
        return Map.of("Products", products, "total",(prices + (prices * (taxes/ 100))), "valor_neto", prices);

    }
}
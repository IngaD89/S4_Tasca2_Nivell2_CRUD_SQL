package cat.itacademy.s04.t02.n02.S04T02N02.controller;

import cat.itacademy.s04.t02.n02.S04T02N02.model.Fruit;
import cat.itacademy.s04.t02.n02.S04T02N02.services.FruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruits")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit){
        Fruit fruitToSave = fruitService.saveFruit(fruit);
        return ResponseEntity.status(201).body(fruitToSave);
    }

    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        List<Fruit> fruitList = fruitService.getAllFruits();
        return ResponseEntity.ok(fruitList);
    }

    @GetMapping("/fruits/{id}")
    public ResponseEntity<Optional<Fruit>> getFruitById(@PathVariable Long id){
        Optional<Fruit> fruit = fruitService.getFruitById(id);
        return ResponseEntity.ok(fruit);
    }

    @DeleteMapping("/fruits/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id){
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/fruits/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody Fruit fruitDetails) {
        Fruit updatedFruit = fruitService.updateFruit(id, fruitDetails);
        return ResponseEntity.ok(updatedFruit);
    }
}

package cat.itacademy.s04.t02.n02.S04T02N02.services;

import cat.itacademy.s04.t02.n02.S04T02N02.exception.ResourceNotFoundException;
import cat.itacademy.s04.t02.n02.S04T02N02.model.Fruit;
import cat.itacademy.s04.t02.n02.S04T02N02.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Long id, Fruit fruit) {
      Fruit fruitToUpdate = fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + id + " not found"));

        fruitToUpdate.setName(fruit.getName());
        fruitToUpdate.setWeight(fruit.getWeight());
        return fruitRepository.save(fruitToUpdate);
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Optional<Fruit> getFruitById(Long id) {
        return Optional.ofNullable(fruitRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + id + " not found")));
    }

    public void deleteFruit(Long id) {
        if(!fruitRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource with id: " + id + " not found");
        }
        fruitRepository.deleteById(id);
    }

}

package com.clinic.controller;

import com.clinic.model.Owner;
import com.clinic.repository.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
        if (owner == null) {
            return ResponseEntity.badRequest().build();  // Handle invalid input
        }
        Owner savedOwner = ownerRepository.save(owner);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        if (owners.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(owners);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        return ownerRepository.findById(id)
            .map(owner -> {
                owner.setName(ownerDetails.getName());
                owner.setContact(ownerDetails.getContact());  
                owner.setAddress(ownerDetails.getAddress());  
                return ResponseEntity.ok(ownerRepository.save(owner));
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        if (!ownerRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner not found");
        }
        ownerRepository.deleteById(id);
        return ResponseEntity.ok("Owner deleted successfully");
    }
}





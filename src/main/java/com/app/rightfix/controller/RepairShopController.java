package com.app.rightfix.controller;

import com.app.rightfix.dto.Response;
import com.app.rightfix.entity.RepairShop;
import com.app.rightfix.service.RepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repairshop/api/v1")
@CrossOrigin(origins = "*")
public class RepairShopController {
    private final RepairShopService repairShopService;

    @Autowired
    public RepairShopController(RepairShopService repairShopService) {
        this.repairShopService = repairShopService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createRepairShop(@RequestBody RepairShop repairShop) {
        repairShopService.saveRepairShop(repairShop);
        Response response = new Response(HttpStatus.OK.value(), "successfully", repairShop);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRepairShopById(@PathVariable Long id) {
        RepairShop repairShop = repairShopService.getRepairShopById(id);
        if (repairShop != null) {
            Response response = new Response(HttpStatus.OK.value(), "successfully", repairShop);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<RepairShop>> getAllRepairShop() {
        List<RepairShop> repairShop = repairShopService.getAllRepairShop();
        return ResponseEntity.ok().body(repairShop);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateRepairShop(@PathVariable Long id, @RequestBody RepairShop repairShop) {
        RepairShop itemRepairShop = repairShopService.getRepairShopById(id);
        if (itemRepairShop != null) {
            repairShop.setId(id);
            repairShopService.updateRepairShop(repairShop);
            Response response = new Response(HttpStatus.OK.value(), "successfully", repairShop);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRepairShop(@PathVariable Long id) {
        RepairShop repairShop = repairShopService.getRepairShopById(id);
        if (repairShop != null) {
            repairShopService.deleteRepairShop(id);
            Response response = new Response(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

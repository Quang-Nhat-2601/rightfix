package com.app.rightfix.controller;

import com.app.rightfix.dto.response.ApiResponse;
import com.app.rightfix.entity.RepairShop;
import com.app.rightfix.service.RepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repairshop/api/v1")
public class RepairShopController {
    private final RepairShopService repairShopService;
    @Autowired
    public RepairShopController(RepairShopService repairShopService) {
        this.repairShopService = repairShopService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRepairShop(@RequestBody RepairShop repairShop) {
        repairShopService.saveRepairShop(repairShop);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairShop);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getRepairShopById(@PathVariable Long id) {
        RepairShop repairShop = repairShopService.getRepairShopById(id);
        if (repairShop != null) {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairShop);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<RepairShop>> getAllRepairShop() {
        List<RepairShop> repairShop = repairShopService.getAllRepairShop();
        return ResponseEntity.ok().body(repairShop);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateRepairShop(@PathVariable Long id, @RequestBody RepairShop repairShop) {
        RepairShop itemRepairShop = repairShopService.getRepairShopById(id);
        if (itemRepairShop != null) {
            repairShop.setId(id);
            repairShopService.updateRepairShop(repairShop);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairShop);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteRepairShop(@PathVariable Long id) {
        RepairShop repairShop = repairShopService.getRepairShopById(id);
        if (repairShop != null) {
            repairShopService.deleteRepairShop(id);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
}

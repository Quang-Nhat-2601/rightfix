package com.app.rightfix.controller;

import com.app.rightfix.dto.response.ApiResponse;
import com.app.rightfix.entity.RepairHistory;
import com.app.rightfix.service.RepairHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repairhistory/api/v1")
public class RepairHistoryController {
    private final RepairHistoryService repairHistoryService;
    @Autowired
    public RepairHistoryController(RepairHistoryService repairHistoryService) {
        this.repairHistoryService = repairHistoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRepairHistory(@RequestBody RepairHistory repairHistory) {
        repairHistoryService.saveRepairHistory(repairHistory);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairHistory);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getRepairHistoryById(@PathVariable Long id) {
        RepairHistory repairHistory = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory != null) {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairHistory);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<RepairHistory>> getAllRepairHistory() {
        List<RepairHistory> repairHistory = repairHistoryService.getAllRepairHistory();
        return ResponseEntity.ok().body(repairHistory);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateRepairHistory(@PathVariable Long id, @RequestBody RepairHistory repairHistory) {
        RepairHistory repairHistory1 = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory1 != null) {
            repairHistory.setId(id);
            repairHistoryService.updateRepairHistory(repairHistory);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", repairHistory);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteRepairHistory(@PathVariable Long id) {
        RepairHistory repairHistory = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory != null) {
            repairHistoryService.deleteRepairHistory(id);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
}

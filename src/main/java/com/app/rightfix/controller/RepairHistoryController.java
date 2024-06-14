package com.app.rightfix.controller;

import com.app.rightfix.dto.Response;
import com.app.rightfix.entity.RepairHistory;
import com.app.rightfix.service.RepairHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repairhistory/api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class RepairHistoryController {
    private final RepairHistoryService repairHistoryService;

    @Autowired
    public RepairHistoryController(RepairHistoryService repairHistoryService) {
        this.repairHistoryService = repairHistoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createRepairHistory(@RequestBody RepairHistory repairHistory) {
        repairHistoryService.saveRepairHistory(repairHistory);
        Response response = new Response(HttpStatus.OK.value(), "successfully", repairHistory);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRepairHistoryById(@PathVariable Long id) {
        RepairHistory repairHistory = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory != null) {
            Response response = new Response(HttpStatus.OK.value(), "successfully", repairHistory);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<RepairHistory>> getAllRepairHistory() {
        List<RepairHistory> repairHistory = repairHistoryService.getAllRepairHistory();
        return ResponseEntity.ok().body(repairHistory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateRepairHistory(@PathVariable Long id, @RequestBody RepairHistory repairHistory) {
        RepairHistory repairHistory1 = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory1 != null) {
            repairHistory.setId(id);
            repairHistoryService.updateRepairHistory(repairHistory);
            Response response = new Response(HttpStatus.OK.value(), "successfully", repairHistory);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRepairHistory(@PathVariable Long id) {
        RepairHistory repairHistory = repairHistoryService.getRepairHistoryById(id);
        if (repairHistory != null) {
            repairHistoryService.deleteRepairHistory(id);
            Response response = new Response(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

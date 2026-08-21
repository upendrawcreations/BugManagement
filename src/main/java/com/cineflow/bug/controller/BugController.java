package com.cineflow.bug.controller;
import com.cineflow.bug.dto.*; import com.cineflow.bug.service.BugService; import jakarta.validation.Valid; import java.util.UUID; import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.data.web.PageableDefault; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/bugs") @RequiredArgsConstructor public class BugController {
  private final BugService service;
  @PostMapping public ResponseEntity<BugResponse> create(@Valid @RequestBody BugRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
  @GetMapping("/{id}") public BugResponse get(@PathVariable UUID id){return service.get(id);}
  @GetMapping public Page<BugResponse> list(@RequestParam(required=false)UUID versionId,@RequestParam(required=false)Long statusId,@RequestParam(required=false)Long priorityId,@RequestParam(required=false)String query,@PageableDefault(size=20,sort="createdAt",direction=Sort.Direction.DESC)Pageable pageable){return service.list(versionId,statusId,priorityId,query,pageable);}
  @PutMapping("/{id}") public BugResponse update(@PathVariable UUID id,@Valid @RequestBody BugRequest request){return service.update(id,request);}
  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable UUID id){service.delete(id);}
}

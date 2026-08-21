package com.cineflow.bug.controller;
import com.cineflow.bug.dto.*; import com.cineflow.bug.service.BugDetailService; import jakarta.validation.Valid; import java.util.*; import lombok.RequiredArgsConstructor; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile;
@RestController @RequestMapping("/api/v1/bugs/{bugId}") @RequiredArgsConstructor public class BugDetailController {
  private final BugDetailService service;
  @PostMapping("/frames") @ResponseStatus(HttpStatus.CREATED) public FrameResponse addFrame(@PathVariable UUID bugId,@Valid @RequestBody FrameRequest request){return service.addFrame(bugId,request);}
  @GetMapping("/frames") public List<FrameResponse> frames(@PathVariable UUID bugId){return service.frames(bugId);}
  @DeleteMapping("/frames/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deleteFrame(@PathVariable UUID bugId,@PathVariable UUID id){service.deleteFrame(bugId,id);}
  @PostMapping("/annotations") @ResponseStatus(HttpStatus.CREATED) public AnnotationResponse addAnnotation(@PathVariable UUID bugId,@Valid @RequestBody AnnotationRequest request){return service.addAnnotation(bugId,request);}
  @GetMapping("/annotations") public List<AnnotationResponse> annotations(@PathVariable UUID bugId){return service.annotations(bugId);}
  @DeleteMapping("/annotations/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deleteAnnotation(@PathVariable UUID bugId,@PathVariable UUID id){service.deleteAnnotation(bugId,id);}
  @PostMapping(value="/attachments",consumes=MediaType.MULTIPART_FORM_DATA_VALUE) @ResponseStatus(HttpStatus.CREATED) public FileResponse attachment(@PathVariable UUID bugId,@Valid @RequestPart("metadata") AttachmentMetadata metadata,@RequestPart("file")MultipartFile file){return service.addAttachment(bugId,metadata,file);}
  @PostMapping(value="/references",consumes=MediaType.MULTIPART_FORM_DATA_VALUE) @ResponseStatus(HttpStatus.CREATED) public FileResponse reference(@PathVariable UUID bugId,@RequestPart(value="fileUrl",required=false)String fileUrl,@RequestPart("file")MultipartFile file){return service.addReference(bugId,fileUrl,file);}
  @GetMapping("/files") public List<FileResponse> files(@PathVariable UUID bugId){return service.files(bugId);}
  @DeleteMapping("/attachments/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deleteAttachment(@PathVariable UUID bugId,@PathVariable UUID id){service.deleteAttachment(bugId,id);}
  @DeleteMapping("/references/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deleteReference(@PathVariable UUID bugId,@PathVariable UUID id){service.deleteReference(bugId,id);}
}

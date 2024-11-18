package iyteyazilim.projects.digitalcard.controller;

import iyteyazilim.projects.digitalcard.entity.Comment;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
import iyteyazilim.projects.digitalcard.service.impl.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/createComment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
            Comment addedComment = commentService.addComment(comment);
            return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
        }

        @GetMapping("/getComments")
        public ResponseEntity<List<Comment>> getComments() {
            List<Comment> comments = commentService.getComments();
            return ResponseEntity.ok(comments);
        }

        @GetMapping("/getComment/{id}")
        public ResponseEntity<Comment> getComment(@PathVariable("id") Long id) {
            Comment comment = commentService.getComment(id);
            return ResponseEntity.ok(comment);
        }
        @PutMapping("/updateComment/{id}")
        public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id,
                                                        @RequestBody Comment updatedComment) {
            Comment comment = commentService.updateComment(id, updatedComment);
            return ResponseEntity.ok(comment);
        }

        @DeleteMapping("/deleteComment/{id}")
        public ResponseEntity<String> deleteComment(@PathVariable("id") Long id) {
            try {
                commentService.deleteComment(id);
                return ResponseEntity.ok("Comment deleted successfully.");
            } catch (ResourceNotFoundException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }

        }
    }

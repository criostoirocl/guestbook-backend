package com.example.guestbookbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final MySQLCommentDao mySQLCommentDao;

    public CommentController(MySQLCommentDao mySQLCommentDao) {
        this.mySQLCommentDao = mySQLCommentDao;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "")
    public ResponseEntity<String> saveComment(@RequestBody SaveComment saveComment){
        System.out.println(saveComment.getComment());
        Comment comment = new Comment(saveComment.getComment());
        mySQLCommentDao.save(comment);
        return ResponseEntity.ok("Saved");
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "")
    public ResponseEntity<Iterable<Comment>> getComments(){
        var comments = mySQLCommentDao.getComments();
        return ResponseEntity.ok(comments);
    }
}

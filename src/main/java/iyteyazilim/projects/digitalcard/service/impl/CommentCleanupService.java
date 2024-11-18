package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CommentCleanupService {

    @Autowired
    private ICommentRepository commentRepository;

    // Bu metod her gün gece yarısında çalışır (saat 00:00)
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteAllCommentsAtEndOfDay() {
        commentRepository.deleteAll();
        System.out.println("All comments deleted at the end of the day.");
    }
}
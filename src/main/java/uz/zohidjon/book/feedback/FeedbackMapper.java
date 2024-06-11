package uz.zohidjon.book.feedback;

import org.springframework.stereotype.Service;
import uz.zohidjon.book.book.Book;

import java.util.Objects;

@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {
        Book book = Book.builder()
                .id(request.bookId())
                .archived(false)
                .shareable(false)
                .build();

        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(book)
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}

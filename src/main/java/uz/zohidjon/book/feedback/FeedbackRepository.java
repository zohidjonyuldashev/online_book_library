package uz.zohidjon.book.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query("from Feedback f where f.book.id = :bookId")
    Page<Feedback> findAllByBookId(Integer bookId, Pageable pageable);
}
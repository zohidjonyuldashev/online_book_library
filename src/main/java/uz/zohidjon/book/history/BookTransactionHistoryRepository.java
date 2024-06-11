package uz.zohidjon.book.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.zohidjon.book.book.Book;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query("from BookTransactionHistory history where history.user.Id = :userId")
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);

    @Query("from BookTransactionHistory history where history.book.owner.Id = :userId")
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);

    @Query("""
            select (count(*) > 0) as isBorrowed
            from BookTransactionHistory history
            where history.user.Id = :userId
            and history.book.id = :bookId
            and history.returnedApproval = false""")
    boolean isAlreadyBorrowedByUser(Integer bookId, Integer userId);

    @Query("""
            from BookTransactionHistory history
            where history.user.Id = :userId
            and history.book.id = :bookId
            and history.returned = false
            and history.returnedApproval = false""")
    Optional<BookTransactionHistory> findByBookIdAndUserId(Integer bookId, Integer userId);

    @Query("""
            from BookTransactionHistory history
            where history.book.owner.Id = :userId
            and history.book.id = :bookId
            and history.returned = true
            and history.returnedApproval = false""")
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Integer bookId, Integer userId);
}